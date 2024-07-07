package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

public class PanelHabitat extends JPanel {
    private static boolean resized = false;
    private Habitat habitat;
    public PanelHabitat(){
        this.setOpaque(false); // MUY IMPORTANTE
        habitat = new Habitat();
    }

    public Habitat getHabitat(){
        return habitat;
    }

    public Point getLocationOfHabitat(){
        return this.getLocation();
    }

    public Point getBottomRightLocationOfHabitat(){
        Dimension size = this.getSize();
        return new Point((int)(this.getLocationOfHabitat().getX() + size.getWidth() - 1) , (int)(this.getLocationOfHabitat().getY() + size.getHeight() - 1));
    }

    public void updateAnimalMovements(){
        for (int j = 0; j < getHabitat().getAnimalsInTheHabitat().size(); j++) {
            getHabitat().getAnimalsInTheHabitat().get(j).randomMovement();
        }
    }

    protected void paintHabitatBackground(Graphics g){
        g.setColor(new Color(106, 175, 106));
        g.fillRect((int)this.getLocationOfHabitat().getX(),(int)this.getLocationOfHabitat().getY() , this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        g.fillRect((int)this.getLocationOfHabitat().getX() + this.getWidth()-2, (int)this.getLocationOfHabitat().getY(), 2, this.getHeight());
        g.fillRect((int)this.getLocationOfHabitat().getX(), (int)this.getBottomRightLocationOfHabitat().getY(), (int)this.getBottomRightLocationOfHabitat().getX(), this.getHeight() );
        if (habitat.checkIsHabitatActive()){
            //todo pintar vallas de habitat
        }

    }

    public void paintAnimals(Graphics g){
        for (int j = 0; j < habitat.getAnimalsInTheHabitat().size(); j++) {
            Point location = habitat.getAnimalsInTheHabitat().get(j).getLocation();
            switch (habitat.getHabitatType()) {
                case VACAS -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Vaca.png")).getImage(),
                        (int) location.getX(),
                        (int) location.getY(),
                        null);
                case CERDO -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Cerdo.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case OVEJA, CABALLO, CABRA, GALLINA -> {}
            }
        }
    }

}