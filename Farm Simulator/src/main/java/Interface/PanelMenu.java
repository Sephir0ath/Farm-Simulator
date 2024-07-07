package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {
    PanelSelections panelSelections;
    PanelBuyMenu panelBuyMenu;

    public PanelMenu(PlayerInfo playerInfo){
        super();
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());

        panelBuyMenu = new PanelBuyMenu();
        panelSelections = new PanelSelections();
        this.add(panelBuyMenu, BorderLayout.CENTER);
        this.add(panelSelections, BorderLayout.NORTH);

    }
}
