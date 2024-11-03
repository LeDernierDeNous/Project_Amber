package com.example.project_amber.worldmap.biomes;

import javafx.scene.paint.Color;

public abstract class Biome {
    private final String name;
    private final Color color;
    private final String resource;
    private final int resourceMultiplier;

    public Biome(String name, Color color, String resource, int resourceMultiplier) {
        this.name = name;
        this.color = color;
        this.resource = resource;
        this.resourceMultiplier = resourceMultiplier;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public String getResource() {
        return resource;
    }

    public int getResourceMultiplier() {
        return resourceMultiplier;
    }
}
