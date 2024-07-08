package Logic;

/*
    Stats[0] es el dinero
    Stats[1] es la cantidad de Animales
    Stats[2] es la cantidad de Habitats
    Stats[3] es la comida total
    Stats[4] es el dinero total
     */

import java.util.ArrayList;

/**
 * Clase que representa a un Jugador, esta guarda la cantidad de dinero que tiene el Usuario
 */
public class PlayerInfo {
    private final double[] stats;
    private static PlayerInfo instance;
    private int MAX_MONEY = 10000;
    private final ArrayList<ObserverInterface> observers;
    public PlayerInfo(){
        stats = new double[5];
        stats[0] = 5550;
        instance = this;
    }

    public static PlayerInfo getInstance() {
        if (instance == null) {
            instance = new PlayerInfo();
        }
        return instance;
    }

    /**
     * Metodo que según el indice que se le pase te devolverá una estadistica especifica del jugador
     * @param index Parametro tipo int que indica el indice del arreglo con estadisticas del jugador
     * @return el valor de la estadistica del jugador especificada
     */
    public double getStats(int index){
        return stats[index];
    }

    /**
     * Metodo que suma a cierta estadistica un valor
     * @param index Parametro tipo int que indica el indice del arreglo con estadisticas del jugador
     * @param quantity Parametro tipo double que indica la cantidad a agregar a la estadistica especificada
     */
    public void addToStat(int index, double quantity){
        stats[index] += quantity;
        notifyObservers();
    }

    /**
     * Metodo que cambia cierta estadistica a cierto valor especifico
     * @param index Parametro tipo int que indica el indice del arreglo con estadisticas del jugador
     * @param quantity Parametro tipo double que indica la cantidad a setear a la estadistica especificada
     */
    public void setStats(int index, double quantity){
        stats[index] = quantity;
    }

    /**
     * Este método agrega un observador a la lista de observadores.
     * @param observer el observador que se va a agregar.
     */
    public void addObserver(ObserverInterface observer) {
        observers.add(observer);
    }

    /**
     * Método que notifica a todos los observadores los cambios realizados llamando a su update.
     */
    private void notifyObservers() {
        for(int i = 0; i < this.observers.size(); ++i) {
            observers.get(i).update(this);
        }
    }
}