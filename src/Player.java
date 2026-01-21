import java.util.ArrayList;

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
        this.inventory = new ArrayList<>();
        this.maxInventorySize = 2;
        this.currentLocationId = "motherboard";
        this.currentTalkingNPC = null;
    }

    public boolean isInInventory(String itemName) {
        return inventory.contains(itemName);
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

    public ArrayList<String> getInventory() {
        return inventory;
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
