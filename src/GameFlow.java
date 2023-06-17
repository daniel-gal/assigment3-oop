import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GameFlow {

    private Player player;

    private LinkedList<String> levelPaths;
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameFlow() {
        MassageCallback.send("Pick you player - 1 for John snow, 2 for The Hound, 3 for Melisandre, 4 for Thoros of Myr, 5 for Arya Stark, 6 Bronn ");
        Scanner scan = new Scanner(System.in);
        char input = scan.next().charAt(0);
        this.player = null;
        this.player = choosePlayer(input);
        while (player == null){
            MassageCallback.send("Bad input, please choose again");
            MassageCallback.send("Pick you player - 1 for John snow, 2 for The Hound, 3 for Melisandre, 4 for Thoros of Myr, 5 for Arya Stark, 6 Bronn ");
            input = scan.next().charAt(0);
            this.player = choosePlayer(input);
        }

        levelPaths = new LinkedList<String>();
    }

    public Player choosePlayer(char c){
        switch (c){
            case '1':
                return new Warrior('@',"John Snow",300,300,30,4,0,1,3);
            case '2':
                return new Warrior('@',"The Hound",400,400,20,6,0,1,5);
            case '3':
                return new Mage('@',"Malisandre",100,100,5,1,0,1,300,300,30,15,5,6);
            case '4':
                return new Mage('@', "Thoros of Myr",250,250,25,4,0,1,150,150,20,20,3,4);
            case '5':
                return new Rogue('@', "Arya Stark",150,150,40,2,0,1,20,100);
            case '6':
                return new Rogue('@', "Bronn",250,250,35,3,0,1,50,100);
            default:
                return null;
        }
    }
    public void RunGame(){
        int count = 1;
        Iterator<String> iterLevel = levelPaths.iterator();
        while (!player.isDead() && iterLevel.hasNext()){
            System.out.println("level number " + count);
            LoadLevel(iterLevel.next()).RunLevel();
        }
        if(!player.isDead())
            MassageCallback.send("Congratulations! you won!");
    }
    public Level LoadLevel(String pathString){

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
            case 'b':
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

    public void insertLevel(String path){
        levelPaths.add(path);
    }




}
