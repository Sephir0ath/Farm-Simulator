package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un JPanel, en este se encuentra el sub-menú para la compra de animales
 */
public class PanelAnimalBuyMenu extends JPanel {
    /**
     * Constructor de la clase, inicializa los botones de los animales.
     */
    public PanelAnimalBuyMenu(){
        super();
        setPreferredSize(new Dimension(228,515));
        setLayout(new GridLayout(3, 2));
        add(new AnimalBuyButton(AnimalTypes.VACAS));
        add(new AnimalBuyButton(AnimalTypes.GALLINA));
        add(new AnimalBuyButton(AnimalTypes.CERDO));
        add(new AnimalBuyButton(AnimalTypes.CABRA));
        add(new AnimalBuyButton(AnimalTypes.OVEJA));
        add(new AnimalBuyButton(AnimalTypes.CABALLO));
    }
}
