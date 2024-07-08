package Logic;

import java.util.Random;
import java.awt.*;
import java.time.Instant;

/**
 * Clase abstracta que representa a un Animal con sus propiedades
 */
public abstract class Animal {
    private final int MAX_FOOD = 20;
    private int actualFood;
    private final Point ubicacionInicial;
    private Point ubicacion;
    private Instant horaCreado;
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
        this.actualFood = MAX_FOOD;
        this.ubicacion = ubicacionInicial;
        this.horaCreado = Instant.now();
    }

    /**
     * Metodo getter, sirve para saber la cantidad maxima de comida del deposito del habitat
     * @return actualFood de tipo int, es la maxima capacidad del deposito de comida del habitat
     */
    public int getActualFood(){
        return actualFood;
    }

    public boolean eat(int habitatFoodQuantity){
        if (actualFood < MAX_FOOD && habitatFoodQuantity > 0){
            actualFood += 1;
            return true;
        }
        return false;
    }

    /**
     * Método con el cual los animales ganan hambre.
     */
    public void loseFood(){
        actualFood -= 1;
    }

    /**
     * Función que revisa si el animal no ha comido
     * @return booleano que indica si actualFood es 0
     */
    public boolean checkIfAnimalFoodIsZero(){
        return actualFood == 0;
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

    /**
     * Método que calcula el precio para vender un animal.
     * @return int con el dinero que vale el animal.
     */
    public int calculateSellValue(){
        return (int)(Instant.now().getEpochSecond() - horaCreado.getEpochSecond()) + getAnimalType().getPrice()/2;
    }

    /**
     * Metodo de tipo setter, se encarga de asignarle una hitbox al Animal
     * @param hitboxAnimal Parametro de tipo HitboxAnimal, guarda la hitbox del animal
     */
    public void setHitboxAnimal(HitboxAnimal hitboxAnimal){
        this.hitboxAnimal = hitboxAnimal;
    }

    /**
     * Metodo de tipo getter, entrega la hitbox del animal
     * @return variable de tipo HitboxAnimal, contiene la hitbox del animal en tiempo real
     */
    public HitboxAnimal getHitboxAnimal(){
        return hitboxAnimal;
    }
}
