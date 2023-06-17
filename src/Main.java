import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GameFlow game = new GameFlow();
        game.insertLevel("C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level1.txt");
        game.insertLevel("C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level2.txt");
        game.insertLevel("C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level3.txt");
        game.insertLevel("C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level4.txt");
        game.RunGame();
    }

}