package Logic;

import Interface.*;

/**
 * Clase que representa el logro que se completa al tener 5 animales en un mismo habitat.
 */
public class AWholeFamily extends Achievement {
    /**
     * Constructor que le asigna nombre al logro.
     */
    public AWholeFamily() {
        super("aWholeFamily");
    }

    /**
     * Override de check, se completa el logro al verificar que al menos un habitat tenga 5 animales.
     */
    @Override
    public void check() {
        for (int i = 0; PanelGame.getInstance().getHabitats().size() > i ; i++) {
            if (!getCompletado() && PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().getFamily()) {
                completar();
            }
        }
    }
}
}

