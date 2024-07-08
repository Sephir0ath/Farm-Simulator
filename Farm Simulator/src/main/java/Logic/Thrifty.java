package Logic;


/**
 * Clase que representa el logro que se completa al tener ahorrados $50.000.
 */
public class Thrifty extends Achievement {
    /**
     * Constructor que asigna el nombre del logro.
     */
    public Thrifty() {
        super("thrifty");
    }

    /**
     * Override de check, se completa al verificar que se tiene 50.000 de dinero.
     */
    @Override
    public void check() {
        if (!getCompletado() && PlayerInfo.getInstance().getStats(0) >= 50000) {
            completar();
        }
    }
}
