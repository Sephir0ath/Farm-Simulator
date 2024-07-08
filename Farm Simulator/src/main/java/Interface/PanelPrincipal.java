package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.AbstractList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal del juego, en este JPanel se instancian y se añaden los paneles más importantes del juego
 */
public class PanelPrincipal extends JPanel {
    private ScheduledExecutorService repaintScheduler;
    private PlayerInfo playerInfo;
    private PanelStats panelStats;
    private PanelMenu panelMenu;
    private PanelGame panelGame;
    private static Achievements achievements;

    /**
     * Constructor de la clase, instancia los otros JPanels e inicia el Scheduler encargado de varios métodos del juego
     */
    public PanelPrincipal(){
        super();
        setLayout(new BorderLayout());
        achievements = new Achievements();
        playerInfo = new PlayerInfo();
        playerInfo.addObserver(new ObserverAchievements(this.achievements));
        panelGame = new PanelGame();
        panelStats = new PanelStats(playerInfo);
        panelMenu = new PanelMenu();

        repaintScheduler = new ScheduledThreadPoolExecutor(1);
        repaintScheduler.scheduleAtFixedRate(new Runnable() {
            /**
             * Scheduler encargado de ejecutar el movimiento de los animales, la ganancia de dinero
             * y la actualización de estadisticas del jugador en pantalla
             */
            @Override
            public void run() {
                panelStats.updateStatsPanels(playerInfo);
                panelGame.updateMovements();
                panelGame.updateAnimalQuantity();
                panelGame.checkAndUpdateHabitatStatus();

                Window.frame().repaint();

            }
        }, 0, 150, TimeUnit.MILLISECONDS);

        add(panelGame, BorderLayout.CENTER);
        add(panelStats, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.EAST);
    }

    public static AbstractList<Achievement> getAchievements() {
        return achievements.getAchievements();
    }
}
