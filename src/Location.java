import java.util.ArrayList;

public class Location {
    private String name;
    private String uvodniText;
    private boolean turnedOn;
    private int[] inventory;
    private ArrayList<String> neededItems;

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
