package Logic;

public class Seeds extends Food{
    public Seeds(){
        super();
    }
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.SEMILLAS;
    }
}