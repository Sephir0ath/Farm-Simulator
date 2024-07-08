package Logic;

/**
 * Clase que representa un trigo subclase de Food.
 */
public class Wheat extends Food{
    /**
     * Constructor por defecto.
     */
    public Wheat(){
        super();
    }
    /**
     * Getter que entrega el tipo de fruta que es.
     * @return FoodTypes Trigo
     */
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.TRIGO;
    }
}