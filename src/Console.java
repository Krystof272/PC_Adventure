import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * this class displays and processes input from the user
 */
public class Console {
    private HashMap<String, Command> comands;
    private boolean isExit;
    private Scanner sc;
    private Random rnd;
    private GameData datos = GameData.loadGameDataFromResources("/gameData.json");
    private Player player;
    private Bugisek bugisek;


    public Console() {
        this.comands = new HashMap<>();
        this.isExit = false;
        this.sc = new Scanner(System.in);
        this.rnd = new Random();
        this.player = new Player("Player");
        this.bugisek = new Bugisek();
    }

    /**
     * adds commands to hashmap
     */
    public void initialization(){
        comands.put("jdi", new Move(bugisek));
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
        bugisek.move(datos);

        System.out.println(datos.getLocation(player.getCurrentLocationId()));
        System.out.println(player);
        System.out.println(bugisek);

        System.out.print(">> ");
        String inputCommand = sc.nextLine();
        String[] inputCommnads = inputCommand.split(" ");


        if(inputCommnads.length > 1) {
            if (comands.containsKey(inputCommnads[0])) {
                System.out.println(comands.get(inputCommnads[0]).execute(inputCommnads[1].toLowerCase(), player, datos));
                isExit = comands.get(inputCommnads[0]).isExit();

                gameMechanics(inputCommnads[1]);
            } else {
                System.out.println("Tento prikaz neexistuje, tato hra podporuje tyto prikazy: "+ comands.get("pomoc").execute("hrac", player, datos));
            }

        } else {
            System.out.println("Zadejte prikaz ve forme: prikaz + co/kam/kdo!\nTato hra podporuje tyto prikazy: "+ comands.get("pomoc").execute("hrac", player, datos));
        }
    }

    /**
     *  cycle loop
     */
    public void start(){
        initialization();
        //TODO nacitani jmena hrace z konzole
        System.out.println("V teto hre se pouzivaji tyto prikazy: "+ comands.get("pomoc").execute("hrac", player, datos));
        do{
            execute();
        } while (!isExit);
    }

    /**
     * this class does 3 mechanics:
     * 1) checks if the user requested electricity to psu
     * 2) converts electricity to information in chlazeni and electricity to information in ram
     * 3) checks if the user requested to turn on the computer and evaluates if it can do that
     * 4) if hdd inventory is full, player inventory size increases
     *
     * @param input from user
     */
    public void gameMechanics(String input) {
        if (input.equals("2") && player.getCurrentTalkingNPC().equals("zakladacek")) {
            datos.getLocation("psu").addItem("elektrina");
        }


        Location chlazeni = datos.getLocation("chlazeni");
        if (chlazeni.containsItem("elektrina")) {
            chlazeni.removeItem("elektrina");
            chlazeni.addItem("chlazeni");
        }

        Location ram = datos.getLocation("ram");
        if (ram.containsItem("elektrina")) {
            ram.removeItem("elektrina");
            ram.addItem("informace");
        }

        if (input.equals("3") && player.getCurrentTalkingNPC().equals("zakladacek")) {
            boolean allTurnedOn = true;
            ArrayList<String> notTurnedOn = new ArrayList<>();
            for (Location l : datos.getLocationList()) {
                if (!l.isTurnedOn()) {
                    allTurnedOn = false;
                    notTurnedOn.add(l.getName());
                }
            }
            if (allTurnedOn) {
                isExit = true;
            } else {
                System.out.println("Zapnuti selhalo, tyto komponenty nemaji dostatek zdroju: "+ notTurnedOn);
            }
        }

        if (datos.getLocation("hdd").isFull()){
            player.setMaxInventorySize(4);
        }
    }
}
