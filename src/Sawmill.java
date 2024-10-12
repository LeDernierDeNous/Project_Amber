public class Sawmill extends Building {
    public Sawmill() {
        super("Sawmill", 2, 0);
    }

    @Override
    public void produce() {
        System.out.println("Producing " + productionRate + " wood from Sawmill.");
    }
}