import java.util.ArrayList;
import java.util.List;

public class Faction {
    private String name;
    private List<Territory> territory;
    private List<Faction> alliances;

    public Faction(String name) {
        this.name = name;
        this.territory = new ArrayList<>();
        this.alliances = new ArrayList<>();
    }

    public void negotiate(Faction otherFaction) {
        // Logique pour négocier un accord
        System.out.println(name + " is negotiating with " + otherFaction.getName());
    }

    public void declareWar(Faction enemyFaction) {
        // Logique pour déclarer la guerre
        System.out.println(name + " has declared war on " + enemyFaction.getName());
    }

    public void formAlliance(Faction allyFaction) {
        alliances.add(allyFaction);
        System.out.println(name + " has formed an alliance with " + allyFaction.getName());
    }

    public String getName() {
        return name;
    }

    public List<Territory> getTerritory() {
        return territory;
    }
}
