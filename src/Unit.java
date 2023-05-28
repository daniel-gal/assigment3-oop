import java.util.Observable;
import java.util.Random;

public abstract class Unit extends Tile {

    private String name;
    private int healthCap;
    private int currentHealth;
    private int attack;
    private int defense;

    protected Unit(char tile, String name, int healthCapacity, int attack, int defense) {
        super(tile);
        this.name = name;
        this.healthCap = healthCapacity;
        this.attack = attack;
        this.defense = defense;
    }

    protected void initialize(Position position){
        this.setPosition(position);
    }
	
    protected int attack(){

        return (int)Math.floor(this.attack * Math.random());
    }

    public int defend(){
        return (int)Math.floor(this.defense * Math.random());
    }

	// Should be automatically called once the unit finishes its turn
    public abstract void processStep();
	
	// What happens when the unit dies
    public abstract void onDeath();

	// This unit attempts to interact with another tile.
    public void interact(Tile tile){

    }

    /*
    public void visit(Empty e){

    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);

    */
	// Combat against another unit.
    protected boolean battle(Unit u){
        int att;
        int def;
        while (u.getCurrentHealth() > 0 && this.currentHealth > 0){
            att = this.attack();
            def = u.defend();
            if(att - def > 0)
                u.setCurrentHealth(u.getCurrentHealth() - (att - def));
            if(u.getCurrentHealth() <= 0){
                u.onDeath();
                return true;
            }
            att = u.attack();
            def = this.defend();
            if(att - def > 0)
                this.setCurrentHealth(this.getCurrentHealth() - (att - def));

        }
        this.onDeath();
        return false;
    }


    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getCurrentHealth(), getAttack(), getDefense());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthCap() {
        return healthCap;
    }

    public void setHealthCap(int healthCap) {
        this.healthCap = healthCap;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
