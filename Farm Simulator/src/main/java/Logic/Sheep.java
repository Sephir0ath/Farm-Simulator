package Logic;

import java.awt.*;

public class Sheep extends Animal{
    public Sheep(Point initialLimits, Point finalLimits) {
        super(initialLimits, finalLimits);
    }

    @Override
    public AnimalTypes getAnimalType() {
        return null;
    }
}
