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
                        new MessageWindow("Un animal de tu granja a muerto");
                        deleteAnimal(animalsInTheHabitat.get(i));
                    }
                }
            }
        }, 0, 3000, TimeUnit.MILLISECONDS);
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
            return true;
        }
        return false;
    }

    //Hay cosas que hacer
    public boolean checkIfFoodCorrespondsToDeposit(Food food){
        return food.getFoodType() == this.foodDeposit.getDepositType();
    }

    /**
     * Función que checkea si un habitat está activo (o sea tiene animales)
     * @return booleano con el valor de isActive
     */
    public boolean checkIsHabitatActive(){
        return this.isActive;
    }

    //todo Esta funcion colocarla en scheduler de PanelPrincipal cuando se implemente el vender animales
    public void checkAndDeactivateHabitatIfIsEmpty(){
        if (checkIsHabitatActive() && actualAnimalQuantity == 0){
            isActive = false;
            habitatType = null;
        }
    }

    /**
     * Función que checkea si un habitat está lleno comparandolo con una constante
     * @return booleano que indica si el habitat está lleno o no
     */
    public boolean checkIfHabitatIsFull(){
        return this.actualAnimalQuantity == MAX_CAPACITY;
    }

    public boolean checkIfDepositIsFull(){
        return this.foodDeposit.getActualFoodInDeposit() == MAX_FOOD;
    }

    public void fullReset(){
        isActive = false;
        actualAnimalQuantity = 0;
        foodDeposit.getFoodDeposit().clear();
        foodDeposit.setDepositTypeNull();
        habitatType = null;
        animalsInTheHabitat.clear();
        PlayerInfo.getInstance().setStats(3, 0);
    }

    public void setActive(){
        this.isActive = true;
    }

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

    public void deleteAnimal(Animal animal){
        if (animalsInTheHabitat.contains(animal)){
            animalsInTheHabitat.remove(animal);
            actualAnimalQuantity  -= 1;
        }
    }

    public void increaseAnimalLimit(){
        this.MAX_CAPACITY++;
    }

    public void increaseMaxFoodLimit(){
        this.MAX_FOOD += 10;
    }

    public FoodDeposit getFoodDeposit() {
        return foodDeposit;
    }

    public int getFoodReserve(){
        return MAX_FOOD;
    }

    public void setHitboxDeposit(HitboxDeposit hitboxDeposit){
        this.hitboxDeposit = hitboxDeposit;
    }

    public HitboxDeposit getHitboxDeposit(){
        return this.hitboxDeposit;
    }

    public static boolean getFamily() {
        return family;
    }
}