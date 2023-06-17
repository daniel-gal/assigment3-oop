public class Mage extends Player{
    private Integer manaPool;
    private Integer currentMana;
    private Integer manaCost;
    private Integer spellPower;
    private Integer hitsCount;
    private Integer abilityRange;



    public Mage(char tile,String name,int healthCap,int currentHealth,int attack,int defense,int experience,int level,int manaPool,int currentMana,int manaCost,int spellPower,int hitsCount,int abilityRange){
        super(tile,name,healthCap,currentHealth,attack,defense,experience,level);
        this.manaPool = manaPool;
        this.currentMana = currentMana;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;


    }

    public void mageLevelUp(){
        this.levelUp();
        this.manaPool = this.manaPool+(25*this.level);
        this.currentMana = Math.min((this.currentMana+this.manaPool/4),this.manaPool);
        this.spellPower = spellPower+(10*this.level);
    }

    public Integer getCurrentMana() {
        return currentMana;
    }

    public Integer getSpellPower() {
        return spellPower;
    }

    @Override
    public int castAbility() {
        return 0;
    }

    @Override
    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d \t\tLevel: %d \t\tExperience: %d \t\tCurrent Mana: %d \t\tSpell Power: %d ", getName(), getHealth().getCurrentHealth(), getAttack(), getDefense(), getLevel(), getExperience(), getCurrentMana(), getSpellPower());
    }


}
