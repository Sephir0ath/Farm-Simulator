import Exceptions.*;
import Logic.Animals.Animal;
import Logic.Animals.Cow;
import Logic.Foods.Apple;
import Logic.Foods.FoodDeposit;
import Logic.Foods.FoodTypes;
import Logic.Foods.Wheat;
import Logic.Habitat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase diseñada para realizar Test unitarios sobre los metodos de la clase FoodDeposit
 */
public class TestFoodDeposit {
    private FoodDeposit foodDeposit;
    private Habitat habitat;
    private Animal vaca;

    /**
     * Inicializa las variables que serán utilizadas en los tests
     */
    @BeforeEach
    void setup(){
        habitat = new Habitat();
        foodDeposit = new FoodDeposit();
        vaca = new Cow(new Point(0, 0), new Point(100, 100));

    }

    /**
     * Test que verifica que no se pueda añadir más comida de lo que FoodDeposit puede contener
     * Cada vez que se llama addFoodToDeposit se añade 20 de comida a FoodDeposit
     * Se debe lanzar la excepcion FullDepositException
     */
    @Test
    @DisplayName("Añadir comida con el deposito de comida lleno")
    void TestFullFoodDeposit() throws HabitatTypeIsNullException, FoodTypeDifferentFromHabitatTypeException, AnimalTypeDifferentFromHabitatTypeException, FullCapacityException {
        habitat.addAnimalToHabitat(vaca);

        try{
            for (int i = 0; i < 4; i++){
                habitat.addFoodToDeposit(new Wheat());
            }
        }
        catch (FullDepositException e) {
            assertTrue(true);
        }
    }

    /**
     * Test que verifica que no se puede añadir comida cuando el tipo de habitat es null
     * Se debe lanzar la excepcion HabitatTypeIsNullException
     */
    @Test
    @DisplayName("Añadir comida cuando hay un habitat sin un tipo de animal")
    void TestAddFoodWithNoAnimalType() throws FullDepositException, FoodTypeDifferentFromHabitatTypeException {
        try{
            habitat.addFoodToDeposit(new Wheat());
        }
        catch (HabitatTypeIsNullException e){
            assertTrue(true);
        }
    }

    /**
     * Test para verificar que no se puede añadir una comida que no pertenece a la de un animal
     */
    @Test
    @DisplayName("Tipo de comida equivocada")
    void TestWrongFoodType() throws AnimalTypeDifferentFromHabitatTypeException, FullCapacityException, FullDepositException, HabitatTypeIsNullException {
        habitat.addAnimalToHabitat(vaca);
        try{
            habitat.addFoodToDeposit(new Apple());
        }
        catch (FoodTypeDifferentFromHabitatTypeException e){
            assertTrue(true);
        }
    }

    /**
     * Test que verifica que setDepositTypeNull vuelve al deposito en null
     */
    @Test
    @DisplayName("Test set Deposito Null")
    public void testSetDepositTypeNull() {
        foodDeposit.setDepositType(vaca);
        foodDeposit.setDepositTypeNull();
        assertNull(foodDeposit.getDepositType());
    }

    /**
     * Test que comprueba que se pueda setear un deposito de comida a cierto tipo de comida
     */
    @Test
    @DisplayName("Test setear tipo de deposito")
    public void testSetDepositType() {
        foodDeposit.setDepositType(vaca);
        assertEquals(FoodTypes.TRIGO, foodDeposit.getDepositType());
    }

    /**
     * Test que verifica que se obtiene la cantidad actual de comida que tiene el deposito
     */
    @Test
    @DisplayName("Obtener la comida actual del deposito")
    public void testGetActualFoodInDeposit() {
        foodDeposit.addFood(new Wheat(), 100);
        assertEquals(20, foodDeposit.getActualFoodInDeposit());
    }

}


