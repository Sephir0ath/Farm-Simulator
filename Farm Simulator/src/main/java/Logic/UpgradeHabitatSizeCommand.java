package Logic;

public class UpgradeHabitatSizeCommand implements UpgradeCommand {
    private final Habitat habitat;
    public UpgradeHabitatSizeCommand(Habitat habitat){
        this.habitat = habitat;
    }

    @Override
    public void execute() {
        habitat.increaseAnimalLimit();
    }
}
