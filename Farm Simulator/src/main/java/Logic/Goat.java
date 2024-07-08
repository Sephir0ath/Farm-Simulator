package Logic;

import java.awt.*;

/**
 * Clase que representa a una cabra y extiende de Animal
 */
public class Goat extends Animal{
    /**
     * Constructor de la clase Goat
     * @param initialLimits Parametro de tipo Point, indica el punto arriba-izquierda del habitat en donde el animal está en la interfaz
     * @param finalLimits Parametro de tipo Point, indica el punto abajo-derecha del habitat en donde el animal está en la interfaz
     */
    public Goat(Point initialLimits, Point finalLimits) {
        super(initialLimits, finalLimits);
    }

    /**
     * Función que brinda al jugador una cantidad especifica de dinero
     */
    @Override
    public AnimalTypes getAnimalType() {
        return AnimalTypes.CABRA;
    }

    /**
     * Función que retorna el tipo de animal del animal al que se llama
     * @return valor tipo AnimalTypes de una Cabra
     */
    @Override
    public void giveMoneyEachSecond() {
        PlayerInfo.getInstance().addToStat(0, this.getAnimalType().getMoneyDrop());
    }
}
