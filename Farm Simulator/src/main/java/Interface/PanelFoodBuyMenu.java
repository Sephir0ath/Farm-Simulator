package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un JPanel, en este se encuentra el sub-menú para la compra de comida
 */
public class PanelFoodBuyMenu extends JPanel {
    /**
     * Constructor de la clase, inicializa los botones.
     */
    public PanelFoodBuyMenu(){
        super();
        setPreferredSize(new Dimension(228,517));
        setLayout(new GridLayout(3, 2));

        add(new FoodBuyButton(FoodTypes.TRIGO));
        add(new FoodBuyButton(FoodTypes.ZANAHORIA));
        add(new FoodBuyButton(FoodTypes.SEMILLAS));
        add(new FoodBuyButton(FoodTypes.MAIZ));
        add(new FoodBuyButton(FoodTypes.MANZANA));
        add(new FoodBuyButton(FoodTypes.FRUTA_DORADA));
    }
}
