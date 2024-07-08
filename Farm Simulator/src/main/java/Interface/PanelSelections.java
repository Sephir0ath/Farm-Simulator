package Interface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa un JPanel de selección para acceder a distintos submenús del juego
 */
public class PanelSelections extends JPanel {
    /**
     * Constructor de la clase, inicializa y agrega los botones
     * que servirán para seleccionar los distintos tipos de menú en el juego.
     */
    public PanelSelections(){
        super();
        setPreferredSize(new Dimension(200, 100));
        setLayout(new GridLayout(2, 2));

        JButton buttonCheatsMenuSection = new JButton();
        JButton buttonAnimalMenuSection = new JButton();
        JButton buttonFoodMenuSection = new JButton();
        JButton buttonUpgrades = new JButton();

        buttonCheatsMenuSection.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonCheats.png")));
        buttonAnimalMenuSection.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonAnimals.png")));
        buttonFoodMenuSection.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonFood.png")));
        buttonUpgrades.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonUpgrade.png")));

        buttonAnimalMenuSection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelSelectionsMenu.getInstance().showPanel("Animals");
            }
        });

        buttonFoodMenuSection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelSelectionsMenu.getInstance().showPanel("Food");
            }
        });

        buttonUpgrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelSelectionsMenu.getInstance().showPanel("Upgrades");;
            }
        });

        buttonCheatsMenuSection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelSelectionsMenu.getInstance().showPanel("Cheats");
            }
        });

        this.add(buttonAnimalMenuSection);
        this.add(buttonCheatsMenuSection);
        this.add(buttonFoodMenuSection);
        this.add(buttonUpgrades);
    }
}
