package Interface;


import javax.swing.*;
import java.awt.*;

public class AchievementsWindow extends JFrame {
    public AchievementsWindow() {
        setTitle("Achievements");
        setSize(300, 600);
        setLayout(new GridLayout(50,2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}