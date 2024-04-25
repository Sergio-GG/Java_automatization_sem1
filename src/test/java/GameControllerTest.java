import org.example.controller.GameController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameControllerTest {
    @Test
    public void checkIfMontyHallParadox() throws InterruptedException {
        //given
        GameController gameController = new GameController();
        for (int i = 0; i < 100; i++){
            gameController.runGame();
        }
        //when
        int change = gameController.getChangeCounter();
        int notChange = gameController.getNotChangeCounter();
        //then
        Assertions.assertTrue(change > notChange);
    }
}
