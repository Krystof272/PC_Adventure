package Commands;

import Characters.Player;
import Game.GameData;

public class Help implements Command {
    @Override
    public String execute(String command, Player player, GameData datos) {
        return "[jdi <sever, jih, vychod, zapad>; seber <predmet>; pouzij <predmet>; inventar; mluv <postava>;" +
                " odpoved <volba>; mapa; pomoc]";
    }
}
