package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

public class PanelStats extends JPanel {
    PanelStatsText panelMoney;
    PanelStatsText panelAnimalQuantity;
    PanelStatsText panelFoodQuantity;

    public PanelStats(PlayerInfo playerInfo) {
        super();
        setBackground(Color.lightGray);
        setLayout(new GridLayout(1, 5));

        panelMoney = new PanelStatsText("Dinero:", playerInfo, 0);
        panelMoney.setPreferredSize(new Dimension(50, 50));

        panelAnimalQuantity = new PanelStatsText("C. de Animales:", playerInfo, 1);
        panelFoodQuantity = new PanelStatsText("C. de Comida Total:", playerInfo, 3);

        add(panelMoney);
        add(panelAnimalQuantity);
        add(panelFoodQuantity);
    }

    public void updateStatsPanels(PlayerInfo playerInfo) {
        panelMoney.updateStatsPanel(playerInfo);
        panelAnimalQuantity.updateStatsPanel(playerInfo);
        panelFoodQuantity.updateStatsPanel(playerInfo);
    }
}
