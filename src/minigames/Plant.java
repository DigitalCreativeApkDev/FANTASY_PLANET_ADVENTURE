package minigames;

import java.io.Serializable;

public class Plant implements Serializable, Cloneable {
    /**
     * This class contains attributes of a plant on the board of the minigame "Box Eats Plants".
     * @author DigitalCreativeApkDev
     * */

    // Class attributes
    private final String name;
    private int x;
    private int y;

    public Plant(int x, int y) {
        name = "PLANT";
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

    public Plant clone() throws CloneNotSupportedException {
        return (Plant) super.clone();
    }
}
