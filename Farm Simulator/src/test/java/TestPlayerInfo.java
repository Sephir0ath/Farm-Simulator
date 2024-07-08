import Logic.PlayerInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlayerInfo {
    private PlayerInfo playerInfo;

    @BeforeEach
    void setup(){
        playerInfo = new PlayerInfo();
    }

    /**
     * Test que comprueba que se obtienen correctamente las estidisticas del jugador al llamar a getStats
     */
    @Test
    @DisplayName("Test obtener estadisticas iniciales del jugador")
    void testGetInitialStats() {
        assertEquals(5550, playerInfo.getStats(0));
        assertEquals(0, playerInfo.getStats(1));
        assertEquals(0, playerInfo.getStats(2));
        assertEquals(0, playerInfo.getStats(3));
        assertEquals(0, playerInfo.getStats(4));
    }

    /**
     * Test que añade una estadistica al jugador
     */
    @Test
    @DisplayName("Test añadir a una estadistica del jugador")
    void testAddToStat() {
        playerInfo.addToStat(0, 500);
        assertEquals(6050, playerInfo.getStats(0));

        playerInfo.addToStat(1, 5);
        assertEquals(5, playerInfo.getStats(1));
    }

    /**
     * Test que cambia la estadistica de cierto stat especifico
     */
    @Test
    @DisplayName("Test cambiar una estadistica del jugador a un valor específico")
    void testSetStat() {
        playerInfo.setStats(0, 10000);
        assertEquals(10000, playerInfo.getStats(0));

        playerInfo.setStats(2, 3);
        assertEquals(3, playerInfo.getStats(2));
    }

}
