package Commands;

import Characters.Bugisek;
import Characters.Player;
import Game.GameData;

/**
 * this class moves the player
 */
public class Move implements Command {
    Bugisek bugisek;

    public Move(Bugisek bugisek) {
        this.bugisek = bugisek;
    }

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

        if (bugisek.meetWithPlayer(player.getCurrentLocationId(), neighbour)) {
            player.clearInventory();
            System.out.println("Potkal jsi se s Bugiskem, tvuj inventar byl vymazan. Priste se mu zkus vyhnout!");
        }

        player.setCurrentLocationId(neighbour);
        player.setCurrentTalkingNPC("");

        return datos.getLocation(neighbour).getIntroductoryText();
    }
}
