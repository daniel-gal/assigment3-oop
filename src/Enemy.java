public abstract class Enemy extends Unit{

    private int expirience;

    public Enemy(char tile, String name, int healthCapacity, int attack, int defense, int expirience) {
        super(tile, name, healthCapacity, attack, defense);
        this.expirience = expirience;
    }
}
