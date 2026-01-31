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
    private HashMap<String, Integer> usedCommands;

    public Console() {
        this.comands = new HashMap<>();
        this.isExit = false;
        this.sc = new Scanner(System.in);
        this.rnd = new Random();
        System.out.print("Zadej svoje jmeno: ");
        this.player = new Player(sc.nextLine());
        this.bugisek = new Bugisek();
        this.usedCommands = new HashMap<>();
    }

    /**
     * adds commands to hashmaps
     */
    public void initialization() {
        comands.put("jdi", new Move(bugisek));
        comands.put("inventar", new Inventory());
        comands.put("seber", new Pick_up());
        comands.put("pouzij", new Use());
        comands.put("pomoc", new Help());
        comands.put("mluv", new Speak());
        comands.put("odpoved", new Answer());
        comands.put("mapa", new Map());

        usedCommands.put("jdi", 0);
        usedCommands.put("inventar", 0);
        usedCommands.put("seber", 0);
        usedCommands.put("pouzij", 0);
        usedCommands.put("pomoc", 0);
        usedCommands.put("mluv", 0);
        usedCommands.put("odpoved", 0);
        usedCommands.put("mapa", 0);
    }

    /**
     * console output and input command loader, input command analyzer
     */
    public void execute() {
        bugisek.move(datos);

        System.out.println("\n" + datos.getLocation(player.getCurrentLocationId()));
        System.out.println(bugisek);


        System.out.print(">> ");
        String inputCommand = sc.nextLine();
        String[] inputCommnads = inputCommand.split(" ");


        if (inputCommnads.length > 1) {
            if (comands.containsKey(inputCommnads[0])) {
                System.out.println(comands.get(inputCommnads[0]).execute(inputCommnads[1].toLowerCase(), player, datos));
                isExit = comands.get(inputCommnads[0]).isExit();

                userInputCheck(inputCommnads[1]);
                gameMechanics();
                usedCommands.replace(inputCommnads[0], usedCommands.get(inputCommnads[0]) + 1);
            } else {
                System.out.println("Tento prikaz neexistuje, tato hra podporuje tyto prikazy: " + comands.get("pomoc").execute("hrac", player, datos));
            }
        } else {
            System.out.println("Zadejte prikaz ve forme: prikaz + co/kam/kdo!\nTato hra podporuje tyto prikazy: " + comands.get("pomoc").execute("hrac", player, datos));
        }
    }

    /**
     * cycle loop, initial text and end game text output
     */
    public void start() {
        initialization();
        System.out.println("""
                To si tak hrajete svou oblíbenou počítačovou hru (vlastně jedinou hru, kterou máte nainstalovanou
                ehm… ehm... Linux), když vám přijde zajímavý email. Email otevřete a zjistíte, že máte unikátní příležitost
                na neuvěřitelný zážitek. Prý můžete prozkoumat svůj počítač zvláštním, byť jedinečným způsobem. Stačí pouze
                kliknout na odkaz a ihned můžete začít v prozkoumávání.
                
                Vy neodoláte a otevřete odkaz. V ten moment vás obrazovka vtáhne dovnitř a vy se ocitnete uvnitř svého počítače
                v nějakém komponentu, po chvílí rozhlížení usoudíte že je to nejspíš základní deska, kvůli tomu množství připojení
                všude možně. Chvílí se kocháte tím novým pohledem, procházíte křížem krážem je to vskutku úchvatné. Po nějaké době
                vám ale dojde, že nevíte, jak se dostat zpět.
                (Enter = dalsi text)
                """);
        sc.nextLine();
        System.out.println(comands.get("mapa").execute("mapa", player, datos));
        System.out.println("Pro zobrazeni vsech prikazu zadejte: pomoc <hrac>\nJako prvni doporucuji promluvit si se Zakladackem!");
        sc.nextLine();

        do {
            execute();
        } while (!isExit);

        System.out.println("""
                Povedlo se!!! Pocitac se zapnul, nabiha windows a ty se pres monitor skrz hdmi kabel vracis zpet do
                normalni sveta!
                
                                                    Dekuji za hrani me hry!!!
                
                """);
        System.out.println("Pouzite prikazy: " + usedCommandsText());
    }

    /**
     * this class converts electricity to information in chlazeni and electricity to information in ram and
     * if hdd inventory is full, player inventory size increases
     */
    public void gameMechanics() {
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

        if (datos.getLocation("hdd").isFull()) {
            player.setMaxInventorySize(4);
        }
    }

    /**
     * this class checks if user requested electricity to psu and
     * checks if user requested to turn on the computer and evaluates if it can do that
     *
     * @param input from user
     */
    public void userInputCheck(String input) {
        if (input.equals("2") && player.getCurrentTalkingNPC().equals("zakladacek")) {
            datos.getLocation("psu").addItem("elektrina");
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
                System.out.println("Zapnuti selhalo, tyto komponenty nemaji dostatek zdroju: " + notTurnedOn);
            }
        }
    }

    /**
     *
     * @return returns toString of usedCommands
     */
    public String usedCommandsText() {
        String text = "[";
        int i = 0;
        for (String s : usedCommands.keySet()) {
            i++;
            if (i == usedCommands.size()) {
                text += s + " " + usedCommands.get(s);
            } else {
                text += s + " " + usedCommands.get(s) + ", ";
            }
        }
        return text + "]";
    }
}
