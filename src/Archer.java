public class Archer extends Unit {
    public Archer(Player owner) {
        super("Archer", 5, 2, owner);
    }

    @Override
    public void attack(Unit target) {
        int damage = Math.max(0, attackPower - target.getDefensePower());
        target.defend(damage);
        System.out.println(owner.getName() + " attacks " + target.getOwner().getName() + " with an Archer, dealing " + damage + " damage.");
    }

    @Override
    public void defend(int damage) {
        System.out.println("Archer defends against " + damage + " damage.");
    }
}

