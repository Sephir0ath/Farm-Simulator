package Logic;

import Exceptions.*;

import java.util.ArrayList;

/**
 * Clase que representa la logica de un habitat
 */
public class Habitat {
    private boolean isActive;
    private int MAX_CAPACITY = 5;
    private int MAX_FOOD = 50;
    private int actualCapacity;
    private AnimalTypes habitatType;
    private ArrayList<Animal> animalsInTheHabitat;
    private int foodReserve;

    /**
     * Constructor de la clase, inicializa todos los parametros necesarios de un habitat
     */
    public Habitat(){
        this.isActive = false;
        this.animalsInTheHabitat = new ArrayList<>();
        this.foodReserve = MAX_FOOD;
        this.habitatType = null;
        this.actualCapacity = 0;
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
        return actualCapacity;
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

    /**
     * Función que checkea si un habitat está activo (o sea tiene animales)
     * @return booleano con el valor de isActive
     */
    public boolean checkIsHabitatActive(){
        return this.isActive;
    }

    //todo Esta funcion colocarla en scheduler de PanelPrincipal cuando se implemente el vender animales
    public void checkAndDeactivateHabitatIfIsEmpty(){
        if (checkIsHabitatActive() && actualCapacity == 0){
            isActive = false;
            habitatType = null;
        }
    }

    /**
     * Función que checkea si un habitat está lleno comparandolo con una constante
     * @return booleano que indica si el habitat está lleno o no
     */
    public boolean checkIfHabitatIsFull(){
        return this.actualCapacity == MAX_CAPACITY;
    }

    public void fullReset(){
        isActive = false;
        animalsInTheHabitat.clear();
        actualCapacity = 0;
        habitatType = null;
    }

    public void setActive(){
        this.isActive = true;
    }

    public void addAnimalToHabitat(Animal animal) throws FullCapacityException, AnimalTypeDifferentFromHabitatTypeException {
        if (checkIfAnimalCorrespondsToHabitat(animal)){
            if (!checkIfHabitatIsFull()) {
                this.animalsInTheHabitat.add(animal);
                this.actualCapacity += 1;
            }
            else{
                throw new FullCapacityException();
            }
        }
        else{
            throw new AnimalTypeDifferentFromHabitatTypeException();
        }
    }

    // todo implementar esta funcion cuando los animales se puedan vender y tener hambre
    public void removeDeadAnimals(){
        for (int i = animalsInTheHabitat.size() - 1; 0 < i; i--){  // Ir borrando elementos desde atrás hacia delante para evitar problemas con
            if (animalsInTheHabitat.get(i).checkIfAnimalFoodIsZero()){
                animalsInTheHabitat.remove(animalsInTheHabitat.get(i));
            }
        }
    }

    public void increaseAnimalLimit(){
        this.MAX_CAPACITY++;
    }

    public void increaseMaxFoodLimit(){
        this.MAX_FOOD += 10;
    }

    public int getFoodReserve(){
        return foodReserve;
    }
}