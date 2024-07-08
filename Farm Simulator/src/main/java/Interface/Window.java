package Interface;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static Window instance;

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

    public static synchronized Window frame(){
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }


}
