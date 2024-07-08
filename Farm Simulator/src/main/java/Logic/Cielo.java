package Logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
Clase que representa el cielo.
 */
public class Cielo {
    private static Cielo instance;
    private String estadoActual;
    private ScheduledExecutorService scheduler;

    /*
    Constructor de la clase.
    Inicializa el cielo en la noche (así el juego comienza de día).
     */
    public Cielo() {
        estadoActual = "noche";
        iniciarTimer();
    }

    /*
    Patrón de diseño: Singleton.
    Permite crear y trabajar con una única instancia de cielo.
     */
    public static synchronized Cielo getInstance() {
        if (instance == null) {
            instance = new Cielo();
        }
        return instance;
    }

    /*
    Método que inicializa el contador de tiempo, gracias a este cada un minuto cambiará el cielo.
     */
    private void iniciarTimer() {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            cambiarEstado();
        }, 0, 1, TimeUnit.MINUTES);
    }

    /*
    Método que cambia el estado del cielo entre día-tarde-noche.
     */
    private void cambiarEstado() {
        if (estadoActual.equals("dia")) {
            estadoActual = "tarde";
        } else if (estadoActual.equals("tarde")) {
            estadoActual = "noche";
        } else if (estadoActual.equals("noche")) {
            estadoActual = "dia";
        }
    }

    /*
    Getter del estado actual del cielo.
     */
    public String getCielo() {
        return estadoActual;
    }
}