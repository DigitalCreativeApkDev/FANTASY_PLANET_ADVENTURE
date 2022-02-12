package minigames;

import java.io.Serializable;

public class BoxEatsPlantsTile implements Serializable, Cloneable {
    /**
     * This class represents a tile in the minigame "Box Eats Plants".
     * @author DigitalCreativeApkDev
     * */

    // Class attributes
    private Box box;
    private Plant plant;
    private Rock rock;

    public BoxEatsPlantsTile() {}

    public BoxEatsPlantsTile clone() throws CloneNotSupportedException {
        BoxEatsPlantsTile newTile = (BoxEatsPlantsTile) super.clone();
        newTile.box = this.box.clone();
        newTile.plant = this.plant.clone();
        newTile.rock = this.rock.clone();
        return newTile;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Rock getRock() {
        return rock;
    }

    public void setRock(Rock rock) {
        this.rock = rock;
    }

    public boolean addPlant(Plant plant) {
        if (this.plant == null) {
            this.plant = plant;
            return true;
        }
        return false;
    }

    public boolean addRock(Rock rock) {
        if (this.rock == null) {
            this.rock = rock;
            return true;
        }
        return false;
    }

    public boolean addBox(Box box) {
        if (this.box == null) {
            this.box = box;
            return true;
        }
        return false;
    }
}
