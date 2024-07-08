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
        achievements.add(new Millionaire());
        achievements.add(new Thrifty());

        /*
        archivements.add(new FirstUpdate()); // Comprar primera update
        archivements.add(new IHaveThemAll()); // After all these years Finally I have them all referencia gravity falls, haber comprado todos los tipos de animales una vez
        archivements.add(new AWholeFamily()); // Llenar un habitat con 5 animales
        archivements.add(new AWholeCity()); // Tener 45 animales
        // Tener 100 animales
        // Golden apple
        archivements.add(new FirstDeal()); // Vender tu primer animal
         */
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
