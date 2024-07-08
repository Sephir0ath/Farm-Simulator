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
    private PanelUpgrades panelUpgrades;

    public PanelBuyMenu(){
        super();
        setOpaque(false);
        this.panelAnimalBuyMenu = new PanelAnimalBuyMenu();
        this.panelFoodBuyMenu = new PanelFoodBuyMenu();
        this.panelCheats = new PanelCheats();
        this.cardLayout = new CardLayout();
        this.panelDefault = new JPanel();
        this.panelUpgrades = new PanelUpgrades();
        this.setLayout(cardLayout);
        instance = this;

        this.add(panelDefault, "Nothing");
        this.add(panelAnimalBuyMenu, "Animals");
        this.add(panelFoodBuyMenu, "Food");
        this.add(panelCheats, "Cheats");
        this.add(panelUpgrades, "Upgrades");
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}