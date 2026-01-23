/**
 * this class uses items from player inventory
 */
public class Use implements Command {

    /**
     * this method moves item from player inventory to location
     *
     * @param command requested item
     * @param player current playing player
     * @param datos object filled with data
     * @return returns if the usage was successful or there were any problems
     */
    @Override
    public String execute(String command, Player player, GameData datos) {
        if(player.removeItem(command)){
            if(datos.getLocation(player.getCurrentLocationId()).addItem(command)){
                return "Predmet "+ command +" odebran z inventare.";
            } else {
                player.addItem(command);
                return "Do teto lokace tento predmet dat nemuzes!";
            }
        }
        return "Item nenalezen v inventari!";
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
