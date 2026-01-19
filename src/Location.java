import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private String id;
    private String name;
    private String uvodniText;
    private ArrayList<String> neededItems;
    private String[] inventory;
    private boolean turnedOn;
    private HashMap<String, String> neighbours;


    public Location() {

    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public boolean addItem(String item) {
        return false;
    }

    public boolean removeItem(String item) {
        return false;
    }
}
