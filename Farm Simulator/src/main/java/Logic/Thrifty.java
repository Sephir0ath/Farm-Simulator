package Logic;

public class Thrifty extends Achievement {
    public Thrifty() {
        super("thrifty");
    }

    @Override
    public void check() {
        if (!getCompletado() && PlayerInfo.getInstance().getStats(0) >= 50000) {
            completar();
        }
    }
}
