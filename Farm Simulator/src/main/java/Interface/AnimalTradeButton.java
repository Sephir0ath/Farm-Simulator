package Interface;

import Logic.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Clase que extiende de JButton, es la encargada de crear el boton para vender un animal referenciado
 */
public class AnimalTradeButton extends JButton{
    private final JLayeredPane layeredpane;
    private HitboxAnimal hitbox;

    /**
     * Metodo constructor de la clase.
     * @param text que tendrá el botón.
     * @param panelanimalstats el panel de los stats del animal.
     * @param animal el animal a vender.
     * @param habitat el habitat donde está el animal.
     * @param hitboxAnimal la hitbox del animal.
     */
    public AnimalTradeButton(String text, PanelAnimalStats panelanimalstats, Animal animal, Habitat habitat, HitboxAnimal hitboxAnimal) {
        this.layeredpane = panelanimalstats.getLayeredPane();
        this.hitbox = hitboxAnimal;
        this.setText(text);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerInfo.getInstance().addToStat(0, animal.calculateSellValue());
                layeredpane.remove(panelanimalstats.getThis());
                habitat.deleteAnimal(animal);
                hitboxAnimal.hideHitbox();
                layeredpane.revalidate();
                layeredpane.repaint();

            }
        });
    }
}