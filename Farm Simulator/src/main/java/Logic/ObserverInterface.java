package Logic;


/**
 * Interfaz que define el método que debe implementar cualquier clase que actúe como observador.
 */
public interface ObserverInterface {
    /**
     * Método que se llama cuando el objeto observado cambia.
     * @param playerInfo que contiene la información actualizada del jugador.
     */
    void update(PlayerInfo playerInfo);
}
