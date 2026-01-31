public class Help implements Command {
    @Override
    public String execute(String command, Player player, GameData datos) {
        if (command.equals("hrac")) {
            return "[jdi <sever, jih, vychod, zapad>; seber <predmet>; pouzij <predmet>; inventar <hrac>; mluv <postava>; odpoved <volba>; mapa <neco>; pomoc <hrac>]";
        }
        return "Pouzij: pomoc <hrac>!";
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
