package Logic;

public class UpgradeHabitatMaxFoodCommand implements UpgradeCommand {
    private Habitat habitat;

    public UpgradeHabitatMaxFoodCommand(Habitat habitat) {
        super();
        this.habitat = habitat;
    }

    @Override
    public void execute() {
        habitat.increaseMaxFoodLimit();
    }
}
