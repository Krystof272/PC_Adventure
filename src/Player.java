import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<String> inventory;
    private int maxInventorySize;
    private String currentLocation;
    private String currentTalkingNPC;

    public boolean isInInventory(String itemName) {
        return inventory.contains(itemName);
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
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
}
