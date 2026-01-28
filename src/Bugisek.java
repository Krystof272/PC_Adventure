import java.util.Arrays;
import java.util.Random;

/**
 * this class creates and moves bugisek, evaulates if player encountered him
 */
public class Bugisek {
    private String[] location;

    public Bugisek() {
        this.location = new String[2];
        location[0] = "hdd";
    }

    /**
     * this method evaulates if bugisek and player met
     *
     * @param currentLocation of player
     * @param newLocation of player
     * @return returns true if they met
     */
    public boolean meetWithPlayer(String currentLocation, String newLocation) {
        if (currentLocation.equals(location[1]) && newLocation.equals(location[0])) {
            return true;
        } else if (currentLocation.equals(location[0]) && newLocation.equals(location[1])) {
            return true;
        }
        return false;
    }

    /**
     * this method moves bugisek, it assignees second location to first and first location to seconds locations neighbour
     *
     * @param datos data container
     * @return returns true if the movement happened
     */
    public boolean move(GameData datos) {
        Random rnd = new Random();
        String[] directions = {"sever", "jih", "vychod", "zapad"};

        location[1] = location[0];
        do {
            location[0] = datos.getLocation(location[1]).getNeighbour(directions[rnd.nextInt(directions.length)]);
        } while (location[0] == null || location[0].isEmpty());
        return true;
    }

    @Override
    public String toString() {
        return "Bugisek{" +
                "location=" + Arrays.toString(location) +
                '}';
    }
}
