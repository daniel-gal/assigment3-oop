import java.util.LinkedList;
import java.util.Random;

public class Mage extends Player{
    private Integer manaPool;
    private Integer currentMana;
    private Integer manaCost;
    private Integer spellPower;
    private Integer hitsCount;



    public Mage(char tile,String name,int healthCap,int currentHealth,int attack,int defense,int experience,int level,int manaPool,int currentMana,int manaCost,int spellPower,int hitsCount,int abilityRange){
        super(tile,name,healthCap,currentHealth,attack,defense,experience,level);
        this.manaPool = manaPool;
        this.currentMana = currentMana;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.setAbillityRange(abilityRange);
    }

    public void mageLevelUp(){
        this.levelUp();
        this.manaPool = this.manaPool+(25*this.level);
        this.currentMana = Math.min((this.currentMana+this.manaPool/4),this.manaPool);
        this.spellPower = spellPower+(10*this.level);
        MassageCallback.send("You've leveled up!!! new stats - " + describe());
    }

    public Integer getCurrentMana() {
        return currentMana;
    }

    public Integer getSpellPower() {
        return spellPower;
    }

    @Override
    public int castAbility(LinkedList<Enemy> enemies) {
        if(currentMana >= manaCost){
            currentMana -= manaCost;
            int hits = 0;
            if(enemies.size() != 0) {
                while (hits < hitsCount) {
                    Random rand = new Random();
                    int rnd = rand.nextInt(enemies.size());
                    enemies.get(rnd).getAttacked(spellPower);
                    hits++;
                }
            }
        }
        return 0;
    }

    public void processStep(){
        currentMana = Math.min(manaPool, currentMana + level);
        if(experience >= 50 * level)
            mageLevelUp();
    }
    @Override
    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d \t\tLevel: %d \t\tExperience: %d \t\tCurrent Mana: %d \t\tSpell Power: %d ", getName(), getHealth().getCurrentHealth(), getAttack(), getDefense(), getLevel(), getExperience(), getCurrentMana(), getSpellPower());
    }


}
