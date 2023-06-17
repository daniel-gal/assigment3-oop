public class TestGame {


    public static void Play() {
        GameFlow game = new GameFlow();
        game.insertLevel("C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level1.txt");
        game.insertLevel("C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level2.txt");
        game.insertLevel("C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level3.txt");
        game.insertLevel("C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level4.txt");
        game.RunGame();
    }
}
