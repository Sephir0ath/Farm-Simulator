package Interface;

import javax.swing.*;
import java.awt.*;

public class PanelUpgrades extends JPanel {
    public PanelUpgrades(){
        super();
        this.setLayout(new GridLayout(2, 2));

        this.add(new UpgradeHabitatAnimalSizeBuyButton());
        this.add(new UpgradeHabitatFoodLimitBuyButton());

    }
}
