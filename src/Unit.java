public abstract class Unit {
    protected String type;
    protected int attackPower;
    protected int defensePower;
    protected Player owner;

    public Unit(String type, int attackPower, int defensePower, Player owner) {
        this.type = type;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.owner = owner;
    }

    public abstract void attack(Unit target);
    public abstract void defend(int damage);

    public String getType() {
        return type;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public Player getOwner() {
        return owner;
    }
}
