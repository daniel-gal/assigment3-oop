import java.util.LinkedList;

public class Rogue extends Player {

    private int cost;
    private int currentEnergy;


    public Rogue(char tile,String name,int healthCap,int currentHealth,int attack,int defense,int experience,int level,int cost,int currentEnergy){
        super(tile,name,healthCap,currentHealth,attack,defense,experience,level);
        this.cost = cost;
        this.currentEnergy = currentEnergy;
        this.setAbillityRange(2);
    }



    public void rougeLevelUp(){
        this.levelUp();
        this.currentEnergy=100;
        this.setAttack(this.getAttack()+(3*this.level));
        MassageCallback.send("You've leveled up!!! new stats - " + describe());
    }

    @Override
    public int castAbility(LinkedList<Enemy> enemies) {

        if(currentEnergy >= cost) {
            for (Enemy e : enemies) {
                e.getAttacked(this.getAttack());
            }
            currentEnergy = Math.max(currentEnergy - cost, 0);
        }


        return 0;
    }

    @Override
    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d \t\tLevel: %d \t\tExperience: %d \t\tEnergy: %d", getName(), getHealth().getCurrentHealth(), getAttack(), getDefense(), getLevel(), getExperience(), getCurrentEnergy());
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void processStep(){
        currentEnergy = Math.min(100, currentEnergy + 10);
        if(experience >= 50 * level)
            rougeLevelUp();
    }
}
