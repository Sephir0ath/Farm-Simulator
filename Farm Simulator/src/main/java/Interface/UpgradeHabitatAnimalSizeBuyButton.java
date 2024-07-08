package Interface;


import Logic.*;

import javax.swing.*;
import java.awt.*;
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
    private static int counter = 1000;
    private boolean isThisButtonPressed;
    private static boolean firstHabitatUpgrade;

    /**
     * Constructor de la clase, inicializa un scheduler el cual se encarga de ejcutar el comando de mejorar el tamaño de un habitat
     */
    public UpgradeHabitatAnimalSizeBuyButton(){
        super();
        this.isThisButtonPressed = false;
        firstHabitatUpgrade = false;
        setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonUpgradeHabitat.png")));

        this.scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null && isThisButtonPressed) {
                    if (PlayerInfo.getInstance().getStats(0) >= counter) {
                        UpgradeCommand increaseCapacity = new UpgradeHabitatSizeCommand(PanelGame.getInstance().getClickedHabitat().getLogicHabitat());
                        PlayerInfo.getInstance().addToStat(0, -counter);
                        firstHabitatUpgrade = true;
                        increaseCapacity.execute();
                        if (counter < 10000) {
                            counter += 1000;
                        }
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

    /**
     * Getter que entrega un booleano referenciando si se ha realizado la primera compra de mejora.
     * @return boolean firstHabitatUpgrade que indica si se ha comprado o no.
     */
    public static boolean getFirstHabitatUpgrade() {
        return firstHabitatUpgrade;
    }

    /**
     * Override de paintComponent, pinta los números del precio de la mejora.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String stat = Integer.toString((int)counter);
        ImageIcon imageIcon = null;
        for (int i = 0; i < stat.length(); i++) {
            char numero = stat.charAt(i);
            if (numero == '0') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum0.png"));
            } else if (numero == '1') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum1.png"));
            } else if (numero == '2') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum2.png"));
            } else if (numero == '3') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum3.png"));
            } else if (numero == '4') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum4.png"));
            } else if (numero == '5') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum5.png"));
            } else if (numero == '6') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum6.png"));
            } else if (numero == '7') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum7.png"));
            } else if (numero == '8') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum8.png"));
            } else if (numero == '9') {
                imageIcon = new ImageIcon(getClass().getClassLoader().getResource("upgradeNum9.png"));
            }
            g.drawImage(imageIcon.getImage(), 93 + (i * 14), 211, null);
        }
    }
}