package Logic;

/**
 * Clase que representa una zanahoria subclase de Food.
 */
public class Carrot extends Food{
    /**
     * Constructor por defecto.
     */
    public Carrot(){
        super();
    }

    /**
     * Getter que entrega el tipo de fruta que es.
     * @return FoodTypes Zanahoria
     */
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.ZANAHORIA;
    }
}