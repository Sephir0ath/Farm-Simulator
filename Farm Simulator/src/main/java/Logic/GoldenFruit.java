package Logic;

public class GoldenFruit extends Food{
    public GoldenFruit(){
        super();
    }
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.FRUTA_DORADA;
    }
}