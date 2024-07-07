package Interface;

import Exceptions.*;
import Logic.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PigButton extends JButton {

    ScheduledExecutorService scheduler;
    public PigButton() {
        super("Cerdo $350");

        // Detectar si es que hay un habitat que fue seleccionado cuando el selectionMode estaba activo
        scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null) {
                    try {
                        if (PlayerInfo.getInstance().getStats(0) - AnimalTypes.CERDO.getPrice() >= 0) {
                            PanelGame.getInstance().getClickedHabitat().getHabitat().addAnimalToHabitat(new Pig(PanelGame.getInstance().getClickedHabitat().getLocationOfHabitat(), PanelGame.getInstance().getClickedHabitat().getBottomRightLocationOfHabitat()));
                            PlayerInfo.getInstance().setStat(0, -AnimalTypes.CERDO.getPrice());
                        } else {
                            new MessageWindow("No tienes suficiente dinero");
                        }


                    } catch (FullCapacityException ex) {
                        new MessageWindow("Habitat lleno");
                    } catch (AnimalTypeDifferentFromHabitatTypeException ex) {
                        new MessageWindow("No puedes colocar ese tipo de animal allí");
                    } finally {
                        PanelGame.getInstance().setClickedHabitatToNull();
                    }
                }
            }
        }, 0, 1, TimeUnit.MILLISECONDS);


        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelGame.getInstance().setSelectionMode(true);
            }
        });
    }
}
