package Logic;

import Interface.*;

/**
 * Clase que representa el logro que se completa al comprar la primera mejora de habitat.
 */
public class FirstHabitatUpgrade extends Achievement {

    /**
     * Constructor que le asigna nombre al logro.
     */
    public FirstHabitatUpgrade() {
        super("firstHabitatUpgrade");
    }

    /**
     * Override de check, verifica que se haya realizado una mejora de habitat para completarse.
     */
    @Override
    public void check() {
        if (!getCompletado() && UpgradeHabitatAnimalSizeBuyButton.getFirstHabitatUpgrade()) {
            completar();
        }
    }
}
