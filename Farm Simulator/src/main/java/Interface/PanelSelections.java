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

    public PanelSelections(){
        super();
        this.setPreferredSize(new Dimension(200, 100));
        this.setLayout(new GridLayout(2, 2));
        this.setBackground(Color.GRAY);

        buttonCheatsMenuSection = new JButton("Cheats");
        buttonAnimalMenuSection = new JButton("Animales");
        buttonFoodMenuSection = new JButton("Comida");
        buttonGoBack = new JButton("Volver");


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

        buttonGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelBuyMenu.getInstance().showPanel("Nothing");
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
        this.add(buttonGoBack);
    }

}
