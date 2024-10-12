public class Farm extends Building {
    public Farm() {
        super("Farm", 3, 0);
    }

    @Override
    public void produce() {
        System.out.println("Producing " + productionRate + " food from Farm.");
    }
}
