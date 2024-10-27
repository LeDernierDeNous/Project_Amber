package com.example.project_amber.old;

public enum Biomes {
    PLAIN("Wheat", 1),
    FOREST("Wood", 1),
    MOUNTAIN("Ore", 1),
    RICH_PLAIN("Wheat", 2),
    RICH_FOREST("Wood", 2),
    RICH_MOUNTAIN("Ore", 2);

    final private String resource;
    final private int resourceMultiplier;

    Biomes(String resource, int resourceMultiplier) {
        this.resource = resource;
        this.resourceMultiplier = resourceMultiplier;
    }

    public String getResource() {
        return resource;
    }

    public int getResourceMultiplier() {
        return resourceMultiplier;
    }
}
