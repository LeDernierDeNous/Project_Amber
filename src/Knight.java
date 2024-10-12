public class Knight extends Unit {
    public Knight(Player owner) {
        super("Knight", 10, 5, owner);
    }

    @Override
    public void attack(Unit target) {
        int damage = Math.max(0, attackPower - target.getDefensePower());
        target.defend(damage);
        System.out.println(owner.getName() + " attacks " + target.getOwner().getName() + " with a Knight, dealing " + damage + " damage.");
    }

    @Override
    public void defend(int damage) {
        System.out.println("Knight defends against " + damage + " damage.");
    }
}
