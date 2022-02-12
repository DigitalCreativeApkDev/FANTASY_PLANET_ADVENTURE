package minigames;

import java.io.Serializable;

public class Rock implements Serializable, Cloneable {
    /**
     * This class contains attributes of a plant on the rock of the minigame "Box Eats Plants".
     * @author DigitalCreativeApkDev
     * */

    // Class attributes
    private final String name;
    private int x;
    private int y;

    public Rock(int x, int y) {
        name = "ROCK";
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rock clone() throws CloneNotSupportedException {
        return (Rock) super.clone();
    }
}
