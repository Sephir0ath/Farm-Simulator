package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

public class PanelAnimalBuyMenu extends JPanel {
    private CowButton cowButton;

    public PanelAnimalBuyMenu(){
        super();
        this.setLayout(new GridLayout(3, 2));
        cowButton = new CowButton();

        add(new AnimalBuyButton(AnimalTypes.VACAS));
        add(new AnimalBuyButton(AnimalTypes.GALLINA));
        add(new AnimalBuyButton(AnimalTypes.CERDO));
        add(new AnimalBuyButton(AnimalTypes.CABRA));
        add(new AnimalBuyButton(AnimalTypes.OVEJA));
        add(new AnimalBuyButton(AnimalTypes.CABALLO));
    }
}
