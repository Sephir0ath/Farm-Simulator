package Logic;

/**
 * Clase que representa unas semillas subclase de Food.
 */
public class Seeds extends Food{
    /**
     * Constructor por defecto.
     */
    public Seeds(){
        super();
    }
    /**
     * Getter que entrega el tipo de fruta que es.
     * @return FoodTypes Semillas
     */
    @Override
    public FoodTypes getFoodType(){
        return FoodTypes.SEMILLAS;
    }
}