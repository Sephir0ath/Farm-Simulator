package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un JPanel el cual contiene los paneles que conforman el menú del juego
 */
public class PanelMenu extends JPanel {
    PanelSelections panelSelections;
    PanelSelectionsMenu panelSelectionsMenu;
    /**
     * Constructor de la clase, se encarga de inicializar y agregar los otros JPanels necesarios para el menú del juego
     */
    public PanelMenu(){
        super();
        this.setLayout(new BorderLayout());

        panelSelectionsMenu = new PanelSelectionsMenu();
        panelSelections = new PanelSelections();
        this.add(panelSelectionsMenu, BorderLayout.CENTER);
        this.add(panelSelections, BorderLayout.NORTH);
    }
}
