package Logic;

import java.awt.*;

public class Cow extends Animal {
    public Cow(Point initialLimits, Point finalLimits) {
        super(initialLimits, finalLimits);
    }

    @Override
    public AnimalTypes getAnimalType() {
        return AnimalTypes.VACAS;
    }

    @Override
    public void giveMoneyEachSecond() {
        PlayerInfo.getInstance().addToStat(0, this.getAnimalType().getMoneyDrop());
    }
}