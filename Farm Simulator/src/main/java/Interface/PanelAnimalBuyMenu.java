package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un JPanel, en este se encuentra el sub-menú para la compra de animales
 */
public class PanelAnimalBuyMenu extends JPanel {
    private CowButton cowButton;
    public PanelAnimalBuyMenu(){
        super();
        setLayout(new GridLayout(3, 2));
        add(new AnimalBuyButton(AnimalTypes.VACAS));
        add(new AnimalBuyButton(AnimalTypes.GALLINA));
        add(new AnimalBuyButton(AnimalTypes.CERDO));
        add(new AnimalBuyButton(AnimalTypes.CABRA));
        add(new AnimalBuyButton(AnimalTypes.OVEJA));
        add(new AnimalBuyButton(AnimalTypes.CABALLO));
    }
}
