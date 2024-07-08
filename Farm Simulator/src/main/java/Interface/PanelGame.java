package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.event.*;

/**
 * Clase que es un JPanel en el cual se muestra el cielo, los animales y los depositos de comida.
 */
public class PanelGame extends JPanel {
    private static PanelStatsDeposit panelStatsDeposit = null;
    private static PanelAnimalStats panelanimalstats = null;
    private final ArrayList<PanelHabitat> habitats;
    private static PanelGame instance;
    private static boolean selectionMode;
    private PanelHabitat clickedHabitat;
    private final Cielo cielo;

    /**
     * Método contructor, inicializa el JPanel con las características deseadas, agregando el PanelHabitat.
     */
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

        this.addMouseListener(new MouseAdapter() {
            /**
             * Método que comprueba que selectionMode sea true y si es así se obtiene el habitat en donde se presionó
             */
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

    /**
     * SINGLETON, permite trabajar ucon una instancia única de PanelGame.
     * @return instance, instancia única de PanelGame.
     */
    public static PanelGame getInstance() {
        if (instance == null) {
            instance = new PanelGame();
        }
        return instance;
    }

    /**
     * Método que actualiza la cantidad de animales en los habitats.
     */
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

    /**
     * Setter que da valor a la variable clickedHabitat, para saber que habitat ha sido clickeado.
     * @param mouseLocation recibe la ubicación del mouse para obtener el habitat.
     */
    public void setClickedHabitat(Point mouseLocation){
        int row = (int) mouseLocation.getY() / (this.getHeight() / 4);
        int col = (int) mouseLocation.getX() / (this.getWidth() / 3);

        int index = (row - 1) * 3 + col;
        if (index >= 0) {
            clickedHabitat = getHabitats().get(index);
        }
    }

    /**
     * Getter de getClicketHabitat
     * @return PanelHabitat el panel del habitat correspondiente.
     */
    public PanelHabitat getClickedHabitat() {
        return clickedHabitat;
    }

    /**
     * Setter que vuelve la variable clickedHabitat a null.
     */
    public void setClickedHabitatToNull() {
        clickedHabitat = null;
    }

    /**
     * Setter que permite asignar estado a selectionMode.
     * @param value booleano que indicará si se está en selectionMode.
     */
    public void setSelectionMode(boolean value) {
        selectionMode = value;
    }

    /**
     * Getter de selectionMode, para obtener si se está o no en el modo.
     * @return boolean selectionMode.
     */
    public boolean getSelectionMode() {
        return selectionMode;
    }

    /**
     * Getter de los paneles de Habitat en formato de arrayList
     * @return ArrayList de PanelHabitat.
     */
    public ArrayList<PanelHabitat> getHabitats() {
        return habitats;
    }

    /**
     * Método para actualizar el movimiento de los animales en cada habitat.
     */
    public void updateMovements() {
        for (int i = 0; i < habitats.size(); i++) {
            getHabitats().get(i).updateAnimalMovements();
        }
    }

    /**
     * Metodo encargado de activar la deteccion del cursor sobre las hitbox de los animales para visualizar sus stats
     * @param hitbox de tipo HitboxAnimal, contiene la hitbox en tiempo real del animal
     * @param habitat de tipo Habitat, este contiene al animal
     * @param animal de tipo Animal, es el animal referenciado
     */
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
                                panelanimalstats = new PanelAnimalStats(hitbox.getHitbox(), mouseLocationRelativeToPanel, animal, habitat, hitbox);
                                panelanimalstats.CreateInterfazAnimal();
                            }
                        }
                        // Remover panel solo si el cursor no está sobre el hitbox o el panel
                        else {
                            if (panelanimalstats != null) {
                                Rectangle panelBounds = panelanimalstats.getBounds();
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

    /**
     * Metodo encargado de activar la deteccion del cursor sobre las hitbox de los deposito de comida para visualizar
     * sus stats
     * @param hitbox de tipo HitboxDeposit, contiene la hitbox del deposito
     * @param habitat de tipo Habitat, este contiene al deposito de comida
     */
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


    /**
     * Método para actualizar el estado de cada habitat, si está vacío o tiene un animal.
     */
    public void checkAndUpdateHabitatStatus(){
        for (int i = 0; i < habitats.size(); i++){
            habitats.get(i).getLogicHabitat().checkAndDeactivateHabitatIfIsEmpty();
        }
    }

    /**
     * Override de paintComponent, pinta el cielo y los animales.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
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
                    habitats.get(i).getLogicHabitat().getAnimalsInTheHabitat().get(j).getHitboxAnimal().hideHitbox();
                }
                g.drawImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Flecha.gif"))).getImage(), (int) habitats.get(i).getLocationOfHabitat().getX() + 120, (int) habitats.get(i).getLocationOfHabitat().getY() + -110, null);
            }
        }

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
