package Logic;


public enum FoodTypes {
    ZANAHORIA("Zanaho", 100),
    TRIGO("Trigo", 100),
    SEMILLAS("Semillas", 100),
    MAIZ("Maiz", 300),
    MANZANA("Manza", 1000),
    FRUTA_DORADA("Dorada", 9000);

    private final String food;
    private final int price;

    FoodTypes(String food, int price){
        this.food = food;
        this.price = price;
    }

    public String getFood(){
        return this.food;
    }

    public int getPrice() {
        return this.price;
    }
}