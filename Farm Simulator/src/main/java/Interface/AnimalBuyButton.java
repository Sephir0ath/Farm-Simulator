package Interface;

import Logic.*;

import javax.swing.*;
import java.util.concurrent.ScheduledExecutorService;

public class AnimalBuyButton extends JButton {
    private ScheduledExecutorService scheduler;
    public AnimalBuyButton(AnimalTypes animal){
        super(animal.getAnimal() + " " + animal.getPrice());

      /*  scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!PanelGame.getInstance().getSelectionMode() && PanelGame.getInstance().getClickedHabitat() != null){
                    try{
                        if (PlayerInfo.getInstance().getStats(0) - animal.getPrice() >= 0){
                            PanelGame.getInstance().getClickedHabitat().getHabitat().addAnimalToHabitat();
                        }
                    }
                }
            }
        })*/
    }
}
