package Logic;

public enum AnimalTypes {
    GALLINA("Chicken", 100),
    VACAS("Cow" ,250),
    CABRA("Goat", 500),
    OVEJA("Sheep", 500),
    CERDO("Pig", 350),
    CABALLO("Horse", 7000);

    private final String animal;
    private final int price;

    AnimalTypes(String animal, int price){
        this.animal = animal;
        this.price = price;
    }

    public String getAnimal(){
        return animal;
    }

    public int getPrice(){
        return price;
    }
}