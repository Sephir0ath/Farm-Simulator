package Interface;


import Exceptions.*;
import Logic.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FoodBuyButton extends JButton {
    private ScheduledExecutorService scheduler;
    private Food food;
    private FoodTypes typeOfFood;
    private boolean isThisButtonPressed;

    public FoodBuyButton(FoodTypes foodType){
        super(foodType.getFood() + " " + foodType.getPrice() + "$");
        typeOfFood = foodType;
        isThisButtonPressed = false;


        scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null && isThisButtonPressed){
                    try{
                        if (PlayerInfo.getInstance().getStats(0) - foodType.getPrice() >= 0){
                            switch (typeOfFood){
                                case TRIGO -> food = new Wheat();
                                case ZANAHORIA -> food = new Carrot();
                                case SEMILLAS -> food = new Seeds();
                                case MANZANA -> food = new Apple();
                                case MAIZ -> food = new Corn();
                                case FRUTA_DORADA -> food = new GoldenFruit();
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
                PanelGame.getInstance().setSelectionMode(true);
                isThisButtonPressed = true;
            }
        });
    }
}