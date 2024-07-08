package Interface;

import Logic.*;
import javax.swing.*;
import java.awt.*;

public class PanelAnimalStats extends JPanel {
    private final Point positionMouseToPanel;
    private JLayeredPane layeredPane;
    private Rectangle hitboxanimal;
    private Animal animal;
    private Habitat habitat;

    public PanelAnimalStats(Rectangle hitboxanimal, Point positionMouseToPanel, Animal animal, Habitat habitat) {
        this.layeredPane = Window.frame().getLayeredPane();
        this.hitboxanimal = hitboxanimal;
        this.animal = animal;
        this.habitat = habitat;
        this.positionMouseToPanel = positionMouseToPanel;
    }

    public void CreateInterfazAnimal() {
        this.setBounds((int) positionMouseToPanel.getX(), (int) positionMouseToPanel.getY()-47, 200, 100);
        this.setLayout(new BorderLayout());
        this.add(new JLabel("Hola"), BorderLayout.CENTER);
        JLabel labelFood = new JLabel("Comida: " + animal.getActualFood());
        this.add(labelFood);
        this.add(new AnimalTradeButton("Vender", this, animal, habitat, hitboxanimal), BorderLayout.SOUTH);

        // Añadir al JLayeredPane (capa)
        layeredPane.add(this, JLayeredPane.POPUP_LAYER);

        // Actualizar el JLayeredPane (capa)
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public void removeInterfazAnimal() {
        layeredPane.remove(this);
        layeredPane.revalidate();
        layeredPane.repaint();
    }
}