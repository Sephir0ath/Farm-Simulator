package Logic;

import Interface.*;

/**
 * Clase que representa el logro que se completa al comprar la primera fruta dorada.
 */
public class Golden extends Achievement {

    /**
     * Constructor que asigna el nombre del logro.
     */
    public Golden() {
        super("golden");
    }

    /**
     * Override de check, se completa el logro al comprarla por primera vez.
     */
    @Override
    public void check() {
        if (!getCompletado() && FoodBuyButton.getFirstGolden()) {
            completar();
        }
    }
}
