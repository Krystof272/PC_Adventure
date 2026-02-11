package Commands;

import Characters.NPC;
import Characters.Player;
import Game.GameData;

/**
 * this class starts conversation with a npc
 * @author krystof
 */
public class Speak implements Command {
    /**
     * starts conversation with npc
     *
     * @param command the npc player wants to talk to
     * @param player  current playing player
     * @param datos   object filled with data
     * @return returns initial text of npc, if the npc exists and is in the same location as the player
     */
    @Override
    public String execute(String command, Player player, GameData datos) {
        NPC npc = datos.getNPC(command);
        if (npc != null) {
            if (player.getCurrentLocationId().equals(npc.getHomeLocationId())) {
                player.setCurrentTalkingNPC(command);
                return npc.getInitialEncouterText();
            }
            return "Npc " + command + " neni v teto mistnosti!";
        }
        return "Npc " + command + " neexistuje!";
    }
}
