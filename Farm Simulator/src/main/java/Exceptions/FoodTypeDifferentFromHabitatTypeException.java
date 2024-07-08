package Exceptions;

/**
 * Excepcion creada en el caso que se trate de añadir un tipo de comida diferente al que el habitat puede contener
 */
public class FoodTypeDifferentFromHabitatTypeException extends Exception{
    /**
     * Metodo constructor de la clase, hereda los datos de la clase Exception
     */
    public FoodTypeDifferentFromHabitatTypeException(){
        super();
    }
}