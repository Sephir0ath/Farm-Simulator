package Logic;

/**
 * Enum con los tipos de comida del simulador
 */
public enum FoodTypes {
    ZANAHORIA("Zanaho", 100),
    TRIGO("Trigo", 100),
    SEMILLAS("Semillas", 100),
    MAIZ("Maiz", 300),
    MANZANA("Manza", 1000),
    FRUTA_DORADA("Dorada", 9000);

    private final String food;
    private final int price;

    /**
     * Constructor del enum.
     * @param food nombre del alimento.
     * @param price precio del alimento.
     */
    FoodTypes(String food, int price){
        this.food = food;
        this.price = price;
    }

    /**
     * Funcion que retorna el nombre de un alimento
     * @return String con el nombre del alimento
     */
    public String getFood(){
        return this.food;
    }

    /**
     * Funcion que retorna el precio del alimento
     * @return int con el precio del alimento
     */
    public int getPrice() {
        return this.price;
    }
}