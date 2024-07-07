package Interface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelGame extends JPanel {

    private final ArrayList<PanelHabitat> habitats;
    private static PanelGame instance;

    public PanelGame(){
        super();
        this.habitats = new ArrayList<>();
        this.setLayout(new GridLayout(4, 3));
        instance = this;

        JLabel a = new JLabel();
        JLabel b = new JLabel();
        JLabel c = new JLabel();
        // todo Labels para mostrar el fondo de la primera fila, por ahora serán labels vacios
        this.add(a);
        this.add(b);
        this.add(c);

        for (int i = 0; i < 9; i++) {
            habitats.add(new PanelHabitat());
            this.add(habitats.get(i));
        }
    }

    public static PanelGame getInstance() {
        if (instance == null) {
            instance = new PanelGame();
        }
        return instance;
    }

    public ArrayList<PanelHabitat> getHabitats(){
        return habitats;
    }
    public void updateMovements(){
        for (int i = 0; i < habitats.size(); i++){
            getHabitats().get(i).updateAnimalMovements();

        }

    }

    protected void paintComponent(Graphics g){
        //super.paintComponent(g);

        for (PanelHabitat habitatPanel : habitats) {
            habitatPanel.paintHabitatBackground(g);
            habitatPanel.paintAnimals(g);
        }

    }
}
