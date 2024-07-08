package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class PanelGame extends JPanel {

    private final ArrayList<PanelHabitat> habitats;
    private static PanelGame instance;
    private static boolean selectionMode;
    private PanelHabitat clickedHabitat;
    private final Cielo cielo;
    public PanelGame(){
        super();
        habitats = new ArrayList<>();
        setLayout(new GridLayout(4, 3));
        instance = this;
        selectionMode = false;
        clickedHabitat = null;
        cielo = Cielo.getInstance();

        JLabel cielo1 = new JLabel();
        JLabel cielo2 = new JLabel();
        JLabel cielo3 = new JLabel();
        add(cielo1);
        add(cielo2);
        add(cielo3);

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

    public void updateAnimalQuantity(){
        int counter = 0;
        ArrayList<PanelHabitat> habitats =  this.getHabitats();
        for (int i = 0; i < habitats.size(); i++) {
            counter += habitats.get(i).getLogicHabitat().getAnimalQuantity();
            for (int j = 0; j < habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().size(); j++){
                habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().get(j).giveMoneyEachSecond();
            }
        }

        PlayerInfo.getInstance().setStats(1, counter);
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
        g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("pasto.png")).getImage(), 0, 154, null);
        if (cielo.getCielo() == "dia") {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("dia.png")).getImage(), 0, 0, null);
        }
        else if (cielo.getCielo() == "tarde") {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("tarde.png")).getImage(), 0, 0, null);
        }
        else {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("noche.png")).getImage(), 0, 0, null);

        }
        /*g.setColor(Color.BLUE);
        g.fillRect(0, 0, 966, 154);*/
        for (PanelHabitat habitatPanel : habitats) {
            // habitatPanel.paintHabitatBackground(g);
            habitatPanel.paintAnimals(g);
        }

        /*g.setColor(Color.GREEN);
        g.fillRect(0, 154, 322, 460);
        g.setColor(Color.RED);
        g.fillRect(322, 154, 322, 460);
        g.setColor(Color.GREEN);
        g.fillRect(644, 154, 322, 460);
        g.setColor(Color.RED);
        g.fillRect(0, 308, 966, 154);
        g.setColor(Color.GREEN);
        g.fillRect(322, 308, 322, 154);
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 966, 614);*/
    }
}
