package Logic;

import java.awt.*;

/**
 * Clase que representa a una gallina/pollo y extiende de Animal
 */
public class Chicken extends Animal{
    /**
     * Constructor de la clase Chicken
     * @param initialLimits Parametro de tipo Point, indica el punto arriba-izquierda del habitat en donde el animal está en la interfaz
     * @param finalLimits Parametro de tipo Point, indica el punto abajo-derecha del habitat en donde el animal está en la interfaz
     */
    public Chicken(Point initialLimits, Point finalLimits) {
        super(initialLimits, finalLimits);
    }

    /**
     * Función que brinda al jugador una cantidad especifica de dinero
     */
    @Override
    public AnimalTypes getAnimalType() {
        return AnimalTypes.GALLINA;
    }

    /**
     * Función que retorna el tipo de animal del animal al que se llama
     * @return valor tipo AnimalTypes de una Gallina
     */
    @Override
    public void giveMoneyEachSecond() {
        PlayerInfo.getInstance().addToStat(0, this.getAnimalType().getMoneyDrop());
        PlayerInfo.getInstance().addToStat(4, this.getAnimalType().getMoneyDrop());
    }
}
