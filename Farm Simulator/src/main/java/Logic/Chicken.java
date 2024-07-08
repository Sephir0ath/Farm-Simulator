package Logic;

import java.awt.*;

public class Chicken extends Animal{
    public Chicken(Point initialLimits, Point finalLimits) {
        super(initialLimits, finalLimits);
    }

    @Override
    public AnimalTypes getAnimalType() {
        return AnimalTypes.GALLINA;
    }

    @Override
    public void giveMoneyEachSecond() {
        PlayerInfo.getInstance().addToStat(0, this.getAnimalType().getMoneyDrop());
    }
}
