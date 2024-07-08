package Logic;

import java.util.ArrayList;

/**
 * Clase que almacena los logros en un arraylist.
 */
public class Achievements {
    private ArrayList<Achievement> achievements;

    /**
     * Constructor que inicializa los logros y los pone en un arraylist.
     */
    public Achievements() {
        achievements = new ArrayList<>();
        achievements.add(new AWholeFamily());
        achievements.add(new AWholeCity());
        achievements.add(new FirstHabitatUpgrade());
        achievements.add(new FirstDepositoUpgrade());
        achievements.add(new Millionaire());
        achievements.add(new Thrifty());
        achievements.add(new Golden());
    }

    /**
     * Método que verifica el estado de los logros del arraylist.
     */
    public void checkAchievements() {
        for (int i = 0 ; achievements.size() > i ; i++) {
            achievements.get(i).check();
        }
    }

    /**
     * Getter que entrega el arraylist de logros.
     * @return
     */
    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }
}
