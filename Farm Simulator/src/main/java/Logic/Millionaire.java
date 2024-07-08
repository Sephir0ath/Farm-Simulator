package Logic;

/**
 * Clase que representa el logro que se completa al acumular $100.000.
 */
public class Millionaire extends Achievement {

    /**
     * Constructor que asigna el nombre del logro.
     */
    public Millionaire() {
        super("millionaire");
    }

    /**
     * Override de check, se completa al acumular 100000 de dinero.
     */
    @Override
    public void check() {
        if (!getCompletado() && PlayerInfo.getInstance().getStats(4) >= 100000) {
            completar();
        }
    }
}
