package Interface;

import javax.swing.*;
import java.awt.*;

public class PanelFoodBuyMenu extends JPanel {
    public PanelFoodBuyMenu(){
        super();
        this.setLayout(new GridLayout(3, 2));

        this.add(new JButton("Trigo"));
        this.add(new JButton("Zanahoria"));
        this.add(new JButton("Pan"));
        this.add(new JButton());
        this.add(new JButton());


    }

}
