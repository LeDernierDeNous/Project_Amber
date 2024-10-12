public class Mine extends Building {
    public Mine() {
        super("Mine", 2, 0);
    }

    @Override
    public void produce() {
        System.out.println("Producing " + productionRate + " minerals from Mine.");
    }
}
