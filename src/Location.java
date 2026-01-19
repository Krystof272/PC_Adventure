import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Location {
    private String id;
    private String name;
    private String uvodniText;
    private ArrayList<String> neededItems;
    private String[] inventory;
    private boolean turnedOn;
    private HashMap<String, String> neighbours;



    @Override
    public String toString() {
        return "\nLocation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", uvodniText='" + uvodniText + '\'' +
                ", neededItems=" + neededItems +
                ", inventory=" + Arrays.toString(inventory) +
                ", turnedOn=" + turnedOn +
                ", neighbours=" + neighbours +
                '}';
    }
}
