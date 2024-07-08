package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa el botón para acceder a la ventana de logros.
 */
public class AchievementsButton extends JButton {
    public AchievementsButton() {
        super();
        setIcon(new ImageIcon(getClass().getClassLoader().getResource("achievementsButton.png")));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AchievementsWindow achievements = new AchievementsWindow();
                achievements.setVisible(true);
            }
        });
    }
}
