package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.event.*;

public class PanelGame extends JPanel {
    private static PanelAnimalStats panelanimalstats = null;
    private final ArrayList<PanelHabitat> habitats;
    private static PanelGame instance;
    private static boolean selectionMode;
    private PanelHabitat clickedHabitat;
    private final Cielo cielo;

    public PanelGame() {
        super();
        habitats = new ArrayList<>();
        setLayout(new GridLayout(4, 3));
        instance = this;
        selectionMode = false;
        clickedHabitat = null;
        cielo = new Cielo();

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
                if (selectionMode) {
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

    public void updateAnimalQuantity() {
        int counter = 0;
        ArrayList<PanelHabitat> habitats = this.getHabitats();
        for (int i = 0; i < habitats.size(); i++) {
            counter += habitats.get(i).getLogicHabitat().getAnimalQuantity();
            for (int j = 0; j < habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().size(); j++) {
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

    public PanelHabitat getClickedHabitat() {
        return clickedHabitat;
    }

    public void setClickedHabitatToNull() {
        clickedHabitat = null;
    }

    public void setSelectionMode(boolean value) {
        selectionMode = value;
    }

    public boolean getSelectionMode() {
        return selectionMode;
    }

    public ArrayList<PanelHabitat> getHabitats() {
        return habitats;
    }
    public void updateMovements() {
        for (int i = 0; i < habitats.size(); i++) {
            getHabitats().get(i).updateAnimalMovements();
        }
    }

    public void cursorIsOnHitbox(HitboxAnimal hitbox, Habitat habitat, Animal animal) {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point mouseLocationRelativeToPanel = PanelGame.getInstance().getMousePosition();
                if (mouseLocationRelativeToPanel != null) {
                    // Aparecer panel
                    if (hitbox.hitboxIsVisible()) {
                        if (hitbox.getHitbox().contains(mouseLocationRelativeToPanel) && PanelGame.getInstance().contains(mouseLocationRelativeToPanel)) {
                            if (panelanimalstats == null) {
                                panelanimalstats = new PanelAnimalStats(hitbox.getHitbox(), mouseLocationRelativeToPanel, animal, habitat);
                                panelanimalstats.CreateInterfazAnimal();
                            }
                        }
                        // Remover panel solo si el cursor no está sobre el hitbox o el panel
                        else {
                            if (panelanimalstats != null) {
                                Rectangle panelBounds = panelanimalstats.getBounds();
                                panelBounds.translate(0, -47);  //6, 29
                                Point panelLocation = panelBounds.getLocation();
                                panelBounds.setLocation(panelLocation);

                                if (!hitbox.getHitbox().contains(mouseLocationRelativeToPanel) && !panelBounds.contains(mouseLocationRelativeToPanel)) {
                                    panelanimalstats.removeInterfazAnimal();
                                    panelanimalstats = null;
                                }
                            }
                        }
                    }
                }
            }
        });
        timer.start();
    }

    public void cursorIsOnDeposit(HitboxDeposit hitbox, Habitat habitat) {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point mouseLocationRelativeToPanel = PanelGame.getInstance().getMousePosition();
                if (mouseLocationRelativeToPanel != null) {
                    if (hitbox.hitboxIsVisible()) {
                        if (hitbox.getHitbox().contains(mouseLocationRelativeToPanel) && PanelGame.getInstance().contains(mouseLocationRelativeToPanel)) {
                            if (panelStatsDeposit == null) {
                                panelStatsDeposit = new PanelStatsDeposit(mouseLocationRelativeToPanel, habitat);
                                panelStatsDeposit.CreateInterfazDeposit();
                            }
                        } else {
                            if (panelStatsDeposit != null) {
                                if (!hitbox.getHitbox().contains(mouseLocationRelativeToPanel)) {
                                    panelStatsDeposit.removeInterfazDeposit();
                                    panelStatsDeposit = null;
                                }
                            }
                        }
                    }
                }
            }
        });
        timer.start();
    }


    public void checkAndUpdateHabitatStatus(){
        for (int i = 0; i < habitats.size(); i++){
            habitats.get(i).getLogicHabitat().checkAndDeactivateHabitatIfIsEmpty();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("pasto.png"))).getImage(), 0, 154, null);
        if (Objects.equals(cielo.getCielo(), "dia")) {
            g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("dia.png"))).getImage(), 0, 0, null);
        }
        else if (Objects.equals(cielo.getCielo(), "tarde")) {
            g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("tarde.png"))).getImage(), 0, 0, null);
        }
        else {
            g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("noche.png"))).getImage(), 0, 0, null);
        }

        for (PanelHabitat habitatPanel : habitats) {
            habitatPanel.paintAnimals(g);
            habitatPanel.setHitbox();
            habitatPanel.paintFoodDeposits(g);
        }

        if (selectionMode) {
            for (int i = 0; i < habitats.size(); i++) {
                habitats.get(i).getLogicHabitat().getHitboxDeposit().hideHitbox();
                for (int j = 0; j < habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().size(); j++) {  //Agregado para ocultar las hitbox, SUJETO A CAMBIOS
                    //Agregado para ocultar las hitbox, SUJETO A CAMBIOS
                    habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().get(j).getHitboxAnimal().hideHitbox();
                }
                g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Flecha.gif"))).getImage(), (int) habitats.get(i).getLocationOfHabitat().getX() + 120, (int) habitats.get(i).getLocationOfHabitat().getY() + -110, null);
            }
        }
        //Agregado para mostrar las hitbox, SUJETO A CAMBIOS
        else {
            for (int i = 0; i < habitats.size(); i++) {
                habitats.get(i).getLogicHabitat().getHitboxDeposit().showHitbox();
                for (int j = 0; j < habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().size(); j++) {
                    if(!habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().get(j).getHitboxAnimal().hitboxIsVisible()) {
                        habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().get(j).getHitboxAnimal().showHitbox();
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }
}
