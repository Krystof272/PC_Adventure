import java.util.ArrayList;
import java.util.Arrays;

/**
 * this class creates player
 */
public class Player {
    private String name;
    private ArrayList<String> inventory;
    private int maxInventorySize;
    private String currentLocationId;
    private String currentTalkingNPC;

    public Player(String name) {
        this.name = name;
        //TODO zmenit zpatky na normal
        this.inventory = new ArrayList<>(Arrays.asList("elektrina","elektrina","elektrina", "chlazeni", "informace"));
        this.maxInventorySize = 5;
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

    public void setMaxInventorySize(int maxInventorySize) {
        this.maxInventorySize = maxInventorySize;
    }

    public boolean clearInventory() {
        inventory.clear();
        return true;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                ", maxInventorySize=" + maxInventorySize +
                ", currentLocationId='" + currentLocationId + '\'' +
                ", currentTalkingNPC='" + currentTalkingNPC + '\'' +
                '}';
    }
}
