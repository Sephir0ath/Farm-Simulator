package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un JPanel el cual mostrará las estidisticas del jugador en pantalla
 */
public class PanelStats extends JPanel {
    private PanelStatsText panelMoney;
    private PanelStatsText panelAnimalQuantity;
    private PanelStatsText panelFoodQuantity;
    private AchievementsButton achievementsButton;

    /**
     * Constructor de la clase, inicializa las variables y coloca los componentes para ser mostrado en pantalla
     * @param playerInfo Parametro tipo PlayerInfo el cual representa las estadisticas del jugador
     */
    public PanelStats(PlayerInfo playerInfo) {
        super();
        setBackground(Color.lightGray);
        setLayout(new GridLayout(1, 5));

        panelMoney = new PanelStatsText("dinero", playerInfo, 0);
        panelMoney.setPreferredSize(new Dimension(50, 50));
        panelAnimalQuantity = new PanelStatsText("animales", playerInfo, 1);
        panelFoodQuantity = new PanelStatsText("comida", playerInfo, 3);
        achievementsButton = new AchievementsButton();

        add(panelMoney);
        add(panelAnimalQuantity);
        add(panelFoodQuantity);
        add(achievementsButton);
    }

    /**
     * Metodo que llama al metodo updateStatsPanel de los JPanels PanelStatsText instanciados en la clase
     * @param playerInfo
     */
    public void updateStatsPanels(PlayerInfo playerInfo) {
        panelMoney.updateStatsPanel(playerInfo);
        panelAnimalQuantity.updateStatsPanel(playerInfo);
        panelFoodQuantity.updateStatsPanel(playerInfo);
    }
}
