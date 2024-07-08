package Logic;

public class Millionaire extends Achievement {
    public Millionaire() {
        super("millionaire");
    }

    @Override
    public void check() {
        if (!getCompletado() && PlayerInfo.getInstance().getStats(4) >= 100000) {
            completar();
        }
    }
}
