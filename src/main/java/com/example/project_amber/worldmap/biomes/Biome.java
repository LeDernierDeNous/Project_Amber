package com.example.project_amber.worldmap.biomes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.scene.paint.Color;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,  // Use the 'name' field in the JSON to discriminate between subclasses
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,  // Put the 'type' field outside the JSON object
        property = "type"  // The field in the JSON that holds the type name
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PlainBiome.class, name = "Plain"),
        @JsonSubTypes.Type(value = ForestBiome.class, name = "Forest"),
        @JsonSubTypes.Type(value = MountainBiome.class, name = "Mountain"),
        @JsonSubTypes.Type(value = RichPlainBiome.class, name = "RichPlain"),
        @JsonSubTypes.Type(value = RichForestBiome.class, name = "RichForest"),
        @JsonSubTypes.Type(value = RichMountainBiome.class, name = "RichMountain")
})

public abstract class Biome {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("color")
    private final Color color;
    @JsonProperty("resource")
    private final String resource;
    @JsonProperty("resourceMultiplier")
    private final int resourceMultiplier;

    public Biome(@JsonProperty("name") String name, @JsonProperty("color") Color color, @JsonProperty("resource") String resource, @JsonProperty("resourceMultiplier") int resourceMultiplier) {
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
