public abstract class Building {
    protected String type;
    protected int productionRate;
    protected int defenseBonus;

    public Building(String type, int productionRate, int defenseBonus) {
        this.type = type;
        this.productionRate = productionRate;
        this.defenseBonus = defenseBonus;
    }

    public abstract void produce();

    public String getType() {
        return type;
    }

    public int getProductionRate() {
        return productionRate;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }
}
