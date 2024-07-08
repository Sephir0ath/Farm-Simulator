package Logic;

/**
 * Clase que implementa la interfaz ObserverInterface y actúa como observador de los logros.
 * Se encarga de verificar y actualizar los logros cuando se notifica un cambio en PlayerInfo.
 */
public class ObserverAchievements implements ObserverInterface {
    private Achievements achievements;
    /**
     * Constructor que inicializa el observador con los logros proporcionados.
     * @param achievements que contiene los logros a ser verificados.
     */
    public ObserverAchievements (Achievements achievements) {
        this.achievements = achievements;
    }

    /**
     * Método que se llama cuando PlayerInfo cambia, verifica y actualiza los logros.
     * @param playerInfo que contiene la información actualizada del jugador.
     */
    @Override
    public void update(PlayerInfo playerInfo) {
        achievements.checkAchievements();
    }
}
