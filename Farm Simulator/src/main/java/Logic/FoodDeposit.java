package Logic;

import Interface.*;

import java.util.ArrayList;

/**
 * Clase de tipo FoodDeposit, se encarga crear un array list que guarda un tipo de comida
 */
public class FoodDeposit {
    private final ArrayList<Food> foodInDeposit;
    private FoodTypes depositType;

    /**
     * Metodo constructor, crea el deposito para guardar la comida, por defecto este se crea tipo nulo
     */
    public FoodDeposit(){
        this.foodInDeposit = new ArrayList<>();
        this.depositType = null;
    }

    /**
     * Metodo que entrega el deposito de comida
     * @return foodInDeposit de tipo ArrayList<Food>, corresponde al deposito de comida
     */
    public ArrayList<Food> getFoodDeposit(){
        return foodInDeposit;
    }

    /**
     * Metodo encargado de agregar comida al deposito, y sobrepasar el limite de su capacidad, agrega 20 de comida
     * @param food de tipo Food, es un tipo de comida correspondiente al tipo de deposito
     * @param maxHabitatFoodQuantity de tipo int, indica la capacidad maxima del deposito
     */
    public void addFood(Food food, int maxHabitatFoodQuantity) {
        if (getActualFoodInDeposit() <= maxHabitatFoodQuantity - 20) {
            for (int i = 0; i < 20; i++) {
                this.foodInDeposit.add(food);
                PlayerInfo.getInstance().addToStat(3, 1);
            }
        } else {
            for (int i = 0; i < maxHabitatFoodQuantity - getActualFoodInDeposit(); i++) {
                this.foodInDeposit.add(food);
                new MessageWindow("Comprando menos comida por el mismo precio (deposito casi lleno)");
                PlayerInfo.getInstance().addToStat(3, 1);
            }
        }
    }

    /**
     * Metodo encargado de quitar comida del deposito, por ejemplo cuando un animal come de este
     */
    public void removeFood(){
        foodInDeposit.removeLast();
        PlayerInfo.getInstance().addToStat(3, -1);
    }

    /**
     * Metodo getter, nos entrega la cantidad actual de comida en el deposito
     * @return int que es la cantidad de comida en el deposito
     */
    public int getActualFoodInDeposit(){
        return this.foodInDeposit.size();
    }

    /**
     * Metodo encargado de asignarle un tipo comida que puede recibir el deposito
     * @param animal de tipo Animal, se usa para ver su tipo y asi asignarla el tipo al deposito, respecto a
     *               lo que el animal puede comer
     */
    public void setDepositType(Animal animal) {
        switch(animal.getAnimalType()){
            case VACAS, OVEJA -> this.depositType = FoodTypes.TRIGO;
            case CERDO -> this.depositType = FoodTypes.ZANAHORIA;
            case CABRA -> this.depositType = FoodTypes.MAIZ;
            case GALLINA -> this.depositType = FoodTypes.SEMILLAS;
            case CABALLO -> this.depositType = FoodTypes.MANZANA;
        }
    }

    /**
     * Metodo setter, asigna tipo null el deposito
     */
    public void setDepositTypeNull(){
        depositType = null;
    }

    /**
     * Metodo getter, sirve para saber de que tipo es nuestro deposito
     * @return depositType de tipo FoodTypes, que indica el tipo de comida que recibe el deposito
     */
    public FoodTypes getDepositType(){
        return this.depositType;
    }
}