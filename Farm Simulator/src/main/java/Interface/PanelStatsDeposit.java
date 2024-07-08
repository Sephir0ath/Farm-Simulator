package Interface;

import Logic.*;

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
        JLabel labelFood = new JLabel("Comida: " + habitat.getFoodDeposit().getActualFoodInDeposit() + "/"+ habitat.getFoodReserve());
        JLabel labelAnimals = new JLabel("Animales: " + habitat.getAnimalQuantity() + "/" + habitat.getAnimalQuantityLimit());
        JLabel labelTypeOfHabitat = new JLabel("Tipo:" + habitat.getHabitatType());
        JLabel labelTypeOfFood = new JLabel("Recibe: \n" + habitat.getFoodDeposit().getDepositType());
        this.add(labelFood);
        this.add(labelAnimals);
        this.add(labelTypeOfHabitat);
        this.add(labelTypeOfFood);

        layeredPane.add(this, JLayeredPane.POPUP_LAYER);
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