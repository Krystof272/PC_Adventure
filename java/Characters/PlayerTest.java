package Characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        player = new Player("Krystof");
    }

    @Test
    void addItem() {
        assertTrue(player.addItem("elektrina"));
    }

    @Test
    void removeItem() {
        player.addItem("elektrina");
        assertTrue(player.removeItem("elektrina"));
    }

    @Test
    void getCurrentLocationId() {
        player.setCurrentLocationId("cpu");
        assertEquals("cpu", player.getCurrentLocationId());
    }
}