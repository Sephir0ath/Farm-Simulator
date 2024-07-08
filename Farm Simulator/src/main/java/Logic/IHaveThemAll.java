package Logic;

import Interface.*;
/**
 * Clase que representa el logro que se completa al tener todos los tipos de animales.
 */
public class IHaveThemAll extends Achievement{
    private int counter;
    private int caballoCounter;
    private int vacaCounter;
    private int gallinaCounter;
    private int cerdoCounter;
    private int ovejaCounter;
    private int cabraCounter;
    /**
     * Constructor que asigna el nombre del logro e inicializa los contadores.
     */
    public IHaveThemAll() {
        super("iHaveThemAll");
        counter = 0;
        caballoCounter = 0;
        vacaCounter = 0;
        gallinaCounter = 0;
        cerdoCounter = 0;
        ovejaCounter = 0;
        cabraCounter = 0;
    }

    /**
     * Override de check, se completa el logro al verificar que están todos los tipos de animales.
     */
    @Override
    public void check() {
        for (int i = 0; PanelGame.getInstance().getHabitats().size() > i ; i++) {
            if (caballoCounter < 0 && PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().getHabitatType() == AnimalTypes.CABALLO) {
                counter++;
                caballoCounter++;
            }
            if (vacaCounter < 0 && PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().getHabitatType() == AnimalTypes.VACAS) {
                counter++;
                vacaCounter++;
            }
            if (gallinaCounter < 0 && PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().getHabitatType() == AnimalTypes.GALLINA) {
                counter++;
                gallinaCounter++;
            }
            if (cerdoCounter < 0 && PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().getHabitatType() == AnimalTypes.CERDO) {
                counter++;
                cerdoCounter++;
            }
            if (ovejaCounter < 0 && PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().getHabitatType() == AnimalTypes.OVEJA) {
                counter++;
                ovejaCounter++;
            }
            if (cabraCounter < 0 && PanelGame.getInstance().getHabitats().get(i).getLogicHabitat().getHabitatType() == AnimalTypes.CABRA) {
                counter++;
                cabraCounter++;
            }
            if (counter == 6) {
                if (!getCompletado()) {
                    completar();
                }
            }
            else {
                counter = 0;
                caballoCounter = 0;
                vacaCounter = 0;
                gallinaCounter = 0;
                cerdoCounter = 0;
                ovejaCounter = 0;
                cabraCounter = 0;
            }
        }
    }
}
