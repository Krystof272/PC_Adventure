package Commands;

import Characters.Player;
import Game.GameData;

/**
 * this class returns contents of the inventory
 */
public class Inventory implements Command {

    @Override
    public String execute(String command, Player player, GameData datos) {
        return player.getInventory();
    }
}
