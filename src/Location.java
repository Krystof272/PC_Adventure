import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * this class creates individual locations, gets info from them
 */
public class Location {
    private String id;
    private String name;
    private String introductoryText;
    private HashMap<String, Integer> neededItems;
    private String[] inventory;
    private boolean turnedOn;
    private HashMap<String, String> neighbours;

    /**
     * gets the neighbour location in that direction
     *
     * @param direction the requsted direction from user
     * @return returns the neighbour location in that direction or
     * null if it doesn't exist
     */
    public String getNeighbour(String direction) {
        if (neighbours.containsKey(direction)) {
            return neighbours.get(direction);
        }
        return null;
    }

    /**
     * removes item from location inventory
     *
     * @param item requested to remove item
     * @return returns if the operation was successful
     */
    public boolean removeItem(String item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(item)) {
                inventory[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * adds item to inventory, if it can go there
     *
     * @param item added item
     * @return returns if the operation was successful
     */
    public String addItem(String item) {
        if (neededItems.get(item) != null) {
            int currentCount = 0;
            for (String i : inventory) {
                if (i != null && i.equals(item)) {
                    currentCount++;
                }
            }

            if (neededItems.get(item) > currentCount) {
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] == null) {
                        inventory[i] = item;
                        return "pridan";
                    }
                }
            }
            return "nepridan";
        }
        return "nepatri";
    }

    public String getId() {
        return id;
    }

    public String getIntroductoryText() {
        return introductoryText;
    }

    @Override
    public String toString() {
        return "\nLocation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", introductoryText='" + introductoryText + '\'' +
                ", neededItems=" + neededItems +
                ", inventory=" + Arrays.toString(inventory) +
                ", turnedOn=" + turnedOn +
                ", neighbours=" + neighbours +
                '}';
    }
}
