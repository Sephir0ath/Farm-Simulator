package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Clase que representa el Panel que muestra los stats del depósito.
 */
public class PanelStatsDeposit extends JPanel{
    private final Point positionMouseToPanel;
    private JLayeredPane layeredPane;
    private Habitat habitat;
    private int actualFoodInDeposit;
    private int maxFoodDeposit;
    private int actualAnimalsInHabitat;
    private int maxAnimalsInHabitat;
    private FoodTypes depositType;
    private AnimalTypes habitatType;

    /**
     * Constructor de la clase, inicializa las variables.
     * @param positionMouseToPanel posición del mouse en el panel.
     * @param habitat Habitat donde está el deposito.
     */
    public PanelStatsDeposit(Point positionMouseToPanel, Habitat habitat) {
        this.layeredPane = Window.frame().getLayeredPane();
        this.habitat = habitat;
        this.positionMouseToPanel = positionMouseToPanel;
        this.actualFoodInDeposit = habitat.getFoodDeposit().getActualFoodInDeposit();
        this.maxFoodDeposit = habitat.getFoodReserve();
        this.actualAnimalsInHabitat = habitat.getAnimalQuantity();
        this.maxAnimalsInHabitat =  habitat.getAnimalQuantityLimit();
        this.depositType = habitat.getFoodDeposit().getDepositType();
        this.habitatType = habitat.getHabitatType();
    }

    /**
     * Método para crear el JLabel que contiene los stats del deposito.
     */
    public void CreateInterfazDeposit() {
        this.setBounds((int) positionMouseToPanel.getX(), (int) positionMouseToPanel.getY()-47, 100, 100);
        layeredPane.add(this, JLayeredPane.POPUP_LAYER);
        JLabel habitatLabel = new JLabel(actualAnimalsInHabitat+"/"+maxAnimalsInHabitat);
        JLabel depositLabel = new JLabel(actualFoodInDeposit+"/"+maxFoodDeposit);
        habitatLabel.setForeground(new Color(129,83,45));
        depositLabel.setForeground(new Color(129,83,45));
        habitatLabel.setFont(new Font("Arial", Font.BOLD, 12));
        depositLabel.setFont(new Font("Arial", Font.BOLD, 12));
        habitatLabel.setBounds(35,24,40,20);
        depositLabel.setBounds(35,62,40,20);
        this.setLayout(null);
        this.add(habitatLabel);
        this.add(depositLabel);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    /**
     * Método para hacer desaparecer el Jlabel.
     */
    public void removeInterfazDeposit() {
        layeredPane.remove(this);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    /**
     * Override de paintComponent, pinta el panel.
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("PanelStatsDeposit.png"))).getImage(), 0, 0, null);
        if(habitatType!=null){
            switch (habitatType) {
                case VACAS ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconCow.png"))).getImage(), 10, 24, null);
                case CERDO ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconPig.png"))).getImage(), 10, 24, null);
                case GALLINA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconChicken.png"))).getImage(), 10, 24, null);
                case OVEJA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconSheep.png"))).getImage(), 10, 24, null);
                case CABRA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconGoat.png"))).getImage(), 10, 24, null);
                case CABALLO ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconHorse.png"))).getImage(), 10, 24, null);
            }
        }
        else {
            g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconNull.png"))).getImage(), 10, 24, null);
        }
        if(depositType != null){
            switch (depositType) {
                case TRIGO ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconWheat.png"))).getImage(), 10, 62, null);
                case MAIZ ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconCorn.png"))).getImage(), 10, 62, null);
                case ZANAHORIA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconCarrot.png"))).getImage(), 10, 62, null);
                case SEMILLAS ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconSeeds.png"))).getImage(), 10, 62, null);
                case MANZANA ->
                        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconApple.png"))).getImage(), 10, 62, null);
            }
        }
        else {
            g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("iconNull.png"))).getImage(), 10, 62, null);
        }
    }
}