package Logic;

/**
 * Enum con los tipos de animales del simulador
 */
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

    /**
     * Constructor del enum
     * @param animal String con el nombre del animal
     * @param price Int con el precio del animal
     * @param moneyDrop Double con la cantidad de dinero que da al jugador por tick
     */
    AnimalTypes(String animal, int price, double moneyDrop){
        this.animal = animal;
        this.price = price;
        this.moneyDrop = moneyDrop;
    }

    /**
     * Funcion que retorna el nombre de un animal
     * @return String con el nombre del animal
     */
    public String getAnimal(){
        return animal;
    }

    /**
     * Función que retorna el precio de compra de un animal
     * @return int con el precio del animal
     */
    public int getPrice(){
        return price;
    }

    /**
     * Función que retorna el valor que le da el animal al jugador por cada tick
     * @return int con el dinero que da al jugador
     */
    public double getMoneyDrop(){
        return moneyDrop;
    }
}