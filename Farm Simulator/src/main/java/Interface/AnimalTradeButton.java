package Interface;

import Logic.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Clase que extiende de JButton, es la encargada de crear el boton para vender un animal referenciado
 */
public class AnimalTradeButton extends JButton{
    private Animal animal;
    private JLayeredPane layeredpane;
    private PanelAnimalStats panelanimalstats;
    private Habitat habitat;
    /**
     * Metodo constructor de la clase.
     * @param text que tendrá el botón.
     * @param panelanimalstats el panel de los stats del animal.
     * @param animal el animal a vender.
     * @param habitat el habitat donde está el animal.
     * @param hitboxAnimal la hitbox del animal.
     */
    public AnimalTradeButton(String text, PanelAnimalStats panelanimalstats, Animal animal, Habitat habitat, Rectangle hitboxAnimal) {
        this.panelanimalstats = panelanimalstats;
        this.animal = animal;
        this.layeredpane = panelanimalstats.getLayeredPane();
        this.habitat = habitat;
        this.animal = animal;
        this.setText(text);
        this.botonPresionado();
    }

    /**
     * Metodo para definir la accion de presionar el boton para vender el animal
     */
    private void botonPresionado() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remover la hitbox del contenedor
                habitat.deleteAnimal(animal);
                layeredpane.remove(panelanimalstats);
                PlayerInfo.getInstance().addToStat(0, animal.calculateSellValue());

                // Revalidar y repintar el panel para reflejar los cambios
                layeredpane.revalidate();
                layeredpane.repaint();

                // Actualizar la referencia del panelanimalstats
                panelanimalstats = null;
            }
        });
    }
}