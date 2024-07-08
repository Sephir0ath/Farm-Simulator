package Logic;

import java.util.Random;
import java.awt.*;

/**
 * Clase abstracta que representa a un Animal con sus propiedades
 */
public abstract class Animal {
    private final int MAX_FOOD = 20;
    private int actualfood;
    private final Point ubicacionInicial;
    private Point ubicacion;
    private Point initialLimits;
    private Point finalLimits;
    private HitboxAnimal hitboxAnimal = null;
    Random random = new Random();

    /**
     * Constructor de la clase Animal, inicializa todas las variables necesarias para un animal
     * @param initialLimits Parametro de tipo Point, indica el punto arriba-izquierda del habitat en donde el animal está en la interfaz
     * @param finalLimits Parametro de tipo Point, indica el punto abajo-derecha del habitat en donde el animal está en la interfaz
     */
    public Animal(Point initialLimits, Point finalLimits){
        this.initialLimits = initialLimits;
        this.finalLimits = finalLimits;
        this.ubicacionInicial = new Point(100 + (int) initialLimits.getX(), 90 + (int) initialLimits.getY());
        this.actualfood = MAX_FOOD;
        this.ubicacion = ubicacionInicial;
    }

    /**
     * Función que revisa si el animal no ha comido
     * @return booleano que indica si actualFood es 0
     */
    public boolean checkIfAnimalFoodIsZero(){
        return actualfood == 0;
    }

    /**
     * Función abstracta, cada animal da una cantidad especifica de dinero al jugador
     */
    public abstract void giveMoneyEachSecond();

    /**
     * Función abstracta, esta función retorna qué tipo de animal es el que se está llamando
     * @return valor de variable de tipo AnimalTypes con el tipo de animal
     */
    public abstract AnimalTypes getAnimalType();

    /**
     * Función principal de movimiento, esta función genera dos valores aleatorios entre -10 y 10 y modifica la
     * ubicación actual del animal
     */
    public void randomMovement() {
        int newXMovement = random.nextInt(20) - 10;
        int newYMovement = random.nextInt(20) - 10;

        // Ajustar el valor random entre -10 y 10 excluyendo el 0
        if (newXMovement >= 0) {
            newXMovement += 1;
        }
        if (newYMovement >= 0) {
            newYMovement += 1;
        }

        int newX = (int) ubicacion.getX() + newXMovement;
        int newY = (int) ubicacion.getY() + newYMovement;


        if (newX < initialLimits.getX()) {
            newX = (int) ubicacion.getX();
        }
        else if (newX > finalLimits.getX() - 25) {
            newX = (int) ubicacion.getX();
        }

        if (newY < initialLimits.getY()) {
            newY = (int) ubicacion.getY();
        }
        else if (newY > finalLimits.getY() - 30 ) {
            newY = (int) ubicacion.getY();
        }

        ubicacion.setLocation(newX, newY);
    }

    /**
     * Función que retorna la ubicación del Animal
     * @return valor de variable de tipo Point con la ubicación del animal
     */
    public Point getLocation(){
        return ubicacion;
    }

    public void setHitboxAnimal(HitboxAnimal hitboxAnimal){
        this.hitboxAnimal = hitboxAnimal;
    }

    public HitboxAnimal getHitboxAnimal(){
        return hitboxAnimal;
    }
}
