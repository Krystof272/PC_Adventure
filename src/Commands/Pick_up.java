package Commands;

import Characters.Player;
import Game.GameData;

/**
 * this class pickups items from locations
 */
public class Pick_up implements Command {

    /**
     * this method moves item from location to player inventory
     *
     * @param command requested item
     * @param player current playing player
     * @param datos object filled with data
     * @return returns if the pickup was successful or there were any problems
     */
    @Override
    public String execute(String command, Player player, GameData datos) {
        if(datos.getLocation(player.getCurrentLocationId()).removeItem(command)){
            if(player.addItem(command)){
                return "Predmet "+ command +" pridan do inventare.";
            } else {
                datos.getLocation(player.getCurrentLocationId()).addItem(command);
                return "Mas plny inventar!";
            }
        }
        return "Item nenalezen v lokaci.";
    }
}
