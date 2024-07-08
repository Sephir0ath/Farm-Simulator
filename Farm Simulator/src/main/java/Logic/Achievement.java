package Logic;

/**
 * Clase abstracta que representa un logro.
 */
public abstract class Achievement {
    private String nombre;
    private boolean completado;

    /**
     * Constructor que se inicializa el logro.
     * @param nombre nombre del logro.
     */
    public Achievement(String nombre) {
        this.nombre = nombre;
        this.completado = false;
    }

    /**
     * Getter del nombre del logro.
     * @return nombre String con el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Verifica si el logro ha sido completado.
     * @return boolean completado que indica si ha sido o no completado.
     */
    public boolean getCompletado() {
        return completado;
    }

    /**
     * Método que marca el logro como completado.
     */
    public void completar() {
        completado = true;
    }

    /**
     * Método abstracto que verifica si el logro ha sido completado.
     */
    public abstract void check();
}
