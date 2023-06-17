import java.util.LinkedList;
import java.util.Random;

public class Warrior extends Player{

        private int abilityCoolDown;
        private  int remainingCoolDown;


    public Warrior(char tile,String name,int healthCap,int currentHealth,int attack,int defense,int experience,int level,int abilityCoolDown){
        super(tile,name,healthCap,currentHealth,attack,defense,experience,level);
        this.abilityCoolDown=abilityCoolDown;
        this.remainingCoolDown = 0;
        this.setAbillityRange(3);
    }


    public void processStep(){
        if(remainingCoolDown > 0)
            remainingCoolDown--;
        if(experience >= 50 * level)
            warriorLevelUp();
    }

    public int getAbilityCoolDown() {
        return abilityCoolDown;
    }

    public void setAbilityCoolDown(int abilityCoolDown) {
        this.abilityCoolDown = abilityCoolDown;
    }

    public int getRemainingCoolDown() {
        return remainingCoolDown;
    }

    public void setRemainingCoolDown(int remainingCoolDown) {
        this.remainingCoolDown = remainingCoolDown;
    }


    public void warriorLevelUp(){
        this.levelUp();
        this.remainingCoolDown = 0;
        this.getHealth().setHealthCap(this.getHealth().getHealthCap()+(5*this.level));
        this.getHealth().setCurrentHealth(getHealth().getHealthCap());
        this.setAttack(this.getAttack()+(2*this.level));
        this.setDefense(this.getDefense()+this.level);
        MassageCallback.send("You've leveled up!!! new stats - " + describe());
    }




    @Override
    public int castAbility(LinkedList<Enemy> enemies) {
        if(remainingCoolDown == 0) {
            remainingCoolDown = abilityCoolDown;
            getHealth().setCurrentHealth(Math.min(getHealth().getCurrentHealth() + 10 * getDefense(), getHealth().getHealthCap()));
            Random rand = new Random();
            int rnd = rand.nextInt(enemies.size());
            if(enemies.size() != 0)
                enemies.get(rnd).getAttacked((int)Math.floor(getHealth().getCurrentHealth() * 0.1));
        }
        return 0;
    }

    @Override
    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d \t\tLevel: %d \t\tExperience: %d \t\tCD: %d", getName(), getHealth().getCurrentHealth(), getAttack(), getDefense(), getLevel(), getExperience(), getRemainingCoolDown());
    }


}
