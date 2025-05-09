package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel que representa un JPanel, es el sub-menu de Trucos del menu
 */
public class PanelCheats extends JPanel {
    private JButton addMoneyToPlayer;
    private JButton resetAllHabitats;
    private JButton resetEverything;

    /**
     * Constructor de la clase, añade los botones y los actionlistener de estos
     */
    public PanelCheats(){
        super();
        setPreferredSize(new Dimension(228,515));
        setLayout(new GridLayout(3, 2));

        addMoneyToPlayer = new JButton();
        addMoneyToPlayer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonCheat1.png")));
        resetAllHabitats = new JButton();
        resetAllHabitats.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonCheat2.png")));
        resetEverything = new JButton();
        resetEverything.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonCheat3.png")));

        addMoneyToPlayer.addActionListener(new ActionListener() {
            /**
             * Método que designa el evento cuando se presiona el botón de añadir dinero.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerInfo.getInstance().addToStat(0, 1000);
                PlayerInfo.getInstance().addToStat(4, 1000);
            }
        });

        resetAllHabitats.addActionListener(new ActionListener() {
            /**
             * Método que designa el evento cuando se presiona el botón de resetear los habitats.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < PanelGame.getInstance().getHabitats().size(); i++){
                    PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().fullReset();
                }
            }
        });

        resetEverything.addActionListener(new ActionListener() {
            /**
             * Método que designa el evento cuando se presiona el botón de resetear todo.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < PanelGame.getInstance().getHabitats().size(); i++){
                    PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().fullReset();
                }
                PlayerInfo.getInstance().setStats(0, 5500);
            }
        });
        add(addMoneyToPlayer);
        add(resetAllHabitats);
        add(resetEverything);
    }
}
