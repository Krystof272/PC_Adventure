package Game;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    Location location;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("informace", 2);
        String[] inventory = {null, null};
        HashMap<String, String> neighbours = new HashMap<>();
        neighbours.put("sever", "cpu");

        location = new Location("motherboard", "zakladni deska", "", map, inventory, false, neighbours);
    }

    @Test
    void getNeighbour() {
        assertEquals("cpu", location.getNeighbour("sever"));
    }

    @Test
    void addItem() {
        assertEquals("pridan", location.addItem("informace"));
    }

    @Test
    void neededItemsText() {
        assertEquals("[informace 2]", location.neededItemsText());
    }
}