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
                turnedOn = false;
                return true;
            }
        }
        return false;
    }

    /**
     * adds item to inventory, if it is in the filter neededItems and the number of
     * that item isn't over limit
     *
     * @param item added item
     * @return returns if the operation was successful, or there were any problems
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
                        if (isFull()) {
                            turnedOn = true;
                        }
                        return "pridan";
                    }
                }
            }
            return "nepridan";
        }
        return "nepatri";
    }

    /**
     * checks if the wanted item is there
     *
     * @param item checked item
     * @return returns if the item is there
     */
    public boolean containsItem(String item) {
        for (String s : inventory) {
            if (s != null && s.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks if the location is full
     *
     * @return returns if the inventory of the location is full
     */
    public boolean isFull() {
        for (String s : inventory) {
            if (s == null) {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIntroductoryText() {
        return introductoryText;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    /**
     * @return returns text zapnut or vypnut depending on boolean turnedOn
     */
    public String turnedOnText() {
        if (turnedOn) {
            return "zapnut";
        }
        return "vypnut";
    }

    /**
     *
     * @return returns toString of neededItems
     */
    public String neededItemsText() {
        String text = "[";
        int i = 0;
        for (String s : neededItems.keySet()) {
            i++;
            if (i == neededItems.size()) {
                text += s + " " + neededItems.get(s);
            } else {
                text += s + " " + neededItems.get(s) + ", ";
            }

        }

        return text + "]";
    }

    @Override
    public String toString() {
        return "Jsi v mistnosti " + name + ": inventar " + Arrays.toString(inventory) + ", potrebne predmety " + neededItemsText() + ", komponent " + turnedOnText();
    }
}
