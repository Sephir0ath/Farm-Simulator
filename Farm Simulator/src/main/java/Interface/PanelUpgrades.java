package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un JPanel, se encarga de mostrar el sub-menú con mejoras del juego
 */
public class PanelUpgrades extends JPanel {
    public PanelUpgrades(){
        super();
        this.setLayout(new GridLayout(2, 2));
        this.add(new UpgradeHabitatAnimalSizeBuyButton());
        this.add(new UpgradeHabitatFoodLimitBuyButton());
    }
}
