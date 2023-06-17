import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GameFlow game = new GameFlow();
        game.setPlayer(new Warrior('@',"Daniel The Beast",4000,4000,100,100,30,1,5));
        game.testLevel();
        game.RunGame();
    }

}