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
    private ArrayList<String> neededItems;
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
