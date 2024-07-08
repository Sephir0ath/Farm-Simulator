package Interface;

import javax.swing.*;
import java.awt.*;

public class AchievementsWindow extends JFrame {
    private PanelAchievements achievements;
    public AchievementsWindow() {
        setTitle("Achievements");
        setSize(300, 735);
        achievements = new PanelAchievements();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        add(achievements);
    }
}