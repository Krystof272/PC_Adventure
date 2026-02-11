package Commands;

import Characters.Player;
import Game.GameData;

/**
 * returns map of the game
 * @author krystof
 */
public class Map implements Command {
    @Override
    public String execute(String command, Player player, GameData datos) {
        return """
                           +----------+
                           | Chlazení |
                           +----------+
                                |
                           +----------+
                    +------|    CPU   |
                    |      +----------+
                    |           |
                +-------+  +----------+     +-------+
                | Zdroj |--| Základní |-----|  RAM  |
                +-------+  |   deska  |     +-------+
                    |      +----------+
                    |         |
                    |      +-----+  +-----+
                    +------| GPU |--| HDD |
                           +-----+  +-----+
                """;
    }
}
