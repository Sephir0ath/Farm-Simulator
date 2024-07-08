package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un JPanel, se encarga de mostrar el sub-menú con mejoras del juego
 */
public class PanelUpgrades extends JPanel {
    /**
     * Constructor de la clase, crea los botones.
     */
    public PanelUpgrades(){
        super();
        setLayout(new GridLayout(2, 2));
        add(new UpgradeHabitatAnimalSizeBuyButton());
        add(new UpgradeHabitatFoodLimitBuyButton());
    }
}
