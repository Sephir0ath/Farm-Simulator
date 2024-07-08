package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Clase que representa un JButton, corresponde al botón que mejora la cantidad maxima de comida que puede tener un habitat
 */
public class UpgradeHabitatFoodLimitBuyButton extends JButton {
    private ScheduledExecutorService scheduler;
    private static int counter = 1;
    private boolean isThisButtonPressed;

    /**
     * Constructor de la clase, inicializa un scheduler el cual se encarga de ejcutar el comando de mejorar la cantidad maxima de comida de un habitat
     */
    public UpgradeHabitatFoodLimitBuyButton(){
        super("+ capacidad comida " + counter*100 + "$");
        this.isThisButtonPressed = false;

        this.scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null && isThisButtonPressed) {
                    if (PlayerInfo.getInstance().getStats(0) >= counter*100) {
                        UpgradeCommand increaseCapacity = new UpgradeHabitatMaxFoodCommand(PanelGame.getInstance().getClickedHabitat().getLogicHabitat());
                        counter += 1;
                        PlayerInfo.getInstance().addToStat(0, -counter*100);
                        increaseCapacity.execute();
                        isThisButtonPressed = false;
                        UpgradeHabitatFoodLimitBuyButton.this.setText("+ capacidad comida " + counter*100 + "$");
                    }
                    else{
                        new MessageWindow("No tienes suficiente dinero para comprar eso");
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