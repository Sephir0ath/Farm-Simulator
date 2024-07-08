package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.AbstractList;
import java.util.Objects;

public class PanelAchievements extends JPanel {
    private AbstractList<Achievement> achievementArrayList;
    public PanelAchievements() {
        super();
        achievementArrayList = PanelPrincipal.getAchievements();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0 ;  achievementArrayList.size() > i ; i++) {
            achievementArrayList.get(i).check();
            if (achievementArrayList.get(i).getNombre() == "aWholeFamily") {
                if (achievementArrayList.get(i).getCompletado()) {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("completedFamily.png")))).getImage(), 0, 0, null);
                }
                else {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("family.png")))).getImage(), 0, 0, null);
                }
            }
            if (achievementArrayList.get(i).getNombre() == "aWholeCity") {
                if (achievementArrayList.get(i).getCompletado()) {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("completedCity.png")))).getImage(), 0, 100, null);
                }
                else {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("city.png")))).getImage(), 0, 100, null);
                }
            }
            if (achievementArrayList.get(i).getNombre() == "firstHabitatUpgrade") {
                if (achievementArrayList.get(i).getCompletado()) {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("completedAnimals.png")))).getImage(), 0, 200, null);
                }
                else {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("animals.png")))).getImage(), 0, 200, null);
                }
            }
            if (achievementArrayList.get(i).getNombre() == "firstDepositoUpgrade") {
                if (achievementArrayList.get(i).getCompletado()) {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("completedFood.png")))).getImage(), 0, 300, null);
                }
                else {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("food.png")))).getImage(), 0, 300, null);
                }
            }
            if (achievementArrayList.get(i).getNombre() == "iHaveThemAll") {
                if (achievementArrayList.get(i).getCompletado()) {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("completedIHaveThemAll.png")))).getImage(), 0, 400, null);
                }
                else {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("IHaveThemAll.png")))).getImage(), 0, 400, null);
                }
            }
            if (achievementArrayList.get(i).getNombre() == "millionaire") {
                if (achievementArrayList.get(i).getCompletado()) {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("completedMillionaire.png")))).getImage(), 0, 500, null);
                }
                else {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("millionaire.png")))).getImage(), 0, 500, null);
                }
            }
            if (achievementArrayList.get(i).getNombre() == "thrifty") {
                if (achievementArrayList.get(i).getCompletado()) {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("completedThrifty.png")))).getImage(), 0, 600, null);
                }
                else {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("thrifty.png")))).getImage(), 0, 600, null);
                }
            }
            if (achievementArrayList.get(i).getNombre() == "golden") {
                if (achievementArrayList.get(i).getCompletado()) {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("completedGolden.png")))).getImage(), 0, 700, null);
                }
                else {
                    g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("golden.png")))).getImage(), 0, 700, null);
                }
            }
        }
    }
}
