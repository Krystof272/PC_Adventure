/**
 * this class moves the player
 */
public class Move implements Command {

    /**
     * moves the player, if the locations are linked and the location exists
     *
     * @param command direction, where the player wants to go
     * @param player  current playing player
     * @param datos   object filled with data
     * @return evaulates and retunrs introductory text, you can't go there, this direction doesn't exist
     */
    @Override
    public String execute(String command, Player player, GameData datos) {
        String neighbour = datos.getLocation(player.getCurrentLocationId()).getNeighbour(command);
        if (neighbour == null) {
            return "Tento smer neexistuje!";
        } else if (neighbour.isEmpty()) {
            return "Tam jit nemuzes!";
        }
        player.setCurrentLocationId(neighbour);

        return datos.getLocation(neighbour).getIntroductoryText();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
