public class Castle extends Building {
    public Castle() {
        super("Castle", 5, 10);
    }

    @Override
    public void produce() {
        System.out.println("Castle produces " + productionRate + " resources and provides a defense bonus of " + defenseBonus + ".");
    }
}
