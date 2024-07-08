package Logic;


public class Apple extends Food {
    public Apple(){
        super();
    }
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.MANZANA;
    }
}