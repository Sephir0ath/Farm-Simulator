package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCheats extends JPanel {
    private JButton addMoneyToPlayer;
    private JButton resetAllHabitats;
    private JButton resetEverything;

    public PanelCheats(){
        super();
        this.setLayout(new GridLayout(3, 2));

        addMoneyToPlayer = new JButton("Añadir dinero");
        resetAllHabitats = new JButton("Resetear habitats");
        resetEverything = new JButton("Resetear todo");

        addMoneyToPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerInfo.getInstance().addToStat(0, 1000);
            }
        });

        resetAllHabitats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < PanelGame.getInstance().getHabitats().size(); i++){
                    PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().fullReset();
                }
            }
        });

        resetEverything.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < PanelGame.getInstance().getHabitats().size(); i++){
                    PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().fullReset();
                }
                PlayerInfo.getInstance().setStats(0, 5500);
            }
        });

        this.add(addMoneyToPlayer);
        this.add(resetAllHabitats);
        this.add(resetEverything);

    }
}
