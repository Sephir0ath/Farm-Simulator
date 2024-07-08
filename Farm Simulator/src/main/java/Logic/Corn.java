package Logic;

public class Corn extends Food{
    public Corn(){
        super();
    }
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.MAIZ;
    }
}