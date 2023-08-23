class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Player {
    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Weapon gunOne = new Weapon("Gun One", 30);
        Weapon gunTwo = new Weapon("Gun Two", 50);

        Player hero = new Player("Hero", 100, gunOne);
        Player villain = new Player("Villain", 100, gunTwo);

        System.out.println("The battle begins: " + hero + " vs " + villain);
        System.out.println(hero + " has chosen " + hero.getWeapon());
        System.out.println(villain + " has chosen " + villain.getWeapon());

        int heroDamage = hero.getWeapon().getDamage();
        int villainDamage = villain.getWeapon().getDamage() - 10;

        hero.takeDamage(villainDamage);
        villain.takeDamage(heroDamage);

        System.out.println(hero + " takes " + villainDamage + " damage.");
        System.out.println(villain + " takes " + heroDamage + " damage.");

        System.out.println(hero + " health: " + hero.getHealth());
        System.out.println(villain + " health: " + villain.getHealth());

        System.out.println("Battle result:");
        if (hero.getHealth() > villain.getHealth()) {
            System.out.println(hero + " wins!");
        } else if (villain.getHealth() > hero.getHealth()) {
            System.out.println(villain + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
