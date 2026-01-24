/**
 * this class returns contents of the inventory
 */
public class Inventory implements Command {

    @Override
    public String execute(String command, Player player, GameData datos) {
        if (command.equals("hrac")) {
            return player.getInventory();
        }
        return "Pouzij: inventory <hrac>!";
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
