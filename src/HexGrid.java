import java.util.ArrayList;
import java.util.Random;

public class HexGrid {
    private int rows;
    private int cols;
    private ArrayList<HexTile> hexTiles;
    private Random random;

    public HexGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.hexTiles = new ArrayList<>();
        this.random = new Random();
        generateGrid();
    }

    // Fonction pour générer la grille avec des biomes basés sur une noise map
    private void generateGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int q = col - (row / 2); // Coordonnée axiale q
                int r = row; // Coordonnée axiale r
                double noiseValue = SimplexNoise.noise(q * 0.1, r * 0.1); // Génération de bruit

                Biomes biomes = determineBiome(noiseValue);
                hexTiles.add(new HexTile(q, r, biomes));
            }
        }
    }

    // Détermine le biome en fonction de la valeur de bruit
    private Biomes determineBiome(double noiseValue) {
        if (noiseValue > 0.5) {
            return Biomes.RICH_PLAIN; // Par exemple, plaines riches
        } else if (noiseValue > 0.2) {
            return Biomes.PLAIN;
        } else if (noiseValue > -0.2) {
            return Biomes.FOREST;
        } else if (noiseValue > -0.5) {
            return Biomes.MOUNTAIN;
        } else {
            return Biomes.RICH_MOUNTAIN; // Montagnes riches
        }
    }

    // Affiche la grille
    public void printGrid() {
        for (HexTile tile : hexTiles) {
            System.out.println(tile);
        }
    }
}
