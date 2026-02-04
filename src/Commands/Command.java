package Commands;

import Characters.Player;
import Game.GameData;

public interface Command {
    String execute(String command, Player player, GameData datos);
}
