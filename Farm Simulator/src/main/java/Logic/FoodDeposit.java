package Logic;

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

    public void addFood(Food food){
        this.foodInDeposit.add(food);
    }

    public void removeFood(Food food){
        this.foodInDeposit.remove(food);
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

    public FoodTypes getDepositType(){
        return this.depositType;
    }
}