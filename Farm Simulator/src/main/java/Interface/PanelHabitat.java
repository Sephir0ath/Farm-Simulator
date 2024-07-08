package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un el Panel de cada Habitat.
 */
public class PanelHabitat extends JPanel {
    private static boolean resized = false;
    private Habitat habitat;
    private HitboxAnimal hitboxAnimal = null;
    private HitboxDeposit hitboxDeposit = null;

    /**
     * Constructor de la clase, inicializa el habitat del panel.
     */
    public PanelHabitat(){
        setOpaque(false);
        habitat = new Habitat();
    }

    /**
     * Getter para acceder a la lógica y datos de un habitat.
     * @return habitat al que se quiere acceder.
     */
    public Habitat getLogicHabitat(){
        return habitat;
    }

    /**
     * Getter de la ubicación del panel del habitat.
     * @return Point que es la ubicación del panel.
     */
    public Point getLocationOfHabitat(){
        return this.getLocation();
    }

    /**
     * Getter de la ubicación de la esquina inferior derecha.
     * @return Point ubicación de este dato.
     */
    public Point getBottomRightLocationOfHabitat(){
        Dimension size = this.getSize();
        return new Point((int)(this.getLocationOfHabitat().getX() + size.getWidth() - 1) , (int)(this.getLocationOfHabitat().getY() + size.getHeight() - 1));
    }

    /**
     * Método para actualizar el movimiento de los animales por habitat.
     */
    public void updateAnimalMovements(){
        for (int j = 0 ; j <  getLogicHabitat().getAnimalsInTheHabitat().size(); j++) {
            getLogicHabitat().getAnimalsInTheHabitat().get(j).randomMovement();
        }
    }

    /**
     * Metodo engargado de asignar las hitbox a los animales y a los depositos de comida de cada habitat
     */
    public void setHitbox(){
        if(hitboxDeposit == null) {
            hitboxDeposit = new HitboxDeposit(this.getLocationOfHabitat());
            PanelGame.getInstance().cursorIsOnDeposit(hitboxDeposit, habitat);
            habitat.setHitboxDeposit(hitboxDeposit);
        }
        for (int j = 0; j < habitat.getAnimalsInTheHabitat().size(); j++) {
            Point location = habitat.getAnimalsInTheHabitat().get(j).getLocation();
            if(habitat.getAnimalsInTheHabitat().get(j).getHitboxAnimal() == null) {
                this.hitboxAnimal = new HitboxAnimal(location);
                habitat.getAnimalsInTheHabitat().get(j).setHitboxAnimal(this.hitboxAnimal);
                PanelGame.getInstance().cursorIsOnHitbox(this.hitboxAnimal, habitat, habitat.getAnimalsInTheHabitat().get(j));
            }
            else{
                habitat.getAnimalsInTheHabitat().get(j).getHitboxAnimal().updateHitbox(location);
            }
        }
    }

    /**
     * Método que pinta los depósitos de comida en cada habitat.
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintFoodDeposits(Graphics g) {
        Point location = this.getLocationOfHabitat();
        g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("DepositoComida.png")).getImage(), (int) location.getX() +3, (int) location.getY() +118, null);
    }

    /**
     * Método que pinta los animales en cada habitat.
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintAnimals(Graphics g){
        for (int j = 0; j < habitat.getAnimalsInTheHabitat().size(); j++) {
            Point location = habitat.getAnimalsInTheHabitat().get(j).getLocation();
            switch (habitat.getHabitatType()) {
                case VACAS -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Vaca.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case CERDO -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Cerdo.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case GALLINA -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Pollo.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case CABRA -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Cabra.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case OVEJA -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Oveja.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case CABALLO -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Caballo.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
            }
        }
    }
}