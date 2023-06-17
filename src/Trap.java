public class Trap extends Enemy {
    int visibilityTime;
    int invisibilityTime;
    int ticksCount;
    boolean visibile;

    char originalTile;

    public Trap(char tile, String name, int healthCapacity, int attack, int defense, int expirience, int visibilityTime, int invisibilityTime) {
        super(tile, name, healthCapacity, attack, defense, expirience);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visibile = true;
        this.originalTile = tile;
    }

    public int getTicksCount() {
        return ticksCount;
    }

    public void setTicksCount(int ticksCount) {
        this.ticksCount = ticksCount;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void IncrementTick(){
        ticksCount++;
        if(visibile && ticksCount == visibilityTime){
            visibile = false;
            ticksCount = 0;
            this.setTile('.');
        }

        if(!visibile && ticksCount == invisibilityTime){
            visibile = true;
            ticksCount = 0;
            this.setTile(originalTile);
        }
    }
    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }
}
