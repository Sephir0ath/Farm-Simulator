package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

public class PanelStatsText extends JPanel {
    private String statDescription;
    private double statValue;
    private int statIndex;

    public PanelStatsText(String statDescription, PlayerInfo playerInfo, int value){
        super();
        this.statDescription = statDescription;
        this.statValue = playerInfo.getStats(value);
        this.statIndex = value;
    }

    public void updateStatsPanel(PlayerInfo playerInfo){
        statValue = playerInfo.getStats(statIndex);
        this.repaint();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString(statDescription + " " + (int)statValue, 10, 30);
    }
}
