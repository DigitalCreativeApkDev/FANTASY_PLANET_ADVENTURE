package minigames;

import java.io.Serializable;

public class BoxEatsPlantsBoard implements Serializable, Cloneable {
    /**
     * This class contains attributes of the board for the minigame "Box Eats Plants".
     * @author DigitalCreativeApkDev
     * */

    // Class attributes
    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 10;
    private BoxEatsPlantsTile[][] tiles;

    public BoxEatsPlantsBoard() {
        tiles = new BoxEatsPlantsTile[BOARD_HEIGHT][BOARD_WIDTH];
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            BoxEatsPlantsTile[] newList = new BoxEatsPlantsTile[BOARD_WIDTH];
            for (int j = 0; j < BOARD_WIDTH; j++) {
                newList[j] = new BoxEatsPlantsTile();
            }

            tiles[i] = newList;
        }
    }

    public BoxEatsPlantsBoard clone() throws CloneNotSupportedException {
        BoxEatsPlantsBoard newBoard = (BoxEatsPlantsBoard) super.clone();
        newBoard.tiles = new BoxEatsPlantsTile[BOARD_HEIGHT][BOARD_WIDTH];
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            BoxEatsPlantsTile[] newList = new BoxEatsPlantsTile[BOARD_WIDTH];
            for (int j = 0; j < BOARD_WIDTH; j++) {
                newList[j] = tiles[i][j].clone();
            }

            tiles[i] = newList;
        }

        return newBoard;
    }

    public BoxEatsPlantsTile[][] getTiles() {
        return tiles;
    }

    public BoxEatsPlantsTile getTileAt(int x, int y) {
        if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {
            return null;
        }

        return tiles[y][x];
    }

    public void setTiles(BoxEatsPlantsTile[][] tiles) {
        this.tiles = tiles;
    }

    public int numPlants() {
        int plants = 0;
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                BoxEatsPlantsTile currTile = getTileAt(x, y);
                if (currTile.getPlant() instanceof Plant) {
                    plants++;
                }
            }
        }

        return plants;
    }

    public int numRocks() {
        int rocks = 0;
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                BoxEatsPlantsTile currTile = getTileAt(x, y);
                if (currTile.getRock() instanceof Rock) {
                    rocks++;
                }
            }
        }

        return rocks;
    }

    public int numBoxes() {
        int boxes = 0;
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                BoxEatsPlantsTile currTile = getTileAt(x, y);
                if (currTile.getBox() instanceof Box) {
                    boxes++;
                }
            }
        }

        return boxes;
    }

    public Plant spawnPlant() {
        int plantX = (int) (Math.random() * BOARD_WIDTH);
        int plantY = (int) (Math.random() * BOARD_HEIGHT);
        BoxEatsPlantsTile plantTile = tiles[plantY][plantX];
        while (plantTile.getPlant() != null) {
            plantX = (int) (Math.random() * BOARD_WIDTH);
            plantY = (int) (Math.random() * BOARD_HEIGHT);
            plantTile = tiles[plantY][plantX];
        }

        Plant plant = new Plant(plantX, plantY);
        plantTile.addPlant(plant);
        return plant;
    }

    public Rock spawnRock() {
        int rockX = (int) (Math.random() * BOARD_WIDTH);
        int rockY = (int) (Math.random() * BOARD_HEIGHT);
        BoxEatsPlantsTile rockTile = tiles[rockY][rockX];
        while (rockTile.getRock() != null) {
            rockX = (int) (Math.random() * BOARD_WIDTH);
            rockY = (int) (Math.random() * BOARD_HEIGHT);
            rockTile = tiles[rockY][rockX];
        }

        Rock rock = new Rock(rockX, rockY);
        rockTile.addRock(rock);
        return rock;
    }

    public Box spawnBox() {
        int boxX = (int) (Math.random() * BOARD_WIDTH);
        int boxY = (int) (Math.random() * BOARD_HEIGHT);
        BoxEatsPlantsTile boxTile = tiles[boxY][boxX];
        while (boxTile.getBox() != null) {
            boxX = (int) (Math.random() * BOARD_WIDTH);
            boxY = (int) (Math.random() * BOARD_HEIGHT);
            boxTile = tiles[boxY][boxX];
        }

        Box box = new Box(boxX, boxY);
        boxTile.addBox(box);
        return box;
    }
}
