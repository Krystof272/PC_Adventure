import java.util.HashMap;
import java.util.Scanner;

/**
 * this class displays and processes input from the user
 */
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

    /**
     * adds commands to hashmap
     */
    public void initialization(){
        comands.put("jdi", new Move());
        comands.put("inventar", new Inventory());
        comands.put("seber", new Pick_up());
        comands.put("pouzij", new Use());
        comands.put("pomoc", new Help());
        comands.put("mluv", new Speak());
        comands.put("odpoved", new Answer());
    }

    /**
     * console output and input command loader, input command analyzer
     */
    public void execute(){
        System.out.println(datos.getLocation("gpu"));
        System.out.println(player);

        System.out.print(">> ");
        String inputCommand = sc.nextLine();
        String[] inputCommnads = inputCommand.split(" ");

        if(inputCommnads.length > 1) {
            if (comands.containsKey(inputCommnads[0])) {
                System.out.println(comands.get(inputCommnads[0]).execute(inputCommnads[1], player, datos));
                isExit = comands.get(inputCommnads[0]).isExit();
            } else {
                System.out.println("Tento prikaz neexistuje!");
            }

        } else {
            System.out.println("Zadejte prikaz ve forme: prikaz + co/kam/kdo!");
        }
    }

    /**
     *  cycle loop
     */
    public void start(){
        initialization();
        //TODO nacitani jmena hrace z konzole
        do{
            execute();
        } while (!isExit);
    }
}
