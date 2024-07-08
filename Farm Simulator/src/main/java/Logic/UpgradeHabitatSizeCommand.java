package Logic;

/**
 * Clase que representa la mejora para aumentar tamaño del habitat que implementa UpgradeCommand
 */
public class UpgradeHabitatSizeCommand implements UpgradeCommand {
    private final Habitat habitat;
    /**
     * Constructor de la clase
     * @param habitat el habitat a mejorar.
     */
    public UpgradeHabitatSizeCommand(Habitat habitat){
        this.habitat = habitat;
    }

    /**
     * Método que ejecuta la mejora.
     */
    @Override
    public void execute() {
        habitat.increaseAnimalLimit();
    }
}
