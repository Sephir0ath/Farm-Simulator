package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

public class PanelStats extends JPanel {
    PanelStatsText panelMoney;
    PanelStatsText panelAnimalQuantity;
    PanelStatsText panelHabitatQuantity;
    PanelStatsText panelFoodQuantity;

    public PanelStats(PlayerInfo playerInfo){
        super();
        this.setBackground(Color.lightGray);
        this.setLayout(new GridLayout(1, 5));

        panelMoney = new PanelStatsText("Dinero:", playerInfo, 0);
        panelMoney.setPreferredSize(new Dimension(50, 50));

        panelAnimalQuantity = new PanelStatsText("C. de Animales:", playerInfo, 1);
        panelHabitatQuantity = new PanelStatsText("C. de Habitats:", playerInfo, 2);
        panelFoodQuantity = new PanelStatsText("C. de Habitats:", playerInfo, 3);

        this.add(panelMoney);
        this.add(panelAnimalQuantity);
        this.add(panelHabitatQuantity);
        this.add(panelFoodQuantity);
    }

    public void updateStatsPanels(PlayerInfo playerInfo){
        panelMoney.updateStatsPanel(playerInfo);
        panelAnimalQuantity.updateStatsPanel(playerInfo);
        panelHabitatQuantity.updateStatsPanel(playerInfo);
        panelFoodQuantity.updateStatsPanel(playerInfo);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

    }
}
