import java.awt.*;

import Logic.Animal;
import Logic.Cow;
import Logic.HitboxAnimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogicAnimal {
    private Point initialLimits;
    private Point finalLimits;
    private Animal vaca;


    @BeforeEach
    public void setUp() {
        initialLimits = new Point(0, 0);
        finalLimits = new Point(500, 500);
        vaca = new Cow(initialLimits, finalLimits);
    }

    /**
     * Test que comprueba el obtener la comida que posee un animal actualmente
     */
    @Test
    @DisplayName("Test btener comida actual del animal")
    public void testGetActualFood() {
        assertEquals(20, vaca.getActualFood());
    }

    /**
     * Test que comprueba que al llamar al metodo, loseFood el animal pierde comida y al llamar a Eat el animal gana comida
     */
    @Test
    @DisplayName("Test perder comida y comer")
    public void testLoseFoodAndEat() {
        vaca.loseFood();
        assertEquals(19, vaca.getActualFood());
        assertTrue(vaca.eat(10));
        assertEquals(20, vaca.getActualFood());
    }

    /**
     * Test que comprueba que la comida de un animal es cero
     */
    @Test
    @DisplayName("Test Checkear que la comida de un animal es cero")
    public void testCheckIfAnimalFoodIsZero() {
        for (int i = 0; i < 20; i++) {
            vaca.loseFood();
        }
        assertTrue(vaca.checkIfAnimalFoodIsZero());
    }

    /**
     * Test que comprueba que el valor de venta de un animal siempre será mayor que cero
     */
    @Test
    @DisplayName("Test calcular valor de venta")
    public void testCalculateSellValue() {
        int sellValue = vaca.calculateSellValue();
        assertTrue(sellValue > 0);
    }

    /**
     * Test que comprueba que a un animal se le asigna una hitbox y se puede devolver
     */
    @Test
    @DisplayName("Test setear y obtener Hitbox de animal")
    public void testSetAndGetHitboxAnimal() {
        HitboxAnimal hitbox = new HitboxAnimal(new Point(0,0));
        vaca.setHitboxAnimal(hitbox);
        assertEquals(hitbox, vaca.getHitboxAnimal());
    }

}
