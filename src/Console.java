import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private HashMap<String, Command> comands;
    private boolean isExit;
    private Scanner sc;
    private GameData datos = GameData.loadGameDataFromResources("/gameData.json");
    private Player player;

    public Console() {
        this.comands = new HashMap<>();
        this.isExit = false;
        this.sc = new Scanner(System.in);
        this.player = new Player("Player");
    }

    public void inicialization(){
        comands.put("jdi", new Move());
    }

    public void execute(){
        System.out.print(">> ");
        String inputCommand = sc.nextLine();
        String[] commnads = inputCommand.split(" ");

        if (comands.containsKey(commnads[0])){
            System.out.println(comands.get(commnads[0]).execute(commnads[1], player, datos));
            isExit = comands.get(commnads[0]).isExit();
        } else {
            System.out.println("Command not recognized");
        }

        System.out.println(player);
    }

    public void start(){
        inicialization();
        //TODO nacitani jmena hrace z konzole
        do{
            execute();
        } while (!isExit);
    }
}
