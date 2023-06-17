import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFlow {

    private Player player;

    private LinkedList<Level> levels;
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameFlow() {
        this.player = player;
        levels = new LinkedList<Level>();
    }

    public void RunGame(){
        int count = 1;
        Iterator<Level> iterLevel = levels.iterator();
        while (!player.isDead() && iterLevel.hasNext()){
            System.out.println("level number " + count);
            iterLevel.next().RunLevel();
        }

        if(player.isDead()){
            //You suck
        }
        else {
            //You won, you probably have a dick bigger than barami's.
        }
    }
    public Level LoadLevel(){

        String pathString = "C:\\Users\\Menashe\\Desktop\\Degree\\Sem B\\Oop\\hw3 git\\levels_dir\\levels_dir\\level1.txt";
        Path path = Path.of(pathString);
        String value = "";
        try {
            value = Files.readString(path);
        }
        catch (Exception e){
            System.out.println("exception in reading file");
        }

        HashMap<Position, Tile> level = new HashMap<Position,Tile>();
        LinkedList<Monster> monsters = new LinkedList<Monster>();
        LinkedList<Trap> traps = new LinkedList<Trap>();
        String[] heights = value.split("\n");
        for(int y =0; y < heights.length; y++){
            heights[y] = heights[y].replace("\r","");
            for(int x = 0; x < heights[y].length(); x++){
                char c = heights[y].charAt(x);
                System.out.println(x + "" + y +"" + c);
                Tile t = processChar(c, monsters,traps);
                t.initialize(new Position(x,y));
                level.put(t.getPosition(), t);

            }
        }

        return new Level(level,player,monsters,traps);
    }


    public Tile processChar(char c, LinkedList<Monster> monsters, LinkedList<Trap> traps){
        switch (c){
            case '.':
                return new Empty();
            case '#':
                return new Wall();
            case '@':
                return player;
            case 'B':
                Trap trapB = new Trap('B',"Bonus Trap",1,1,1,250,1,5);
                traps.add(trapB);
                return trapB;
            case 'Q':
                Trap trapQ = new Trap('Q',"Queen's Trap",250,50,10,100,3,7);
                traps.add(trapQ);
                return trapQ;
            case 'D':
                Trap trapD = new Trap('D',"Dead Trap",500,100,20,250,1,10);
                traps.add(trapD);
                return trapD;
            default:
                Monster monster = createMonster(c);
                monsters.add(monster);
                return monster;
        }
    }



    public Monster createMonster(char e){
        switch (e){
            case 's':
                return new Monster('s',"Lannister Soldier",80,8,3,25,3);
            case 'k':
                return new Monster('k',"Lannister Knight",200,14,8,50,4);
            case 'q':
                return new Monster('q',"Queen Guard",400,20,15,100,5);
            case 'z':
                return new Monster('w',"Wright",600,30,15,100,3);
            case 'p':
                return new Monster('p',"Bear-Wright",1000,75,30,250,4);
            case 'g':
                return new Monster('g',"Giant-Wright",1500,100,40,500,5);
            case 'w':
                return new Monster('w',"White-Walker",2000,150,50,1000,6);
            case 'M':
                return new Monster('M',"The Mountain",1000,60,25,500,6);
            case 'C':
                return new Monster('C',"Queen Cersei",100,10,10,1000,1);
            case 'K':
                return new Monster('K',"Night's King",5000,300,150,5000,8);
        }
        return null;
    }

    public void testLevel(){
        levels.add(LoadLevel());
    }



}
