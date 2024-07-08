package Logic;

import Exceptions.*;

import java.util.ArrayList;

public class Habitat {
    private boolean isActive;
    private final int MAX_CAPACITY = 5;
    private final int INITIAL_FOOD = 10;
    private int actualCapacity;
    private AnimalTypes habitatType;
    private ArrayList<Animal> animalsInTheHabitat;
    private int foodReserve;

    public Habitat(){
        this.isActive = false;
        this.animalsInTheHabitat = new ArrayList<>();
        this.foodReserve = INITIAL_FOOD;
        this.habitatType = null;
        this.actualCapacity = 0;

    }

    public ArrayList<Animal> getAnimalsInTheHabitat(){
        return animalsInTheHabitat;
    }

    public int getAnimalQuantity(){
        return actualCapacity;
    }

    public boolean checkIfAnimalCorrespondsToHabitat(Animal animal){
        if (this.habitatType == null || animal.getAnimalType() == this.habitatType){
            this.habitatType = animal.getAnimalType();
            return true;
        }
        return false;
    }

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

    public AnimalTypes getHabitatType(){
        return habitatType;
    }

    public int getFoodReserve(){
        return foodReserve;
    }
}