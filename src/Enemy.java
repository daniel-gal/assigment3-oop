public abstract class Enemy extends Unit{

    private int expirience;

    public Enemy(char tile, String name, int healthCapacity, int attack, int defense, int expirience) {
        super(tile, name, healthCapacity, attack, defense);
        this.expirience = expirience;
    }

    public void accept(Player p){//unit intrace method get enemy paremeter. now if this in unit was player so its we have player intracte with enemy.
        p.visit(this);
    }

    public void accept(Enemy e){//unit intrace method get enemy paremeter. now the this in unit was enemy so its its call visit in enemy cause its going intracte with enemy.
        e.visit(this);
    }


    public void visit(Player p){//enemy meet with player
        int attack = this.getAttack();
        p.getAttacked(attack);
    }
    public void visit(Enemy e){//enemy meet with enemy.
        return;
        //do nothing cause its enemy vs enemy.
    }







}
