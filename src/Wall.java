public class Wall extends Building {
    public Wall() {
        super("Wall", 0, 5);
    }

    @Override
    public void produce() {
        System.out.println("Wall provides defense bonus of " + defenseBonus + ".");
    }
}
