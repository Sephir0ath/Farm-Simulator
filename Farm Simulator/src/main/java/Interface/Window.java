package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la Ventana del juego
 */
public class Window extends JFrame {
    private static Window instance;

    /**
     * Constructor de la clase, inicializa el JPanel principal
     */
    public Window(){
        super("Farm Simulator");
        setSize(new Dimension(1200, 700));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        instance = this;
        setResizable(true);
        setMinimumSize(new Dimension(800, 700));
        add(new PanelPrincipal());
        setVisible(true);
    }

    /**
     * Clase que retorna la instacia Singleton de la clase, si la clase no ha sido creada, la inicializa antes de retornar.
     * @return la instancia de la clase
     */
    public static synchronized Window frame(){
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }


}
