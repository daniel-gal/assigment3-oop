public abstract class Enemy extends Unit{

    private int expirience;

    public Enemy(char tile, String name, int healthCapacity, int attack, int defense, int expirience) {
        super(tile, name, healthCapacity, attack, defense);
        this.expirience = expirience;
    }

    public void accept(Player p){
        this.getAttacked(p.attack());
    }

    public void accept(Enemy e){
        return;
        //nothing happens, turn goes to waste.
    }

    public void accept(Tile t){

    }




}
