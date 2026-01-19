public class Main {
    public static void main(String[] args) {
        //Tohle bude fajn schovat do nějaké třídy, ve které budeme pracovat se všemi daty a hráčem
        GameData datos = GameData.loadGameDataFromResources("/gameData.json");

        System.out.println(datos);
    }
}