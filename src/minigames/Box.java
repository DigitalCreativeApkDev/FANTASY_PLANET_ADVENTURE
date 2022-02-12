package minigames;

import java.io.Serializable;

public class Box implements Serializable, Cloneable{
    /**
     * This class contains attributes of a box on the board of the minigame "Box Eats Plants".
     * @author DigitalCreativeApkDev
     * */

    // Class attributes
    private final String name;
    private int x;
    private int y;

    public Box(int x, int y) {
        name = "BOX";
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

    public Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }
}
