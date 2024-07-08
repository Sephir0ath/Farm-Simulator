package Logic;

public enum AnimalTypes {
    GALLINA("Chicken", 100, 0.1),
    VACAS("Cow" ,250, 0.2),
    CABRA("Goat", 500, 0.5),
    OVEJA("Sheep", 500, 0.3),
    CERDO("Pig", 350, 0.5),
    CABALLO("Horse", 7000, 10);

    private final String animal;
    private final int price;
    private final double moneyDrop;
    AnimalTypes(String animal, int price, double moneyDrop){
        this.animal = animal;
        this.price = price;
        this.moneyDrop = moneyDrop;
    }

    public String getAnimal(){
        return animal;
    }

    public int getPrice(){
        return price;
    }

    public double getMoneyDrop(){
        return moneyDrop;
    }
}