package Interface;

import Logic.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AnimalTradeButton extends JButton{
    private Animal animal;
    private JLayeredPane layeredpane;
    private Rectangle hitboxanimal;
    private PanelAnimalStats panelanimalstats;
    public AnimalTradeButton(String text, PanelAnimalStats panelanimalstats) {
        this.panelanimalstats = panelanimalstats;
        this.animal = this.panelanimalstats.animal;
        this.hitboxanimal = this.panelanimalstats.hitboxanimal;
        this.layeredpane = this.panelanimalstats.layeredPane;
        this.setText(text);
        this.botonPresionado();
    }

    //Falta lograr que al vende el animal desaparezca y entregue dinero de venta
    private void botonPresionado() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Window.frame() != null && animal != null && panelanimalstats != null && hitboxanimal != null) {
                    animal = null;
                    hitboxanimal = null;
                    panelanimalstats.removeInterfazAnimal();
                    layeredpane.revalidate();
                    layeredpane.repaint();
                    System.out.println("Vendido");
                }
            }
        });
    }
}