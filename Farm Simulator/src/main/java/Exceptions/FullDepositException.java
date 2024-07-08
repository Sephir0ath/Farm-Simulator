package Exceptions;

/**
 * Excepcion creada en el caso que se trate de añadir comida a un deposito y este esté lleno
 */
public class FullDepositException extends Exception{
    /**
     * Metodo constructor de la clase, hereda los datos de la clase Exception
     */
    public FullDepositException(){
        super();
    }
}
