package com.example.project_amber.old;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Territory> territories;

    public Map() {
        this.territories = new ArrayList<>();
    }

    public void generateMap() {
        // Logique pour générer la carte
        // Par exemple, créer des territoires avec des biomes et des ressources
        territories.add(new Territory("Plains", "Grassland", new Resources()));
        territories.add(new Territory("Forest", "Woodland", new Resources()));
        territories.add(new Territory("Mountain", "Rocky", new Resources()));
        // Ajouter d'autres territoires selon la logique de génération
        System.out.println("com.example.project_amber.old.Map generated with " + territories.size() + " territories.");
    }

    public Territory getTerritory(String name) {
        for (Territory territory : territories) {
            if (territory.getName().equals(name)) {
                return territory;
            }
        }
        return null; // ou gérer l'erreur autrement
    }

    public List<Territory> getTerritories() {
        return territories;
    }
}
