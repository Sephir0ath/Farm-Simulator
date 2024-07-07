package Logic;

public enum AnimalTypes {
    GALLINA("Chicken", 100, Chicken.class),
    VACAS("Cow" ,250, Cow.class),
    CABRA("Goat", 500, Goat.class),
    OVEJA("Sheep", 500, Sheep.class),
    CERDO("Pig", 350, Pig.class),
    CABALLO("Horse", 7000, Horse.class);

    private final String animal;
    private final int price;
    private Class<? extends Animal> animalClass;

    AnimalTypes(String animal, int price, Class<? extends Animal> animalClass){
        this.animal = animal;
        this.price = price;
        this.animalClass = animalClass;
    }

    public String getAnimal(){
        return animal;
    }

    public int getPrice(){
        return price;
    }
}