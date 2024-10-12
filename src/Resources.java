public class Resources {
    private int wheat;
    private int wood;
    private int minerals;
    private int gold;

    public Resources() {
        this.wheat = 0;
        this.wood = 0;
        this.minerals = 0;
        this.gold = 0;
    }

    public void addResource(String resource, int amount) {
        switch (resource.toLowerCase()) {
            case "wheat":
                wheat += amount;
                break;
            case "wood":
                wood += amount;
                break;
            case "minerals":
                minerals += amount;
                break;
            case "gold":
                gold += amount;
                break;
            default:
                System.out.println("Unknown resource: " + resource);
        }
    }

    public void removeResource(String resource, int amount) {
        switch (resource.toLowerCase()) {
            case "wheat":
                wheat = Math.max(0, wheat - amount);
                break;
            case "wood":
                wood = Math.max(0, wood - amount);
                break;
            case "minerals":
                minerals = Math.max(0, minerals - amount);
                break;
            case "gold":
                gold = Math.max(0, gold - amount);
                break;
            default:
                System.out.println("Unknown resource: " + resource);
        }
    }

    public int getResourceAmount(String resource) {
        switch (resource.toLowerCase()) {
            case "wheat":
                return wheat;
            case "wood":
                return wood;
            case "minerals":
                return minerals;
            case "gold":
                return gold;
            default:
                System.out.println("Unknown resource: " + resource);
                return 0;
        }
    }
}
