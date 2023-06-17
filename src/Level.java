import javax.swing.*;
import java.util.*;

public class Level {


    private HashMap<Position, Tile> gameboard;
    private Player player;
    private LinkedList<Monster> monsters;
    private LinkedList<Trap> traps;

    public Level(HashMap<Position,Tile> gameboard, Player player, LinkedList<Monster> monsters, LinkedList<Trap> traps) {
        this.gameboard = gameboard;
        this.player = player;
        this.monsters = monsters;
        this.traps = traps;
    }




    public void RunLevel(){
        System.out.println(currentBoardString());
        while (finished() == 0){
            RunTick();
            System.out.println(currentBoardString());
        }
    }

    public void RunTick(){
        Scanner scan = new Scanner(System.in);  // Create a Scanner object


        System.out.println("Input please");
        char input = scan.next().charAt(0);
        if(ProcessInput(input) != null) {
            Position prePosPlayer = new Position(player.getPosition().getX(), player.getPosition().getY());
            Tile tileTo = ProcessInput(input);
            Position prePosTile = new Position(tileTo.getPosition().getX(), tileTo.getPosition().getY());

            player.interact(tileTo);

            updateInteraction(prePosPlayer, prePosTile, player, tileTo);

            Iterator<Monster> monsterIterator = monsters.iterator();
            while (monsterIterator.hasNext()){
                Monster m = monsterIterator.next();
                if(m.isDead()) {
                    gameboard.remove(m.getPosition());
                    monsterIterator.remove();

                    Empty e = new Empty();
                    e.initialize(new Position(m.getPosition().getX(), m.getPosition().getY()));
                    gameboard.put(e.getPosition(), e);

                    m.onDeath();
                }
            }
        }

        for (Monster m :monsters) {

            if(m.compareTo(player) <= m.getVisionRange())
                chasePlayer(m);

            else{
                Tile tileTo = RandomMove(m);
                if(tileTo != null) {
                    Position prePosMonster = new Position(m.getPosition().getX(), m.getPosition().getY());
                    Position prePosTile = new Position(tileTo.getPosition().getX(), tileTo.getPosition().getY());
                    m.interact(tileTo);
                    updateInteraction(prePosMonster, prePosTile, m, tileTo);

                }
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
                return gameboard.get(new Position(player.getPosition().getX(), player.getPosition().getY() - 1));
            case 's':
                return gameboard.get(new Position(player.getPosition().getX(), player.getPosition().getY() + 1));
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

    public String currentBoardString(){
        String result = "";
        int y = 0;
        int x = 0;
        while (gameboard.get(new Position(x,y)) != null){
            while (gameboard.get(new Position(x,y)) != null){
                result = result + gameboard.get(new Position(x,y)).toString();
                x++;
            }
            result += "\n";
            y++;
            x = 0;
        }
        return result;
    }

    public void chasePlayer(Monster m){
        int dx = m.getPosition().getX() - player.getPosition().getX();
        int dy = m.getPosition().getY() - player.getPosition().getY();
        if(Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) {
                Tile t = gameboard.get(new Position(m.getPosition().getX() - 1, m.getPosition().getY()));
                Position prePosT = t.getPosition();
                Position prePosM = m.getPosition();
                m.interact(t);
                updateInteraction(prePosM, prePosT, m, t);
            }
            else{
                Tile t = gameboard.get(new Position(m.getPosition().getX() + 1, m.getPosition().getY()));
                Position prePosT = t.getPosition();
                Position prePosM = m.getPosition();
                m.interact(t);
                updateInteraction(prePosM, prePosT, m, t);
            }

        }
        else{
            if (dy > 0){
                Tile t = gameboard.get(new Position(m.getPosition().getX() , m.getPosition().getY() - 1));
                Position prePosT = t.getPosition();
                Position prePosM = m.getPosition();
                m.interact(t);
                updateInteraction(prePosM, prePosT, m, t);
            }
            else{
                Tile t = gameboard.get(new Position(m.getPosition().getX(), m.getPosition().getY() + 1));
                Position prePosT = t.getPosition();
                Position prePosM = m.getPosition();
                m.interact(t);
                updateInteraction(prePosM, prePosT, m, t);
            }
        }
    }

    public void updateInteraction(Position preT1, Position preT2, Tile t1, Tile t2){
        gameboard.remove(preT1);
        gameboard.remove(preT2);
        gameboard.put(t1.getPosition(), t1);
        gameboard.put(t2.getPosition(), t2);
    }
}
