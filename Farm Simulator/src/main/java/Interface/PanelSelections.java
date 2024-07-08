package Interface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSelections extends JPanel {
    private JButton buttonCheatsMenuSection;
    private JButton buttonAnimalMenuSection;
    private JButton buttonFoodMenuSection;
    private JButton buttonGoBack;
    private JButton buttonUpgrades;
    public PanelSelections(){
        super();
        setPreferredSize(new Dimension(200, 100));
        setLayout(new GridLayout(2, 2));

        buttonCheatsMenuSection = new JButton();
        buttonCheatsMenuSection.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonCheats.png")));
        buttonAnimalMenuSection = new JButton();
        buttonAnimalMenuSection.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonAnimals.png")));
        buttonFoodMenuSection = new JButton();
        buttonFoodMenuSection.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonFood.png")));
        buttonUpgrades = new JButton();
        buttonUpgrades.setIcon(new ImageIcon(getClass().getClassLoader().getResource("buttonGoback.png")));

        buttonAnimalMenuSection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelBuyMenu.getInstance().showPanel("Animals");
            }
        });

        buttonFoodMenuSection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelBuyMenu.getInstance().showPanel("Food");
            }
        });

        buttonUpgrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelBuyMenu.getInstance().showPanel("Upgrades");;
            }
        });

        buttonCheatsMenuSection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelBuyMenu.getInstance().showPanel("Cheats");
            }
        });

        this.add(buttonAnimalMenuSection);
        this.add(buttonCheatsMenuSection);
        this.add(buttonFoodMenuSection);
        this.add(buttonUpgrades);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
