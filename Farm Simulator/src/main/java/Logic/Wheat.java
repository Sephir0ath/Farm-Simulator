package Logic;

public class Wheat extends Food{
    public Wheat(){
        super();
    }
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.TRIGO;
    }
}