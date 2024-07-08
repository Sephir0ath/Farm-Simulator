package Logic;

/**
 * Clase abstracta, crea comida de cierto tipo
 */
public abstract class Food {
    /**
     * Metodo constructor, creacion de la comida
     */
    public Food() {
    }
    /**
     * Metodo abstracto de tipo getter, entrega el tipo de comida
     * @return un alimento de tipo FoodTypes
     */
    public abstract FoodTypes getFoodType();
}