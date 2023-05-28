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
