package Logic;

import java.awt.*;

public class Pig extends Animal{
    public Pig(Point initialLimits, Point finalLimits){
        super(initialLimits, finalLimits);
    }

    @Override
    public AnimalTypes getAnimalType() {
        return AnimalTypes.CERDO;
    }
}
