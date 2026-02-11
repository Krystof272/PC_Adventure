package Commands;

import Characters.Player;
import Game.GameData;

/**
 * interface command
 *
 * @author krystof
 */
public interface Command {
    String execute(String command, Player player, GameData datos);
}
