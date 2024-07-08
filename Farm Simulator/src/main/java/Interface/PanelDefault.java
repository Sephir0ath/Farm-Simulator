package Interface;

import java.awt.Graphics;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Panel que representa el J-Panel que se muestra al comenzar el juego a la derecha.
 */
public class PanelDefault extends JPanel {

    /**
     * Constructor por defecto.
     */
    public PanelDefault() {
    }

    /**
     * Override de paintComponent, pinta la imagen de fondo.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage((new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("panelDefault.png")))).getImage(), 0, 0, null);
    }
}