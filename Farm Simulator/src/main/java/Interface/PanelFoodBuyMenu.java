package Interface;

import javax.swing.*;
import java.awt.*;

public class PanelFoodBuyMenu extends JPanel {
    public PanelFoodBuyMenu(){
        super();
        this.setLayout(new GridLayout(3, 2));

        this.add(new FoodBuyButton(FoodTypes.TRIGO));
        this.add(new FoodBuyButton(FoodTypes.ZANAHORIA));
        this.add(new FoodBuyButton(FoodTypes.SEMILLAS));
        this.add(new FoodBuyButton(FoodTypes.MAIZ));
        this.add(new FoodBuyButton(FoodTypes.MANZANA));
        this.add(new FoodBuyButton(FoodTypes.FRUTA_DORADA));
    }
}
