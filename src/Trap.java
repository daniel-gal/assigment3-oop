public class Trap extends Enemy {
    int visibilityTime;
    int invisibilityTime;
    int ticksCount;
    boolean visibile;

    public Trap(char tile, String name, int healthCapacity, int attack, int defense, int expirience, int visibilityTime, int invisibilityTime, int ticksCount, boolean visibile) {
        super(tile, name, healthCapacity, attack, defense, expirience);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = ticksCount;
        this.visibile = visibile;
    }

    public void processStep(){

    }

    public void onDeath(){

    }

    public void accept(Unit u){

    }
}