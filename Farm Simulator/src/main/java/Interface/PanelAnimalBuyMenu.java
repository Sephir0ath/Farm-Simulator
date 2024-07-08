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

        this.add(new AnimalBuyButton(AnimalTypes.VACAS));
        this.add(new AnimalBuyButton(AnimalTypes.GALLINA));
        this.add(new AnimalBuyButton(AnimalTypes.CERDO));
        this.add(new AnimalBuyButton(AnimalTypes.CABRA));
        this.add(new AnimalBuyButton(AnimalTypes.OVEJA));
        this.add(new AnimalBuyButton(AnimalTypes.CABALLO));
    }
}
