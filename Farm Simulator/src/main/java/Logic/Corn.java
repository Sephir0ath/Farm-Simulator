package Logic;

/**
 * Clase que representa un maíz subclase de Food.
 */
public class Corn extends Food{
    /**
     * Constructor por defecto.
     */
    public Corn(){
        super();
    }
    /**
     * Getter que entrega el tipo de fruta que es.
     * @return FoodTypes Maíz
     */
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.MAIZ;
    }
}