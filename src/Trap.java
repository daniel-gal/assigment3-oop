public class Trap extends Enemy {
    int visibilityTime;
    int invisibilityTime;
    int ticksCount;
    boolean visibile;

    public Trap(char tile, String name, int healthCapacity, int attack, int defense, int expirience, int visibilityTime, int invisibilityTime) {
        super(tile, name, healthCapacity, attack, defense, expirience);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visibile = true;
    }

    public void processStep(){

    }


    public void onDeath(){

    }

}
