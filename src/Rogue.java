public class Rogue extends Player {

    private int cost;
    private int currentEnergy;


    public Rogue(char tile,String name,int healthCap,int currentHealth,int attack,int defense,int experience,int level,int cost,int currentEnergy){
        super(tile,name,healthCap,currentHealth,attack,defense,experience,level);
        this.cost = cost;
        this.currentEnergy = currentEnergy;
    }



    public void rougeLevelUp(){
        this.levelUp();
        this.currentEnergy=100;
        this.setAttack(this.getAttack()+(3*this.level));
    }




















    @Override
    public int castAbility() {
        return 0;
    }

    @Override
    public void accept(Unit unit) {

    }

    @Override
    public void processStep() {

    }
}
