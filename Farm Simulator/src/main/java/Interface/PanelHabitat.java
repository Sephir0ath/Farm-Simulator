package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

public class PanelHabitat extends JPanel {
    private static boolean resized = false;
    private Habitat habitat;
    private HitboxAnimal hitboxAnimal = null;
    public PanelHabitat(){
        this.setOpaque(false); // MUY IMPORTANTE
        habitat = new Habitat();
    }

    public Habitat getLogicHabitat(){
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
        for (int j = 0 ; j <  getLogicHabitat().getAnimalsInTheHabitat().size(); j++) {
            getLogicHabitat().getAnimalsInTheHabitat().get(j).randomMovement();
        }
    }

    /*protected void paintHabitatBackground(Graphics g){
        g.setColor(new Color(106, 175, 106));
        g.fillRect((int)this.getLocationOfHabitat().getX(),(int)this.getLocationOfHabitat().getY() , this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        g.fillRect((int)this.getLocationOfHabitat().getX() + this.getWidth()-2, (int)this.getLocationOfHabitat().getY(), 2, this.getHeight());
        g.fillRect((int)this.getLocationOfHabitat().getX(), (int)this.getBottomRightLocationOfHabitat().getY(), (int)this.getBottomRightLocationOfHabitat().getX(), this.getHeight() );
        if (habitat.checkIsHabitatActive()){
            //todo pintar vallas de habitat
        }
    }*/

    public void setHitbox(){
        for (int j = 0; j < habitat.getAnimalsInTheHabitat().size(); j++) {
            Point location = habitat.getAnimalsInTheHabitat().get(j).getLocation();
            if(habitat.getAnimalsInTheHabitat().get(j).getHitboxAnimal() == null) {
                this.hitboxAnimal = new HitboxAnimal(location);
                habitat.getAnimalsInTheHabitat().get(j).setHitboxAnimal(this.hitboxAnimal);
                PanelGame.getInstance().cursorIsOnHitbox(this.hitboxAnimal);
            }
            else{
                habitat.getAnimalsInTheHabitat().get(j).getHitboxAnimal().updateHitbox(location);
            }
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
                case GALLINA -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Pollo.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case CABRA -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Cabra.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case OVEJA -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Oveja.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
                case CABALLO -> g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("Caballo.png")).getImage(), (int) location.getX(), (int) location.getY(), null);
            }
        }
    }

}