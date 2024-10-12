public class Main {
    public static void main(String[] args) {
        // Créer des ressources
        Resources player1Resources = new Resources();
        Resources player2Resources = new Resources();

        // Créer des joueurs
        Player player1 = new Player("1", "Alice", new Faction("Knights"));
        Player player2 = new Player("2", "Bob", new Faction("Wizards"));

        // Créer une carte et générer des territoires
        Map gameMap = new Map();
        gameMap.generateMap();

        // Créer des territoires et les conquérir
        Territory plains = new Territory("Plains", "Grassland", new Resources());
        plains.conquer(player1);

        Territory forest = new Territory("Forest", "Woodland", new Resources());
        forest.conquer(player2);

        // Construire des villes
        City city1 = new City("Fortress", player1);
        City city2 = new City("Castle", player2);

        // Construire des bâtiments
        Building barracks = new Building("Barracks", 0, 2);
        city1.build(barracks);

        Building farm = new Building("Farm", 3, 0);
        city2.build(farm);

        // Produire des unités
        city1.produceUnit("Infantry");
        city2.produceUnit("Archers");

        // Créer des unités
        Unit archer = new Archer(player1);
        Unit knight = new Knight(player1);
        archer.attack(knight);

        // Créer des bâtiments
        Building farm = new Farm();
        Building wall = new Wall();

        farm.produce();
        wall.produce();

        // Échanger des ressources
        player1.trade(player2);

        // Passer au tour suivant
        Game game = new Game();
        game.startGame();
        game.nextTurn();
        game.endGame();
    }
}
