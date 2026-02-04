package Commands;

import Characters.Player;
import Game.GameData;

/**
 * this class uses items from player inventory
 */
public class Use implements Command {

    /**
     * this method moves item from player inventory to location
     *
     * @param command requested item
     * @param player  current playing player
     * @param datos   object filled with data
     * @return returns if the usage was successful or there were any problems
     */
    @Override
    public String execute(String command, Player player, GameData datos) {
        if (player.removeItem(command)) {
            switch (datos.getLocation(player.getCurrentLocationId()).addItem(command)) {
                case "pridan":
                    return "Predmet " + command + " pridan do lokace.";
                case "nepatri":
                    player.addItem(command);
                    return "Do teto lokace predmet " + command + " dat nemuzes!";
                case "nepridan":
                    player.addItem(command);
                    return "Vice predmetu " + command + " neni potreba!";
            }
        }
        return "Item nenalezen v inventari!";
    }
}
