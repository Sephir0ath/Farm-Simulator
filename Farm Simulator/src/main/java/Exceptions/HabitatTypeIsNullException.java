package Exceptions;
/**
 * Excepcion creada en el caso que se trate de acceder a un Habitat y el tipo de Habitat de este sea nulo
 */
public class HabitatTypeIsNullException extends Exception{
    /**
     * Metodo constructor de la clase, hereda los datos de la clase Exception
     */
    public HabitatTypeIsNullException() {
        super();
    }
}