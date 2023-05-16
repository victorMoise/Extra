package boxing;

public class Fighter {
    private final String name;
    private int health;
    private final int damagePerAttack;

    public Fighter(String name, int health, int damage) {
        this.name = name;
        setHealth(health);
        this.damagePerAttack = damage;
    }

    private void setHealth(int health) {
        if (health > 0) {
            this.health = health;
        }
        else {
            this.health = 100;
        }
    }

    public void attack(Fighter fighter) {
        fighter.health = fighter.health - this.damagePerAttack;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
