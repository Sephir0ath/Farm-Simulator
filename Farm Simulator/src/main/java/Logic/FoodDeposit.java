package Logic;

import Interface.*;

import java.util.ArrayList;

public class FoodDeposit {
    private final ArrayList<Food> foodInDeposit;
    private FoodTypes depositType;

    public FoodDeposit(){
        this.foodInDeposit = new ArrayList<>();
        this.depositType = null;
    }

    public ArrayList<Food> getFoodDeposit(){
        return foodInDeposit;
    }

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

    public void removeFood(){
        foodInDeposit.removeLast();
        PlayerInfo.getInstance().addToStat(3, -1);
    }

    public int getActualFoodInDeposit(){
        return this.foodInDeposit.size();
    }

    public void setDepositType(Animal animal) {
        switch(animal.getAnimalType()){
            case VACAS, OVEJA -> this.depositType = FoodTypes.TRIGO;
            case CERDO -> this.depositType = FoodTypes.ZANAHORIA;
            case CABRA -> this.depositType = FoodTypes.MAIZ;
            case GALLINA -> this.depositType = FoodTypes.SEMILLAS;
            case CABALLO -> this.depositType = FoodTypes.MANZANA;
        }
    }

    public void setDepositTypeNull(){
        depositType = null;
    }

    public FoodTypes getDepositType(){
        return this.depositType;
    }
}