package Exceptions;

/**
 * Excepcion creada en el caso que se trate de añadir un animal a un habitat que no puede contener a este
 */
public class AnimalTypeDifferentFromHabitatTypeException extends Exception{
    /**
     * Metodo constructor de la clase, hereda los datos de la clase Exception
     */
    public AnimalTypeDifferentFromHabitatTypeException(){
        super();
    }
}