package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

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

    public void CreateInterfazDeposit() {
        this.setBounds((int) positionMouseToPanel.getX(), (int) positionMouseToPanel.getY()-47, 100, 100);
        layeredPane.add(this, JLayeredPane.POPUP_LAYER);
        JLabel habitatLabel = new JLabel(actualAnimalsInHabitat+"/"+maxAnimalsInHabitat);
        JLabel depositLabel = new JLabel(actualFoodInDeposit+"/"+maxFoodDeposit);
        habitatLabel.setBounds(35,24,40,20);
        depositLabel.setBounds(35,62,40,20);
        this.setLayout(null);
        this.add(habitatLabel);
        this.add(depositLabel);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public void removeInterfazDeposit() {
        layeredPane.remove(this);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

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