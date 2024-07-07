package Interface;

import javax.swing.*;
import java.awt.*;

public class PanelAnimalBuyMenu extends JPanel {
    private CowButton cowButton;

    public PanelAnimalBuyMenu(){
        super();
        this.setLayout(new GridLayout(3, 2));
        cowButton = new CowButton();

        this.add(new CowButton());
        this.add(new ChickenButton());
        this.add(new PigButton());
        this.add(new GoatButton());
        this.add(new SheepButton());
        this.add(new HorseButton());
    }
}
