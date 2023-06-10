public class Monster extends Enemy{

    private int visionRange;

    public Monster(char tile, String name, int healthCapacity, int attack, int defense, int expirience, int visionRange) {
        super(tile, name, healthCapacity, attack, defense, expirience);
        this.visionRange = visionRange;
    }

    public void processStep(){

    }

    public void onDeath(){

    }



}
