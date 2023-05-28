public abstract class Player extends Unit {
    Integer experience;
    Integer level;



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

    public void levelUp(){
        if(this.experience == this.level*50){
            this.experience = this.experience - (50*level);
            level = level +1;
            setHealthCap(this.getHealthCap()+(10*level));
            setCurrentHealth(this.getHealthCap());
            this.setAttack(this.getAttack()+(4*this.level));
            this.setDefense(this.getDefense()+this.level);

        }


    }
    public abstract int castAbility();


    public void onDeath(){
        System.out.println("game over");
    }



}
