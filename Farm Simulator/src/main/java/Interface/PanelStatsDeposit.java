package Interface;

import javax.swing.*;
import java.awt.*;

public class PanelStatsDeposit extends JPanel{
    private final Point positionMouseToPanel;
    private JLayeredPane layeredPane;
    private Habitat habitat;

    public PanelStatsDeposit(Point positionMouseToPanel, Habitat habitat) {
        this.layeredPane = Window.frame().getLayeredPane();
        this.habitat = habitat;
        this.positionMouseToPanel = positionMouseToPanel;
    }

    public void CreateInterfazDeposit() {
        this.setBounds((int) positionMouseToPanel.getX(), (int) positionMouseToPanel.getY()-47, 100, 100);
        this.setLayout(new BorderLayout());
        JLabel labelFood = new JLabel("Comida: " + habitat.getFoodDeposit().getActualFoodInDeposit() + "/"+ habitat.getFoodReserve());
        JLabel labelAnimals = new JLabel("Animales: " + habitat.getAnimalQuantity() + "/" + habitat.getAnimalQuantityLimit());
        this.add(labelFood);

        // Añadir al JLayeredPane (capa)
        layeredPane.add(this, JLayeredPane.POPUP_LAYER);

        // Actualizar el JLayeredPane (capa)
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public void removeInterfazDeposit() {
        layeredPane.remove(this);
        layeredPane.revalidate();
        layeredPane.repaint();
    }
}