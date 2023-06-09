import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Level {


    private HashMap<Position, Tile> gameboard;
    private Player player;
    private LinkedList<Monster> monsters;
    private LinkedList<Trap> traps;


    public Level(HashMap<Position,Tile> gameboard, Player player) {
        this.gameboard = gameboard;
        this.player = player;
    }

    public void LoadLevel(LinkedList<Tile> gameboard){

    }


    public void RunLevel(){
        while (finished() == 0){
            RunTick();
        }
        if(finished() == 1){
            //good job
        }
        else {
            //you died.
        }

    }

    public void RunTick(){
        Scanner scan = new Scanner(System.in);  // Create a Scanner object


        System.out.println("Input please");
        char input = scan.next().charAt(0);
        if(ProcessInput(input) != null)
            player.interact(ProcessInput(input));

        for (Monster m :monsters) {
            Tile tileTo = RandomMove(m);
            if(tileTo != null)
                m.interact(tileTo);
            if(m.isDead()) {
                monsters.remove(m);
                m.onDeath();
            }

        }
        for (Trap t :traps) {
            if(t.getPosition().compareTo(player.getPosition()) < 2)
                t.interact(player);
        }
    }

    public Tile RandomMove(Monster m){
        Random rand = new Random();
        int rnd = rand.nextInt(4);
        switch (rnd){
            case 0:
                return gameboard.get(new Position(m.getPosition().getX(), m.getPosition().getY() + 1));
            case 1:
                return gameboard.get(new Position(m.getPosition().getX(), m.getPosition().getY() - 1));
            case 2:
                return gameboard.get(new Position(m.getPosition().getX() - 1, m.getPosition().getY()));
            case 3:
                return gameboard.get(new Position(m.getPosition().getX() + 1, m.getPosition().getY() ));
        }
        return null;
    }
    public Tile ProcessInput(char c){
        switch (c){
            case 'w':
                return gameboard.get(new Position(player.getPosition().getX(), player.getPosition().getY() + 1));
            case 's':
                return gameboard.get(new Position(player.getPosition().getX(), player.getPosition().getY() - 1));
            case 'a':
                return gameboard.get(new Position(player.getPosition().getX() - 1, player.getPosition().getY()));
            case 'd':
                return gameboard.get(new Position(player.getPosition().getX() + 1, player.getPosition().getY() ));
            case 'e':
                //Special ability.
            case 'q':
                return null; //do nothing.

        }
        return null;
    }
    public int finished(){
        if(player.isDead())
            return -1;
        if(monsters.size() <= 0)
            return 1;
        return 0;
    }
    public HashMap<Position, Tile> getGameboard() {
        return gameboard;
    }

    public void setGameboard(HashMap<Position,Tile> gameboard) {
        this.gameboard = gameboard;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
