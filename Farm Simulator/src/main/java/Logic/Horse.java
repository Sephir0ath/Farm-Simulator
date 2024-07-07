package Logic;

import java.awt.*;

public class Horse extends Animal{
    public Horse(Point initialLimits, Point finalLimits) {
        super(initialLimits, finalLimits);
    }

    @Override
    public AnimalTypes getAnimalType() {
        return AnimalTypes.CABALLO;
    }
}