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
        this.setHealthCap(this.getHealthCap()+(5*this.level));
        this.setAttack(this.getAttack()+(2*this.level));
        this.setDefense(this.getDefense()+this.level);
    }




    @Override
    public int castAbility() {//need to understand how i check distance and choose randomaly monster to attack.
        return 0;
    }

    @Override
    public void accept(Unit unit) {

    }

    @Override
    public void processStep() {

    }
}
