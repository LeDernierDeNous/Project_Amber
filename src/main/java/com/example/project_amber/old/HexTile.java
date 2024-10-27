package com.example.project_amber.old;

public class HexTile {
    private int q;
    private int r;
    private Biomes biomes;

    public HexTile(int q, int r, Biomes biomes) {
        this.q = q;
        this.r = r;
        this.biomes = biomes;
    }

    public Biomes getBiome() {
        return biomes;
    }

    public String getResourceType() {
        return biomes.getResource();
    }

    public int getResourceMultiplier() {
        return biomes.getResourceMultiplier();
    }

    @Override
    public String toString() {
        return "com.example.project_amber.old.HexTile at (" + q + ", " + r + "), Biome: " + biomes + ", Resource: "
                + getResourceType() + " (Multiplier: " + getResourceMultiplier() + ")";
    }
}
