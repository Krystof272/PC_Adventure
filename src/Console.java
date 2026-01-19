import Commands.Command;
import Commands.Jdi;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private static HashMap<String, Command> comands;
    private boolean isExit;
    private Scanner sc;
    private GameData datos = GameData.loadGameDataFromResources("/gameData.json");

    public Console() {
        this.comands = new HashMap<>();
        this.isExit = false;
        this.sc = new Scanner(System.in);
    }

    public void inicialization(){
        comands.put("jdi", new Jdi());
        comands.put("help", new Help());
    }

    public void execute(){
        System.out.print(">> ");
        String command = sc.next();

        if (comands.containsKey(command)){
            System.out.println(comands.get(command).execute());
            isExit = comands.get(command).isExit();
        } else {
            System.out.println("Command not recognized");
        }
    }

    public void start(){
        inicialization();

        //TODO nacitani jmena hrace z konzole
        Player player = new Player("Krystof");
        do{
            execute();
        } while (!isExit);
    }

    public static String getCommands(){
        return comands.keySet().toString();
    }
}
