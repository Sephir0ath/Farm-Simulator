package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Clase la cual se encarga de mostrar cierto panel al presionar un botón en especifico
 */
public class PanelSelectionsMenu extends JPanel {
    private static PanelSelectionsMenu instance;
    private PanelAnimalBuyMenu panelAnimalBuyMenu;
    private PanelFoodBuyMenu panelFoodBuyMenu;
    private PanelCheats panelCheats;
    private JPanel panelDefault;
    private CardLayout cardLayout;
    private PanelUpgrades panelUpgrades;

    /**
     * Constructor de la clase, añade todos los metodos necesarios para mostrar en pantalla los menús
     */
    public PanelSelectionsMenu(){
        super();
        setPreferredSize(new Dimension(228,515));
        setOpaque(false);
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        panelAnimalBuyMenu = new PanelAnimalBuyMenu();
        panelFoodBuyMenu = new PanelFoodBuyMenu();
        panelUpgrades = new PanelUpgrades();
        panelCheats = new PanelCheats();
        panelDefault = new PanelDefault();
        instance = this;

        add(panelDefault, "Nothing");
        add(panelCheats, "Cheats");
        add(panelFoodBuyMenu, "Food");
        add(panelUpgrades, "Upgrades");
        add(panelAnimalBuyMenu, "Animals");
    }

    /**
     * Metodo el cual se encarga de mostrar el JPanel según el String que se le entregue
     * @param panelName Parametro tipo String que representa al nombre del JPanel que se quiere mostrar
     */
    public void showPanel(String panelName){
        cardLayout.show(this, panelName);
    }

    /**
     * Devuelve la instancia Singleton de la clase, si la instancia no se ha creado, la inicializa antes de retornarla
     * @return la instancia de la clase
     */
    public static PanelSelectionsMenu getInstance(){
        if (instance == null) {
            instance = new PanelSelectionsMenu();
        }
        return instance;
    }
}