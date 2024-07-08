package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UpgradeHabitatFoodLimitBuyButton extends JButton {
    private ScheduledExecutorService scheduler;
    private boolean isThisButtonPressed;

    public UpgradeHabitatFoodLimitBuyButton(){
        super("Aumentar capacidad comida");
        this.isThisButtonPressed = false;

        this.scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null && isThisButtonPressed) {
                    UpgradeCommand increaseCapacity = new UpgradeHabitatMaxFoodCommand(PanelGame.getInstance().getClickedHabitat().getLogicHabitat());
                    increaseCapacity.execute();
                    isThisButtonPressed = false;
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