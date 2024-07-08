package Logic;

public enum AnimalTypes {
    GALLINA("Pollo", 100, 0.1),
    VACAS("Vaca" ,250, 0.2),
    CABRA("Cabra", 500, 0.5),
    OVEJA("Oveja", 500, 0.3),
    CERDO("Cerdo", 350, 0.5),
    CABALLO("Caballo", 7000, 10);

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