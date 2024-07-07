package Logic;

import java.util.Random;
import java.awt.*;

public abstract class Animal {
    private final int MAX_FOOD = 20;
    private int actualfood;
    private final Point ubicacionInicial;
    private Point ubicacion;
    private Point initialLimits;
    private Point finalLimits;

    Random random = new Random();


    public Animal(Point initialLimits, Point finalLimits){
        this.initialLimits = initialLimits;
        this.finalLimits = finalLimits;
        actualfood = MAX_FOOD;
        ubicacionInicial = new Point(100 + (int)initialLimits.getX(), 90 + (int)initialLimits.getY());
        ubicacion = ubicacionInicial;
    }

    public boolean checkIfAnimalFoodIsZero(){
        return actualfood == 0;
    }


    public void randomMovement() {
        int newXMovement = random.nextInt(20) - 10;
        int newYMovement = random.nextInt(20) - 10;

        // Esto arregla la tendencia de irse hacia arriba izquierda
        if (newXMovement >= 0){
            newXMovement += 1;
        }
        if (newYMovement >= 0){
            newYMovement += 1;
        }

        int newX = (int)ubicacion.getX() + newXMovement;
        int newY = (int)ubicacion.getY() + newYMovement;


        if (newX < initialLimits.getX()) {
            newX = (int) ubicacion.getX();
        }
        else if (newX > finalLimits.getX() - 15) {
            newX = (int) ubicacion.getX();
        }

        if (newY < initialLimits.getY()) {
            newY = (int) ubicacion.getY();
        }
        else if (newY > finalLimits.getY() - 20 ) {
            newY = (int) ubicacion.getY();
        }

        ubicacion.setLocation(newX, newY);
    }

    public void scaleLimitsAndPositions(Point initialLimits, Point finalLimits){
        this.initialLimits = initialLimits;
        this.finalLimits = finalLimits;
    }

    public Point getLocation(){
        return ubicacion;
    }

    public int getPosY(){
        return (int)ubicacion.getY();
    }

    public int getPosX(){
        return (int)ubicacion.getX();
    }

    public abstract AnimalTypes getAnimalType();

}
