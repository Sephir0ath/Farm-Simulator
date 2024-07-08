import Exceptions.*;
import Logic.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase diseñada para realizar Test unitarios sobre los metodos en la clase Habitat
 */
public class TestLogicHabitat {
    private Habitat habitat;
    private Animal vaca;

    /**
     * Inicializa las variables que serán utilizadas en los tests
     */
    @BeforeEach
    void setup(){
        habitat = new Habitat();
        vaca = new Cow(new Point(0, 0), new Point(100, 100));
    }

    /**
     * Test para verificar que se puede añadir un animal a un habitat
     */
    @Test
    @DisplayName("Añadir un animal a un habitat")
    void TestAddAnimalToHabitat() throws AnimalTypeDifferentFromHabitatTypeException, FullCapacityException {
        habitat.addAnimalToHabitat(vaca);
        assertEquals(1, habitat.getAnimalQuantity());
    }

    /**
     * Test oara verificar si se intenta añadir más animales de los que el habitat puede contener
     * Un Habitat posee una capacidad maxima por defecto de 5 animales, por lo que en este test se añaden 6 animales
     * Se debe lanzar la excepción FulLCapacityException
     */
    @Test
    @DisplayName("Colocar Animal con Habitat lleno")
    void testAddAnimalWithFullCapacity() throws  AnimalTypeDifferentFromHabitatTypeException{
        try{
            for (int i = 0; i < 6; i++)
                habitat.addAnimalToHabitat(vaca);
        } catch (FullCapacityException e) {
            assertTrue(true);
        }
    }

    /**
     * Test para verificar el intento de colocar un animal de distinto tipo en un habitat
     * Se debe lanzar la excepcion AnimalTypeDifferentFromHabitatType
     */
    @Test
    @DisplayName("Colocar Animal de distinto tipo en un Habitat")
    void testDifferentTypeOfAnimal() throws FullCapacityException{
        try{
            Animal cerdo = new Pig(new Point(0,0), new Point(100, 100));

            habitat.addAnimalToHabitat(vaca);
            habitat.addAnimalToHabitat(cerdo);
        } catch (AnimalTypeDifferentFromHabitatTypeException e) {
            assertTrue(true);
        }
    }

    /**
     * Test para verificar que al eliminar un animal de un habitat el habitat se resetea
     */
    @Test
    @DisplayName("Test desactivar habitat")
    public void testCheckAndDeactivateHabitatIfIsEmpty() throws FullCapacityException, AnimalTypeDifferentFromHabitatTypeException {
        habitat.addAnimalToHabitat(vaca);
        habitat.deleteAnimal(vaca);
        habitat.checkAndDeactivateHabitatIfIsEmpty();
        assertFalse(habitat.checkIsHabitatActive());
    }

    /**
     * Test para verificar que se puede aumentar la capacidad maxima de animales de un habitat
     */
    @Test
    @DisplayName("Test aumentar capacidad de animales")
    public void testIncreaseAnimalLimit() {
        habitat.increaseAnimalLimit();
        assertEquals(6, habitat.getAnimalQuantityLimit());
    }

    /**
     * Test para verificar que se puede aumentar la capacidad maxima de comida de un habitat
     */
    @Test
    @DisplayName("Test aumentar capacidad de comida")
    public void testIncreaseMaxFoodLimit() {
        habitat.increaseMaxFoodLimit();
        assertEquals(70, habitat.getFoodReserve());
    }

    /**
     * Test que verifica que la llamar a la funcion fullReset, los parametros del habitat son reiniciados a los del principio del juego
     */
    @Test
    @DisplayName("Test reseteo completo")
    public void testFullReset() throws FullCapacityException, AnimalTypeDifferentFromHabitatTypeException {
        habitat.addAnimalToHabitat(vaca);
        habitat.fullReset();
        assertEquals(0, habitat.getAnimalQuantity());
        assertFalse(habitat.checkIsHabitatActive());
        assertNull(habitat.getHabitatType());
        assertEquals(0, habitat.getFoodDeposit().getFoodDeposit().size());
    }

}
