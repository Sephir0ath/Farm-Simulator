package Interface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class PanelGame extends JPanel {

    private final ArrayList<PanelHabitat> habitats;
    private static PanelGame instance;
    private static boolean selectionMode;
    private PanelHabitat clickedHabitat;
    public PanelGame(){
        super();
        this.habitats = new ArrayList<>();
        this.setLayout(new GridLayout(4, 3));
        instance = this;
        selectionMode = false;
        clickedHabitat = null;

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

        /**
         * Comprueba que selectionMode sea true y si es así se obtiene el habitat en donde se presionó
         */
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point mouseCoordenates = e.getPoint();
                if (selectionMode){
                    setClickedHabitat(mouseCoordenates);
                    selectionMode = false;
                }
            }
        });
    }

    public static PanelGame getInstance() {
        if (instance == null) {
            instance = new PanelGame();
        }
        return instance;
    }


    public void setClickedHabitat(Point mouseLocation){
        int row = (int) mouseLocation.getY() / (this.getHeight() / 4);
        int col = (int) mouseLocation.getX() / (this.getWidth() / 3);

        int index = (row - 1) * 3 + col; // Encontrar en qué index del arrayList está el habitat que se presionar
        if (index >= 0) { // Manejando solo los casos en donde hay habitats e ignorando las celdas de fondo
            clickedHabitat = getHabitats().get(index);
        }
    }

    public PanelHabitat getClickedHabitat(){
        return clickedHabitat;
    }

    public void setClickedHabitatToNull(){
        clickedHabitat = null;
    }

    public void setSelectionMode(boolean value){
        selectionMode = value;
    }

    public boolean getSelectionMode(){
        return selectionMode;
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
        super.paintComponent(g);
        for (PanelHabitat habitatPanel : habitats) {
            habitatPanel.paintHabitatBackground(g);
            habitatPanel.paintAnimals(g);
        }
    }
}
