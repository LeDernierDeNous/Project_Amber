package com.example.project_amber.worldmap;

import com.example.project_amber.worldmap.biomes.Biome;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapController {

    private static final Logger LOGGER = Logger.getLogger(MapController.class.getName());
    private static final ObjectMapper mapper = new ObjectMapper();
    private final int mapWidth;
    private final int mapHeight;
    private final MapRenderer mapRenderer;

    static {
        // Register custom Color serializer and deserializer
        SimpleModule module = new SimpleModule();
        module.addSerializer(Color.class, new ColorSerializer());
        module.addDeserializer(Color.class, new ColorDeserializer());
        mapper.registerModule(module);
    }

    public MapController(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        mapRenderer = new MapRenderer(mapHeight, mapWidth);

        // Register custom deserializers for Biome subclasses if needed
        SimpleModule module = new SimpleModule();
        mapper.registerModule(module);
    }

    public void renderMap(GridPane gridPane) {
        mapRenderer.renderMap(gridPane);
    }

    public void saveMap(String filePath) throws IOException {
        mapper.writeValue(new File(filePath), mapRenderer.getBiomes());
    }

    public void loadOrGenerateMap(String filePath) {
        File file = new File(filePath);
        try {
            if (file.exists()) {
                LOGGER.info("Loading map from JSON file...");
                mapRenderer.setBiomes(mapper.readValue(file, Biome[][].class));
            } else {
                LOGGER.info("JSON file not found. Generating a new map...");
                // Generate a new map and set it to mapRenderer
                mapRenderer.setBiomes(generateMap());
                // Now save the generated map to JSON
                saveMap(filePath);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading map from JSON", e);

            // Generate a new map if loading fails
            mapRenderer.setBiomes(generateMap());
            try {
                saveMap(filePath);
            } catch (IOException saveException) {
                LOGGER.log(Level.SEVERE, "Failed to save new map to JSON", saveException);
            }
        }
    }

    // Custom serializer for Color
    public static class ColorSerializer extends JsonSerializer<Color> {
        @Override
        public void serialize(Color color, JsonGenerator gen, com.fasterxml.jackson.databind.SerializerProvider serializers) throws IOException {
            gen.writeString(String.format("#%02X%02X%02X",
                    (int) (color.getRed() * 255),
                    (int) (color.getGreen() * 255),
                    (int) (color.getBlue() * 255)));
        }
    }

    // Custom deserializer for Color
    public static class ColorDeserializer extends JsonDeserializer<Color> {
        @Override
        public Color deserialize(com.fasterxml.jackson.core.JsonParser parser, com.fasterxml.jackson.databind.DeserializationContext context) throws IOException {
            return Color.web(parser.getText());
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
