package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PanelPrincipal extends JPanel {
    private ScheduledExecutorService repaintScheduler;
    private ScheduledExecutorService moneyScheduler;
    private PlayerInfo playerInfo;
    private PanelStats panelStats;
    private PanelMenu panelMenu;
    private PanelGame panelGame;

    public PanelPrincipal(){
        super();
        this.setLayout(new BorderLayout());
        playerInfo = new PlayerInfo();
        panelGame = new PanelGame();
        panelStats = new PanelStats(playerInfo);
        panelMenu = new PanelMenu(playerInfo);

        this.add(panelGame, BorderLayout.CENTER);
        this.add(panelStats, BorderLayout.NORTH);
        this.add(panelMenu, BorderLayout.EAST);

        repaintScheduler = new ScheduledThreadPoolExecutor(1);
        repaintScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                panelStats.updateStatsPanels(playerInfo);
                panelGame.updateMovements();
                Window.frame().repaint();

            }
        }, 0, 100, TimeUnit.MILLISECONDS);

        moneyScheduler = new ScheduledThreadPoolExecutor(1);
        moneyScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                ArrayList<PanelHabitat> habitats =  panelGame.getHabitats();
                for (int i = 0; i < habitats.size(); i++) {
                    counter += habitats.get(i).getLogicHabitat().getAnimalQuantity();
                    for (int j = 0; j < habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().size(); j++){
                        habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().get(j).giveMoneyEachSecond();

                    }
                }

                PlayerInfo.getInstance().setStats(1, counter);
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);

    }
}
