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
    private Rectangle rectangle;
    private HitboxAnimal hitboxAnimal;
    private Animal animal;
    private Habitat habitat;

    /**
     * Método constructor
     * @param rectangle hitbox del animal del panel.
     * @param positionMouseToPanel posición del animal.
     * @param animal el animal del que se verán las stasts-
     * @param habitat el habitat donde está el animal.
     */
    public PanelAnimalStats(Rectangle rectangle, Point positionMouseToPanel, Animal animal, Habitat habitat, HitboxAnimal hitboxAnimal) {
        this.layeredPane = Window.frame().getLayeredPane();
        this.rectangle = rectangle;
        this.animal = animal;
        this.hitboxAnimal = hitboxAnimal;
        this.habitat = habitat;
        this.positionMouseToPanel = positionMouseToPanel;
    }

    /**
     * Método para crear el JLabel que contiene las stasts del animal.
     */
    public void CreateInterfazAnimal() {
        this.setBounds((int) positionMouseToPanel.getX(), (int) positionMouseToPanel.getY(), 100, 70);
        this.setLayout(new BorderLayout());
        JLabel labelFood = new JLabel("          " + animal.getActualFood());
        this.add(labelFood);
        AnimalTradeButton sellAnimal = new AnimalTradeButton("", this, animal, habitat, hitboxanimal);
        sellAnimal.setPreferredSize(new Dimension(100,25));
        this.add(sellAnimal, BorderLayout.SOUTH);
        sellAnimal.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("sellAnimalButton.png"))));

        layeredPane.add(this, JLayeredPane.POPUP_LAYER);

        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public PanelAnimalStats getThis(){
        return this;
    }

    /**
     * Getter de JLayeredPane.
     * @return layeredPane.
     */
    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    /**
     * Override de paintComponent, pinta el panel.
     * Método que hace desaparecer el panel de stats.
     */
    public void removeInterfazAnimal() {
        layeredPane.remove(this);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    /**
     *
     * @param g the <code>Graphics</code> object to protect
     */

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("panelAnimalStats.png"))).getImage(), 0, 0, null);
        if(habitatType!=null){
            switch (habitatType) {
                case VACAS ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconCow.png"))).getImage(), 40, 0, null);
                case CERDO ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconPig.png"))).getImage(), 40, 0, null);
                case GALLINA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconChicken.png"))).getImage(), 40, 0, null);
                case OVEJA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconSheep.png"))).getImage(), 40, 0, null);
                case CABRA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconGoat.png"))).getImage(), 40, 0, null);
                case CABALLO ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconHorse.png"))).getImage(), 40, 0, null);
            }
        }
        else {
            g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconNull.png"))).getImage(), 40, 0, null);
        }
        if(depositType != null){
            switch (depositType) {
                case TRIGO ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconWheat.png"))).getImage(), 10, 10, null);
                case MAIZ ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconCorn.png"))).getImage(), 10, 10, null);
                case ZANAHORIA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconCarrot.png"))).getImage(), 10, 10, null);
                case SEMILLAS ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconSeeds.png"))).getImage(), 10, 10, null);
                case MANZANA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconApple.png"))).getImage(), 10, 10, null);
            }
        }
        else {
            g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconNull.png"))).getImage(), 10, 10, null);
        }
    }
}