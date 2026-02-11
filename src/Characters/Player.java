package Characters;

import java.util.ArrayList;

/**
 * this class creates player and manages him
 * @author krystof
 */
public class Player {
    private String name;
    private ArrayList<String> inventory;
    private int maxInventorySize;
    private String currentLocationId;
    private String currentTalkingNPC;

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.maxInventorySize = 2;
        this.currentLocationId = "motherboard";
        this.currentTalkingNPC = "";
    }

    /**
     * adds item to player inventory, if the inventory is not full
     *
     * @param itemName added item
     * @return returns if the action was successful
     */
    public boolean addItem(String itemName) {
        inventory.add(itemName);
        if (inventory.size() > maxInventorySize) {
            inventory.remove(itemName);
            return false;
        }
        return true;
    }

    public boolean removeItem(String itemName) {
        return inventory.remove(itemName);
    }

    public String getCurrentLocationId() {
        return currentLocationId;
    }

    public void setCurrentLocationId(String currentLocationId) {
        this.currentLocationId = currentLocationId;
    }

    public String getName() {
        return name;
    }

    public String getCurrentTalkingNPC() {
        return currentTalkingNPC;
    }

    public void setCurrentTalkingNPC(String currentTalkingNPC) {
        this.currentTalkingNPC = currentTalkingNPC;
    }

    public String getInventory() {
        return inventory.toString();
    }

    public int getMaxInventorySize() {
        return maxInventorySize;
    }

    public void setMaxInventorySize(int maxInventorySize) {
        this.maxInventorySize = maxInventorySize;
    }

    public boolean clearInventory() {
        inventory.clear();
        return true;
    }

    @Override
    public String toString() {
        return "Characters.Player{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                ", maxInventorySize=" + maxInventorySize +
                ", currentLocationId='" + currentLocationId + '\'' +
                ", currentTalkingNPC='" + currentTalkingNPC + '\'' +
                '}';
    }
}
