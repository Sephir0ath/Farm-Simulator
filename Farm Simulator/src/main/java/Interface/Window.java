package Interface;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static Window instance;

    public Window(){
        super("Zoo Simulator");
        this.setSize(new Dimension(1200, 700));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        instance = this;
        this.setResizable(true);
        this.setMinimumSize(new Dimension(800, 700));
        this.add(new PanelPrincipal());



        this.setVisible(true);
    }

    public static synchronized Window frame(){
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }


}
