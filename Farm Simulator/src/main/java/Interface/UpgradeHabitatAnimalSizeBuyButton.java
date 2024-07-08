package Interface;


import Logic.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Clase que representa un JButton el cual se encarga de manejar la mejora de tamaño de un habitat
 */
public class UpgradeHabitatAnimalSizeBuyButton extends JButton {
    private ScheduledExecutorService scheduler;
    private static int counter = 1;
    private boolean isThisButtonPressed;

    /**
     * Constructor de la clase, inicializa un scheduler el cual se encarga de ejcutar el comando de mejorar el tamaño de un habitat
     */
    public UpgradeHabitatAnimalSizeBuyButton(){
        super("Aumentar Capacidad de Animal " + counter*100 + "$");
        this.isThisButtonPressed = false;

        this.scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null && isThisButtonPressed) {
                    if (PlayerInfo.getInstance().getStats(0) >= counter*100) {
                        UpgradeCommand increaseCapacity = new UpgradeHabitatSizeCommand(PanelGame.getInstance().getClickedHabitat().getLogicHabitat());
                        increaseCapacity.execute();
                        counter+=1;
                        UpgradeHabitatAnimalSizeBuyButton.this.setText("Aumentar Capacidad de Animal " + counter*100 + "$");
                        isThisButtonPressed = false;
                    }
                    else{
                        new MessageWindow("No tienes suficiente dinero");
                        isThisButtonPressed = false;
                    }
                }
            }
        }, 0, 100, TimeUnit.MILLISECONDS);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelGame.getInstance().setSelectionMode(true);
                isThisButtonPressed = true;
            }
        });
    }
}