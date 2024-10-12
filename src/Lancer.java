public class Lancer extends Unit {
    public Lancer(Player owner) {
        super("Lancer", 7, 3, owner);
    }

    @Override
    public void attack(Unit target) {
        int damage = Math.max(0, attackPower - target.getDefensePower());
        target.defend(damage);
        System.out.println(owner.getName() + " attacks " + target.getOwner().getName() + " with a Lancer, dealing " + damage + " damage.");
    }

    @Override
    public void defend(int damage) {
        System.out.println("Lancer defends against " + damage + " damage.");
    }
}
