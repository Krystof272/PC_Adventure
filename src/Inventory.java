/**
 * this class returns contents of the inventory
 */
public class Inventory implements Command {

    @Override
    public String execute(String command, Player player, GameData datos) {
        if (command.equals("player")) {
            return player.getInventory();
        }
        return "Pouzij: inventory + <player>!";
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
