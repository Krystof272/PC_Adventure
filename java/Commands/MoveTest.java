package Commands;

import Characters.Bugisek;
import Characters.Player;
import Game.GameData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    Move move;
    Player player;
    GameData datos;


    @org.junit.jupiter.api.BeforeEach
    void init() {
        move = new Move(new Bugisek());
        player = new Player("krystof");
        datos = GameData.loadGameDataFromResources("/gameData.json");
    }

    @Test
    void execute() {
        assertEquals("Tento komponent rozhoduje o chodu celeho pocitace. (Cpu)", move.execute("sever", player, datos));
    }
}