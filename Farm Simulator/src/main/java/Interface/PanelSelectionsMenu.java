package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Clase la cual se encarga de mostrar cierto panel al presionar un botón en especifico
 */
public class PanelSelectionsMenu extends JPanel {
    private PanelAnimalBuyMenu panelAnimalBuyMenu;
    private PanelFoodBuyMenu panelFoodBuyMenu;
    private PanelCheats panelCheats;
    private JPanel panelDefault;
    private static PanelSelectionsMenu instance;
    private CardLayout cardLayout;
    private PanelUpgrades panelUpgrades;

    /**
     * Constructor de la clase, añade todos los metodos necesarios para mostrar en pantalla los menús
     */
    public PanelSelectionsMenu(){
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
        this.add(panelCheats, "Cheats");
        this.add(panelFoodBuyMenu, "Food");
        this.add(panelUpgrades, "Upgrades");
        this.add(panelAnimalBuyMenu, "Animals");
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


    /**
     * Metodo que pinta el fondo de este JPanel
     * @param g Parametro tipo Graphics usado para dibujar los componentes
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}