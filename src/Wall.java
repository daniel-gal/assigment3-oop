import java.security.PublicKey;

public class Wall extends Tile{

    public Wall(){super('#');}

    public void accept(Unit u){
        //Nothing happens, the turn goes to waste for this unit.
    }
}
