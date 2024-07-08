package Logic;

/**
 * Clase que representa una manzana subclase de Food.
 */
public class Apple extends Food {
    /**
     * Constructor por defecto.
     */
    public Apple(){
        super();
    }

    /**
     * Getter que entrega el tipo de fruta que es.
     * @return FoodTypes Manzana
     */
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.MANZANA;
    }
}