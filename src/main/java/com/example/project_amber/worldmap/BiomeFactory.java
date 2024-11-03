package com.example.project_amber.worldmap;

import com.example.project_amber.worldmap.biomes.*;

import java.util.HashMap;
import java.util.Map;

public class BiomeFactory {
    private static final Map<String, Biome> biomes = new HashMap<>();

    // Static block to initialize biomes
    static {
        biomes.put("PLAIN", new PlainBiome());
        biomes.put("FOREST", new ForestBiome());
        biomes.put("MOUNTAIN", new MountainBiome());
        biomes.put("RICH_PLAIN", new RichPlainBiome());
        biomes.put("RICH_FOREST", new RichForestBiome());
        biomes.put("RICH_MOUNTAIN", new RichMountainBiome());
    }

    // Method to get a Biome by its name
    public static Biome getBiome(String biomeName) {
        return biomes.get(biomeName);
    }
}
