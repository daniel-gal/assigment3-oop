public class Health {
    private int healthCap;
    private int currentHealth;

    public Health(int healthCap) {
        this.healthCap = healthCap;
        this.currentHealth = healthCap;
    }

    public void getDamaged(int damage){
        currentHealth -= damage;
    }

    public boolean isDead(){
        return currentHealth <= 0;
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
}
