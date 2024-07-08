package Logic;

/**
 * Clase que representa una FrutaDorada subclase de Food.
 */
public class GoldenFruit extends Food{
    /**
     * Constructor por defecto.
     */
    public GoldenFruit(){
        super();
    }
    /**
     * Getter que entrega el tipo de fruta que es.
     * @return FoodTypes Fruta Dorada
     */
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.FRUTA_DORADA;
    }
}