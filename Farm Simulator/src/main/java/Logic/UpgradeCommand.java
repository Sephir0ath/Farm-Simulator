package Logic;

/**
 * Interfaz utilizada para definir Comandos de mejora en el juego, cada clase utilizada para mejorar aspectos del juego
 * debe implementar el metodo execute
 */
public interface UpgradeCommand {
    /**
     * Ejecuta el comando de actualización
     */
    void execute();
}
