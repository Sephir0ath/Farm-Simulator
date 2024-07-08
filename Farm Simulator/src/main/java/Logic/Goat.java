package Logic;

import java.awt.*;

public class Goat extends Animal{
    public Goat(Point initialLimits, Point finalLimits) {
        super(initialLimits, finalLimits);
    }

    @Override
    public AnimalTypes getAnimalType() {
        return AnimalTypes.CABRA;
    }
}
