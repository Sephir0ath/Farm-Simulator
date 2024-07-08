package Interface;


import Exceptions.*;
import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Clase que extiende de JButton, define la acción de los botones de comida.
 */
public class FoodBuyButton extends JButton {
    private ScheduledExecutorService scheduler;
    private Food food;
    private FoodTypes typeOfFood;
    private boolean isThisButtonPressed;
    private static boolean firstGolden;

    /**
     * Método constructor, asigna un tipo de boton segun la comida y activa el selection mode para agregar la comida
     * comprada al habitat en caso de ser posible
     * @param foodType de tipo FoodType, servira para saber el alimento que se comprara
     */
    public FoodBuyButton(FoodTypes foodType){
        super(foodType.getFood() + " " + foodType.getPrice() + "$");
        typeOfFood = foodType;
        isThisButtonPressed = false;
        firstGolden = false;

        scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null && isThisButtonPressed){
                    try{
                        if (PlayerInfo.getInstance().getStats(0) - foodType.getPrice() >= 0){
                            switch (typeOfFood){
                                case TRIGO:
                                    food = new Wheat();
                                    break;
                                case ZANAHORIA:
                                    food = new Carrot();
                                    break;
                                case SEMILLAS:
                                    food = new Seeds();
                                    break;
                                case MANZANA:
                                    food = new Apple();
                                    break;
                                case MAIZ:
                                    food = new Corn();
                                    break;
                                case FRUTA_DORADA:
                                    food = new GoldenFruit();
                                    firstGolden = true;
                                    break;
                            }
                            PanelGame.getInstance().getClickedHabitat().getLogicHabitat().addFoodToDeposit(food);
                            PlayerInfo.getInstance().addToStat(0, -typeOfFood.getPrice());
                        }
                        else {
                            new MessageWindow("No tienes suficiente dinero");
                        }
                    }
                    catch (FullDepositException e) {
                        new MessageWindow("Deposito lleno");
                    }
                    catch (FoodTypeDifferentFromHabitatTypeException e) {
                        new MessageWindow("No puedes colocar ese tipo de comida allí");
                    }
                    catch (HabitatTypeIsNullException e) {
                        new MessageWindow("El habitat no tiene un tipo de animal");
                    }
                    finally {
                        PanelGame.getInstance().setClickedHabitatToNull();
                        isThisButtonPressed = false;
                    }
                }
            }
        }, 0, 10, TimeUnit.MILLISECONDS);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PanelGame.getInstance().getSelectionMode()) {
                    PanelGame.getInstance().setSelectionMode(true);
                    isThisButtonPressed = true;
                }
            }
        });
    }

    /**
     * Getter para obtener si se ha comprado la primera fruta dorada.
     * @return boolean firstGolden que simboliza si se ha comprado o no.
     */
    public static boolean getFirstGolden() {
        return firstGolden;
    }

    /**
     * Override de paintComponent, pinta el botón de acuerdo al alimento al que corresponde.
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (typeOfFood == FoodTypes.TRIGO) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonTrigo.png")).getImage(), 0, 0, null);
        } else if (typeOfFood == FoodTypes.ZANAHORIA) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonZanahoria.png")).getImage(), 0, 0, null);
        } else if (typeOfFood == FoodTypes.SEMILLAS) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonSemilla.png")).getImage(), 0, 0, null);
        } else if (typeOfFood == FoodTypes.MAIZ) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonMaiz.png")).getImage(), 0, 0, null);
        } else if (typeOfFood == FoodTypes.MANZANA) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonManzana.png")).getImage(), 0, 0, null);
        } else if (typeOfFood == FoodTypes.FRUTA_DORADA) {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("buttonDorada.png")).getImage(), 0, 0, null);
        }
    }
}