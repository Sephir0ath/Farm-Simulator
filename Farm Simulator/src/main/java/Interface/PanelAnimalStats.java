package Interface;

import Logic.*;
import javax.swing.*;
import java.awt.*;

public class PanelAnimalStats extends JPanel {
    private final Point positionMouseToPanel;
    public JLayeredPane layeredPane;
    public Rectangle hitboxanimal;

    public PanelAnimalStats(Rectangle hitboxanimal, Point positionMouseToPanel) {
        this.layeredPane = Window.frame().getLayeredPane();
        this.hitboxanimal = hitboxanimal;
        this.positionMouseToPanel = positionMouseToPanel;
    }

    public void CreateInterfazAnimal() {
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
    }
}