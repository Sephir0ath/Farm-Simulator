package Interface;

import Logic.*;
import Exceptions.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Clase que representa un JButton, el cual compra un animal.
 */
public class AnimalBuyButton extends JButton {
    private ScheduledExecutorService scheduler;
    private Animal animal;
    private AnimalTypes typeOfAnimal;
    private boolean isThisButtonPressed;

    /**
     * Constructor de la clase, inicializa los botones según el animal que se indique, creando la instancia de este.
     * @param animalType
     */
    public AnimalBuyButton(AnimalTypes animalType){
        super(animalType.getAnimal() + " " + animalType.getPrice() + "$");
        typeOfAnimal = animalType;
        isThisButtonPressed = false;
        scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null && isThisButtonPressed){
                    try{
                        if (PlayerInfo.getInstance().getStats(0) - animalType.getPrice() >= 0){
                            switch (typeOfAnimal){
                                case VACAS -> animal = new Cow(PanelGame.getInstance().getClickedHabitat().getLocationOfHabitat(), PanelGame.getInstance().getClickedHabitat().getBottomRightLocationOfHabitat());
                                case CERDO -> animal = new Pig(PanelGame.getInstance().getClickedHabitat().getLocationOfHabitat(), PanelGame.getInstance().getClickedHabitat().getBottomRightLocationOfHabitat());
                                case GALLINA -> animal = new Chicken(PanelGame.getInstance().getClickedHabitat().getLocationOfHabitat(), PanelGame.getInstance().getClickedHabitat().getBottomRightLocationOfHabitat());
                                case CABRA -> animal = new Goat(PanelGame.getInstance().getClickedHabitat().getLocationOfHabitat(), PanelGame.getInstance().getClickedHabitat().getBottomRightLocationOfHabitat());
                                case CABALLO -> animal = new Horse(PanelGame.getInstance().getClickedHabitat().getLocationOfHabitat(), PanelGame.getInstance().getClickedHabitat().getBottomRightLocationOfHabitat());
                                case OVEJA -> animal = new Sheep(PanelGame.getInstance().getClickedHabitat().getLocationOfHabitat(), PanelGame.getInstance().getClickedHabitat().getBottomRightLocationOfHabitat());
                            }
                            PanelGame.getInstance().getClickedHabitat().getLogicHabitat().addAnimalToHabitat(animal);
                            PanelGame.getInstance().getClickedHabitat().getLogicHabitat().setActive();
                            PlayerInfo.getInstance().addToStat(0, -typeOfAnimal.getPrice());
                        }
                        else {
                            new MessageWindow("No tienes suficiente dinero");
                        }
                    }
                    catch (FullCapacityException e) {
                        new MessageWindow("Habitat lleno");
                    }
                    catch (AnimalTypeDifferentFromHabitatTypeException e) {
                        new MessageWindow("No puedes colocar ese tipo de animal allí");
                    }
                    finally {
                        PanelGame.getInstance().setClickedHabitatToNull();
                        isThisButtonPressed = false;
                    }
                }
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelGame.getInstance().setSelectionMode(true);
                isThisButtonPressed = true;
            }
        });
    }

    /**
     * Override de paintComponent, pinta el botón de acuerdo al animal al que corresponde.
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (typeOfAnimal == AnimalTypes.VACAS) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonVaca.png")).getImage(), 0, 0, null);
        }
        else if (typeOfAnimal == AnimalTypes.GALLINA) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonGallina.png")).getImage(), 0, 0, null);
        }
        else if (typeOfAnimal == AnimalTypes.CERDO) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonCerdo.png")).getImage(), 0, 0, null);
        }
        else if (typeOfAnimal == AnimalTypes.CABRA) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonCabra.png")).getImage(), 0, 0, null);
        }
        else if (typeOfAnimal == AnimalTypes.OVEJA) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonOveja.png")).getImage(), 0, 0, null);
        }
        else if (typeOfAnimal == AnimalTypes.CABALLO) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonCaballo.png")).getImage(), 0, 0, null);
        }
    }
}