package Interface;

import Logic.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AnimalTradeButton extends JButton{
    private Animal animal;
    private JLayeredPane layeredpane;
    private Rectangle hitboxAnimal;
    private PanelAnimalStats panelanimalstats;
    private Habitat habitat;
    public AnimalTradeButton(String text, PanelAnimalStats panelanimalstats, Animal animal, Habitat habitat, Rectangle hitboxAnimal) {
        this.panelanimalstats = panelanimalstats;
        this.animal = animal;
        this.hitboxAnimal = hitboxAnimal;
        this.layeredpane = panelanimalstats.getLayeredPane();
        this.habitat = habitat;
        this.animal = animal;
        this.setText(text);
        this.botonPresionado();
    }

    // Actualiza el metodo botonPresionado
    private void botonPresionado() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remover la hitbox del contenedor
                habitat.deleteAnimal(animal);
                layeredpane.remove(panelanimalstats);

                // Revalidar y repintar el panel para reflejar los cambios
                layeredpane.revalidate();
                layeredpane.repaint();

                // Actualizar la referencia del panelanimalstats
                hitboxAnimal = null;
                panelanimalstats = null;
            }
        });
    }
}