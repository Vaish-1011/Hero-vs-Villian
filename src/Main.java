public class Main {
    public static void main(String[] args) {
        Weapon gunOne = new Weapon("gunOne", 30);
        Weapon gunTwo = new Weapon("gunTwo", 50);

        Player hero = new Player("src.Hero", gunOne);
        Player villain = new Player("src.Villain", gunTwo);

        System.out.println("The battle begins!");

        villain.equipArmor();

        int heroDamage = hero.weapon.getDamage();
        villain.takeDamage(heroDamage);

        int villainDamage = villain.weapon.getDamage();
        hero.takeDamage(villainDamage);

        System.out.println("The battle is over!");
    }
}

class Weapon {
    String name;
    int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}

class Player {
    String name;
    Weapon weapon;
    boolean hasArmor;

    public Player(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
        this.hasArmor = false;
    }

    public void equipArmor() {
        this.hasArmor = true;
    }

    public void takeDamage(int damage) {
        if (hasArmor) {
            System.out.println(name + " is wearing armor, so the damage is reduced.");
            damage -= 10;
            if (damage < 0) {
                damage = 0;
            }
        }

        System.out.println(name + " takes " + damage + " damage.");
    }
}