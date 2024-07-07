package Interface;

import Exceptions.AnimalTypeDifferentFromHabitatTypeException;
import Exceptions.FullCapacityException;
import Logic.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CowButton extends JButton {
    public CowButton(){
        super("Vaca $250");

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    PanelGame.getInstance().getHabitats().get(0).getHabitat().addAnimalToHabitat(new Cow(PanelGame.getInstance().getHabitats().get(0).getLocationOfHabitat(), PanelGame.getInstance().getHabitats().get(0).getBottomRightLocationOfHabitat()));
                    PanelGame.getInstance().getHabitats().get(1).getHabitat().addAnimalToHabitat(new Cow(PanelGame.getInstance().getHabitats().get(1).getLocationOfHabitat(), PanelGame.getInstance().getHabitats().get(1).getBottomRightLocationOfHabitat()));
                    PanelGame.getInstance().getHabitats().get(2).getHabitat().addAnimalToHabitat(new Cow(PanelGame.getInstance().getHabitats().get(2).getLocationOfHabitat(), PanelGame.getInstance().getHabitats().get(2).getBottomRightLocationOfHabitat()));
                    PanelGame.getInstance().getHabitats().get(3).getHabitat().addAnimalToHabitat(new Cow(PanelGame.getInstance().getHabitats().get(3).getLocationOfHabitat(), PanelGame.getInstance().getHabitats().get(3).getBottomRightLocationOfHabitat()));
                }
                catch (AnimalTypeDifferentFromHabitatTypeException a){}
                catch (FullCapacityException b){}
            }
        });
    }
}
