package Interface;

import Logic.*;
import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el panel que contiene las stats del animal.
 */
public class PanelAnimalStats extends JPanel {
    private final Point positionMouseToPanel;
    private JLayeredPane layeredPane;
    private Rectangle hitboxanimal;
    private Animal animal;
    private Habitat habitat;

    /**
     * Método constructor
     * @param hitboxanimal hitbox del animal del panel.
     * @param positionMouseToPanel posición del animal.
     * @param animal el animal del que se verán las stasts-
     * @param habitat el habitat donde está el animal.
     */
    public PanelAnimalStats(Rectangle hitboxanimal, Point positionMouseToPanel, Animal animal, Habitat habitat) {
        this.layeredPane = Window.frame().getLayeredPane();
        this.hitboxanimal = hitboxanimal;
        this.animal = animal;
        this.habitat = habitat;
        this.positionMouseToPanel = positionMouseToPanel;
    }

    /**
     * Método para crear el JLabel que contiene las stasts del animal.
     */
    public void CreateInterfazAnimal() {
        this.setBounds((int) positionMouseToPanel.getX(), (int) positionMouseToPanel.getY()-47, 200, 100);
        this.setLayout(new BorderLayout());
        this.add(new JLabel("Hola"), BorderLayout.CENTER);
        JLabel labelFood = new JLabel("Comida: " + animal.getActualFood());
        this.add(labelFood);
        this.add(new AnimalTradeButton("Vender: " + animal.calculateSellValue(), this, animal, habitat, hitboxanimal), BorderLayout.SOUTH);
        layeredPane.add(this, JLayeredPane.POPUP_LAYER);

        layeredPane.revalidate();
        layeredPane.repaint();
    }

    /**
     * Getter de JLayeredPane.
     * @return layeredPane.
     */
    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    /**
     * Método que hace desaparecer el panel de stats.
     */
    public void removeInterfazAnimal() {
        layeredPane.remove(this);
        layeredPane.revalidate();
        layeredPane.repaint();
    }
}