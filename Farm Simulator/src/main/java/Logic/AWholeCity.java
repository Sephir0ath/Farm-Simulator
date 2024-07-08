package Logic;

/**
 * Clase que representa el logro que se completa al tener 100 animales en general en la granja.
 */
public class AWholeCity extends Achievement {
    /**
     * Constructor que le asigna nombre al logro.
     */
    public AWholeCity() {
        super("aWholeCity");
    }

    /**
     * Verifica que hayan 100 animales en total.
     */
    @Override
    public void check() {
        if (!getCompletado() && PlayerInfo.getInstance().getStats(1) >= 100) {
            completar();
        }
    }
}
