package Logic;

/**
 * Clase que representa a un Jugador, esta guarda la cantidad de dinero que tiene el Usuario
 */
public class PlayerInfo {
    private final double[] stats;
    private static PlayerInfo instance;
    private int MAX_MONEY = 10000;
    public PlayerInfo(){
        stats = new double[4];
        stats[0] = 5550;
        instance = this;
    }

    public static PlayerInfo getInstance() {
        if (instance == null) {
            instance = new PlayerInfo();
        }
        return instance;
    }

    /*
    Stats[0] es el dinero
    Stats[1] es la cantidad de Animales
    Stats[2] es la cantidad de Habitats
    Stats[3] es la comida total
    Hecho para no tener una clase gigante de getters y setters (puede estar sujeto a cambios)
     */
    public double getStats(int index){
        return stats[index];
    }

    public void addToStat(int index, double quantity){
        stats[index] += quantity;
    }

    public void setStats(int index, double quantity){
        stats[index] = quantity;
    }
}