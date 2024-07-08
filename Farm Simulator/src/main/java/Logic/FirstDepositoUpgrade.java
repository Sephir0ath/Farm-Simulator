package Logic;

import Interface.*;

/**
 * Clase que representa el logro que se completa al comprar la primera mejora de habitat.
 */
public class FirstDepositoUpgrade extends Achievement {
    /**
     * Constructor que le asigna nombre al logro.
     */
    public FirstDepositoUpgrade() {
        super("firstDepositoUpgrade");
    }

    /**
     * Override de check, verifica que se haya realizado una mejora de deposito para completarse.
     */
    @Override
    public void check() {
        if (!getCompletado() && UpgradeHabitatFoodLimitBuyButton.getFirstDepositoUpgrade()) {
            completar();
        }
    }
}
