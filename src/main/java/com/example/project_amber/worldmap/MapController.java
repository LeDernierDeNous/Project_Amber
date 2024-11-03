package com.example.project_amber.worldmap;

import com.example.project_amber.worldmap.biomes.Biome;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MapController {

    private final ObjectMapper mapper = new ObjectMapper();
    private final int mapWidth;
    private final int mapHeight;

    public MapController(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;

        // Register custom deserializers for Biome subclasses if needed
        SimpleModule module = new SimpleModule();
        mapper.registerModule(module);
    }

    // Save the biome data to a JSON file
    public void saveMap(Biome[][] biomes, String filePath) throws IOException {
        mapper.writeValue(new File(filePath), biomes);
    }

    // Load biome data from a JSON file if it exists, otherwise generate a new map
    public Biome[][] loadOrGenerateMap(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            // Load existing map from file
            return mapper.readValue(file, Biome[][].class);
        } else {
            // Generate a new map based on noise and save it to file
            Biome[][] newMap = generateMap();
            saveMap(newMap, filePath);
            return newMap;
        }
    }

    // Generate a new map based on a simple noise function
    private Biome[][] generateMap() {
        Biome[][] map = new Biome[mapHeight][mapWidth];
        Random random = new Random();

        // Example simple noise-based generation
        for (int row = 0; row < mapHeight; row++) {
            for (int col = 0; col < mapWidth; col++) {
                double noiseValue = random.nextDouble();

                // Assign biomes based on noise thresholds
                if (noiseValue < 0.3) {
                    map[row][col] = BiomeFactory.getBiome("PLAIN");
                } else if (noiseValue < 0.6) {
                    map[row][col] = BiomeFactory.getBiome("FOREST");
                } else if (noiseValue < 0.8) {
                    map[row][col] = BiomeFactory.getBiome("MOUNTAIN");
                } else if (noiseValue < 0.9) {
                    map[row][col] = BiomeFactory.getBiome("RICH_PLAIN");
                } else if (noiseValue < 0.95) {
                    map[row][col] = BiomeFactory.getBiome("RICH_FOREST");
                } else {
                    map[row][col] = BiomeFactory.getBiome("RICH_MOUNTAIN");
                }
            }
        }
        return map;
    }
}
