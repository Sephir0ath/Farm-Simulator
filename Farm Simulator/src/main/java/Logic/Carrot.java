package Logic;

public class Carrot extends Food{
    public Carrot(){
        super();
    }
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.ZANAHORIA;
    }
}