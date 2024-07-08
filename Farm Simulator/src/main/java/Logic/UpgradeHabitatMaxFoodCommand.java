package Logic;

/**
 * Clase que representa la mejora para aumentar tamaño del deposito que implementa UpgradeCommand
 */
public class UpgradeHabitatMaxFoodCommand implements UpgradeCommand {
    private Habitat habitat;

    /**
     * Constructor de la clase
     * @param habitat el habitat a mejorar.
     */
    public UpgradeHabitatMaxFoodCommand(Habitat habitat) {
        super();
        this.habitat = habitat;
    }

    /**
     * Método que ejecuta la mejora.
     */
    @Override
    public void execute() {
        habitat.increaseMaxFoodLimit();
    }
}
