/**
 * this class answers npcs questions
 */
public class Answer implements Command {

    /**
     * this method returns answer
     *
     * @param command player chosen answer
     * @param player  current playing player
     * @param datos   object filled with data
     * @return returns the answer from the npc
     */
    @Override
    public String execute(String command, Player player, GameData datos) {
        NPC npc = datos.getNPC(player.getCurrentTalkingNPC());
        if (npc != null) {
            return npc.getAnswer(command);
        }
        return "Nejdrive musis zacit konverzaci s npc!";
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
