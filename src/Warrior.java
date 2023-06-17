public class Warrior extends Player{

        private int abilityCoolDown;
        private  int remainingCoolDown;


    public Warrior(char tile,String name,int healthCap,int currentHealth,int attack,int defense,int experience,int level,int abilityCoolDown){
        super(tile,name,healthCap,currentHealth,attack,defense,experience,level);
        this.abilityCoolDown=abilityCoolDown;
        this.remainingCoolDown = 0;
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
    }




    @Override
    public int castAbility() {//need to understand how i check distance and choose randomaly monster to attack.
        return 0;
    }

    @Override
    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d \t\tLevel: %d \t\tExperience: %d \t\tCD: %d", getName(), getHealth().getCurrentHealth(), getAttack(), getDefense(), getLevel(), getExperience(), getRemainingCoolDown());
    }


}
