package Interface;

import Logic.*;
import javax.swing.*;
import java.awt.*;

public class PanelAnimalStats extends JPanel {
    private Point positionMouseToPanel;
    private Timer timer;
    public JLayeredPane layeredPane;
    public Rectangle hitboxanimal;
    public Animal animal;

    public PanelAnimalStats(Rectangle hitboxanimal, Point positionMouseToPanel, Animal animal) {
        this.layeredPane = Window.frame().getLayeredPane();
        this.hitboxanimal = hitboxanimal;
        this.animal = animal;
        this.positionMouseToPanel = positionMouseToPanel;
    }

    public void CreateInterfazAnimal() {
        System.out.println("Creado");
        this.setBounds((int) positionMouseToPanel.getX(), (int) positionMouseToPanel.getY()-47, 200, 100);
        this.setLayout(new BorderLayout());
        this.add(new JLabel("Hola"), BorderLayout.CENTER);
        this.add(new AnimalTradeButton("Vender", this), BorderLayout.SOUTH);

        // Añadir al JLayeredPane (capa)
        layeredPane.add(this, JLayeredPane.POPUP_LAYER);

        // Actualizar el JLayeredPane (capa)
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public void removeInterfazAnimal() {
        layeredPane.remove(this);
        layeredPane.revalidate();
        layeredPane.repaint();
        System.out.println("Borrado");
    }
}