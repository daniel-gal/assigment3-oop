import java.util.LinkedList;

public abstract class Player extends Unit {
    Integer experience;
    Integer level;

    private int abillityRange;



    public Player(char tile,String name,int healthCap,int currentHealth,int attack,int defense,int experience,int level){
        super(tile, name, healthCap, attack, defense);
        this.experience = experience;
        this.level = level;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void levelUp() {
        this.experience = Math.max(this.experience - (50 * level),0);
        level = level + 1;
        this.getHealth().setHealthCap(getHealth().getHealthCap() + (10 * level));
        this.getHealth().setCurrentHealth(getHealth().getHealthCap());
        this.setAttack(this.getAttack() + (4 * this.level));
        this.setDefense(this.getDefense() + this.level);
    }

    public void accept(Unit u){
        u.visit(this);
    }
    public void accept(Enemy e){//parameter in unit was player now if this paremet was enemy so player going intract with enemy.
        e.visit(this);
        //player going to intract with enemy.

    }
    public void accept(Player p){//parameter in unit was player now if this parmeter was player so player going intract with player.
        p.visit(this);
        //player going to intracte player.

    }

    public void visit(Enemy e){//fight
        MassageCallback.send(this.getName() + " has initiated combat with " + e.getName());
        int attack =this.getAttack();
        e.getAttacked(attack);
        if(e.getHealth().isDead()){
            Position temp = e.getPosition();
            e.setPosition(this.getPosition());
            this.setPosition(temp);
            this.experience += e.getExpirience();
        }

    }
    public void visit(Player p){//nothing happen
        return;
    //happen nothing
    }

    public abstract int castAbility(LinkedList<Enemy> enemies);


    public int getAbillityRange() {
        return abillityRange;
    }

    public void setAbillityRange(int abillityRange) {
        this.abillityRange = abillityRange;
    }

    public void onDeath(){
        MassageCallback.send("Game over");
    }

    public abstract void processStep();


}
