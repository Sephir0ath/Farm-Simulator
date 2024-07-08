package Interface;

import javax.swing.*;
import java.awt.*;

public class PanelBuyMenu extends JPanel {
    private PanelAnimalBuyMenu panelAnimalBuyMenu;
    private PanelFoodBuyMenu panelFoodBuyMenu;
    private PanelCheats panelCheats;
    private JPanel panelDefault;
    private static PanelBuyMenu instance;
    private CardLayout cardLayout;

    public PanelBuyMenu(){
        super();
        this.panelAnimalBuyMenu = new PanelAnimalBuyMenu();
        this.panelFoodBuyMenu = new PanelFoodBuyMenu();
        this.panelCheats = new PanelCheats();
        this.cardLayout = new CardLayout();
        this.panelDefault = new JPanel();
        panelDefault.setBackground(Color.GRAY);
        this.setLayout(cardLayout);
        instance = this;

        this.add(panelDefault, "Nothing");
        this.add(panelAnimalBuyMenu, "Animals");
        this.add(panelFoodBuyMenu, "Food");
        this.add(panelCheats, "Cheats");
    }

    public void showPanel(String panelName){
        cardLayout.show(this, panelName);
    }


    public static PanelBuyMenu getInstance(){
        if (instance == null) {
            instance = new PanelBuyMenu();
        }

        return instance;
    }

}