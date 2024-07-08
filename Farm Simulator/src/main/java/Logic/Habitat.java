package Logic;

import Exceptions.*;
import Interface.*;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Clase que representa la logica de un habitat
 */
public class Habitat {
    private boolean isActive;
    private int MAX_CAPACITY = 5;
    private int MAX_FOOD = 60;
    private int actualAnimalQuantity;
    private AnimalTypes habitatType;
    private ArrayList<Animal> animalsInTheHabitat;
    private FoodDeposit foodDeposit;
    private HitboxDeposit hitboxDeposit;
    private static boolean family;

    /**
     * Constructor de la clase, inicializa todos los parametros necesarios de un habitat
     */
    public Habitat(){
        this.isActive = false;
        this.foodDeposit = new FoodDeposit();
        this.animalsInTheHabitat = new ArrayList<>();
        this.habitatType = null;
        this.actualAnimalQuantity = 0;
        family = false;

        ScheduledExecutorService eatScheduler = new ScheduledThreadPoolExecutor(1);
        eatScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < animalsInTheHabitat.size(); i++){
                    if(animalsInTheHabitat.get(i).eat(foodDeposit.getActualFoodInDeposit())){
                        foodDeposit.removeFood();
                    }
                }

            }
        }, 0, 1000, TimeUnit.MILLISECONDS);


        ScheduledExecutorService hungerScheduler = new ScheduledThreadPoolExecutor(1);
        hungerScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < animalsInTheHabitat.size(); i++){
                    animalsInTheHabitat.get(i).loseFood();
                    if (animalsInTheHabitat.get(i).checkIfAnimalFoodIsZero()){
                        new MessageWindow("Un animal de tu granja Ha muerto");
                        deleteAnimal(animalsInTheHabitat.get(i));
                    }
                }
            }
        }, 0, 4500, TimeUnit.MILLISECONDS);
    }

    /**
     * Función que retorna todos los animales que habitan en la instancia del habitat
     * @return ArrayList<Animal> con las instancias de los animales
     */
    public ArrayList<Animal> getAnimalsInTheHabitat(){
        return animalsInTheHabitat;
    }

    /**
     * Función que retorna la cantidad de animales que hay en el habitat
     * @return valor tipo int con la cantidad de animales en el habitat
     */
    public int getAnimalQuantity(){
        return actualAnimalQuantity;
    }

    /**
     * Getter que obtiene la capacidad máxima actual del habitat.
     * @return int MAX_CAPACITY del habitat.
     */
    public int getAnimalQuantityLimit(){
        return MAX_CAPACITY;
    }

    /**
     * Función que retorna el tipo de animal que contiene
     * @return valor tipo AnimalTypes con el tipo de animal que contiene
     */
    public AnimalTypes getHabitatType(){
        return habitatType;
    }

    /**
     * Función que checkea si un animal que se pasa como parametro corresponde al tipo de animal que se puede colocar en ese habitat
     * @param animal Parametro tipo Animal que representa uno de los posibles animales
     * @return booleano indicando si son el mismo tipo de animal
     */
    public boolean checkIfAnimalCorrespondsToHabitat(Animal animal){
        if (this.habitatType == null || animal.getAnimalType() == this.habitatType){
            this.habitatType = animal.getAnimalType();
            this.foodDeposit.setDepositType(animal);
            return true;
        }
        return false;
    }

    /**
     * Metodo que sirve para verifica si un alimento se puede añadir o no al deposito de comida del habitat
     * @param food de tipo Food, se usa para ver que tipo de comida es en comparacion con el tipo de deposito
     * @return boolean, indica si la comida recibida corresponde con el tipo de deposito de comida del habitat
     */
    public boolean checkIfFoodCorrespondsToDeposit(Food food){
        return food.getFoodType() == foodDeposit.getDepositType();
    }

    /**
     * Función que checkea si un habitat está activo (o sea tiene animales)
     * @return booleano con el valor de isActive
     */
    public boolean checkIsHabitatActive(){
        return this.isActive;
    }

    /**
     * Ve si un habitat no tiene animales, si es así, se desactiva el habitat.
     */
    public void checkAndDeactivateHabitatIfIsEmpty(){
        if (checkIsHabitatActive() && actualAnimalQuantity == 0){
            isActive = false;
            habitatType = null;
            foodDeposit = new FoodDeposit();
        }
    }

    /**
     * Función que checkea si un habitat está lleno comparandolo con una constante
     * @return booleano que indica si el habitat está lleno o no
     */
    public boolean checkIfHabitatIsFull(){
        return this.actualAnimalQuantity == MAX_CAPACITY;
    }

    /**
     * Método que revisa si el deposito de un habitat está lleno.
     * @return boolean que indica si está lleno o no.
     */
    public boolean checkIfDepositIsFull(){
        return this.foodDeposit.getActualFoodInDeposit() == MAX_FOOD;
    }

    /**
     * Método para realizar el reseteo total de los habitats.
     */
    public void fullReset(){
        isActive = false;
        actualAnimalQuantity = 0;
        foodDeposit.getFoodDeposit().clear();
        foodDeposit.setDepositTypeNull();
        habitatType = null;
        animalsInTheHabitat.clear();
        PlayerInfo.getInstance().setStats(3, 0);
    }

    /**
     * Setter que indica si el habitat está activo.
     */
    public void setActive(){
        this.isActive = true;
    }

    /**
     * Método para añadir un animal al habitat al comprarlo.
     * @param animal animal a añadir
     * @throws FullCapacityException cuando está lleno el habitat.
     * @throws AnimalTypeDifferentFromHabitatTypeException cuando el animal no pertenece al habitat.
     */
    public void addAnimalToHabitat(Animal animal) throws FullCapacityException, AnimalTypeDifferentFromHabitatTypeException {
        if (checkIfAnimalCorrespondsToHabitat(animal)){
            if (!checkIfHabitatIsFull()) {
                this.animalsInTheHabitat.add(animal);
                this.actualAnimalQuantity += 1;
                if (animalsInTheHabitat.size() >= 5) {
                    family = true;
                }
            }
            else {
                throw new FullCapacityException();
            }
        }
        else {
            throw new AnimalTypeDifferentFromHabitatTypeException();
        }
    }

    /**
     * Metodo de que se encarga de añadir comida al deposito de comida del habitat, en caso que se pueda
     * @param food de tipo Food, este se añadira al deposito de comida del habitat si es compatible con su tipo
     * @throws FullDepositException aparece si intentamos comprar comida y sobrepasamos la capacidad de deposito de comida
     * @throws FoodTypeDifferentFromHabitatTypeException aparece si intentamos comprar comida de un tipo que no coincide
     * con el tipo de deposito de comida
     * @throws HabitatTypeIsNullException aparece si intentamos comprar comida para un habitat vacio
     */
    public void addFoodToDeposit(Food food) throws FullDepositException, FoodTypeDifferentFromHabitatTypeException, HabitatTypeIsNullException {
        if(this.habitatType != null) {
            if (checkIfFoodCorrespondsToDeposit(food)) {
                if (!checkIfDepositIsFull()) {
                    this.foodDeposit.addFood(food, getFoodReserve());
                }
                else {
                    throw new FullDepositException();
                }
            }
            else {
                throw new FoodTypeDifferentFromHabitatTypeException();
            }
        }
        else {
        throw new HabitatTypeIsNullException();
        }
    }

    /**
     * Método para borrar un animal.
     * @param animal animal que eliminará.
     */
    public void deleteAnimal(Animal animal){
        if (animalsInTheHabitat.contains(animal)){
            animalsInTheHabitat.remove(animal);
            actualAnimalQuantity  -= 1;
        }
    }

    /**
     * Método para incrementar el límite de capacidad del habitat.
     */
    public void increaseAnimalLimit(){
        this.MAX_CAPACITY++;
    }

    /**
     * Método para incrementar el límite de comida de un deposito de habitat.
     */
    public void increaseMaxFoodLimit(){
        this.MAX_FOOD += 10;
    }

    /**
     * Metodo getter, entrega el deposito de comida del habitat
     * @return foodDeposit de tipo FoodDeposit contiene el deposito de comida del habitat
     */
    public FoodDeposit getFoodDeposit() {
        return foodDeposit;
    }

    /**
     * Getter que obtiene la comida maxima del deposito,
     * @return int MAX_FOOD comida maxima posible del deposito
     */
    public int getFoodReserve(){
        return MAX_FOOD;
    }

    /**
     * Metodo de tipo setter, guarda la hitbox del deposito de comida del habitat
     * @param hitboxDeposit de tipo HitboxDeposit, contiene la hitbox del deposito de comida del habitat
     */
    public void setHitboxDeposit(HitboxDeposit hitboxDeposit){
        this.hitboxDeposit = hitboxDeposit;
    }

    /**
     * Metodo de tipo getter, entrega la variable que contiene la hitbox del deposito de comida
     * @return hitboxDeposit de tipo HitboxDeposit, contiene la hitbox del deposito
     */
    public HitboxDeposit getHitboxDeposit(){
        return this.hitboxDeposit;
    }

    /**
     * Método para obtener logo AWholeFamily: si hay 5 animales en un habitat.
     * @return boolean que indica si se completó o no.
     */
    public static boolean getFamily() {
        return family;
    }
}