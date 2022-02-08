import org.apfloat.Apfloat;

import java.io.Serializable;

public class Common implements Serializable {
    /**
     * This class contains attributes which are common for all classes throughout the game.
     * @author: DigitalCreativeApkDev
     */

    /**
     * Checks whether a string is a number or not
     * @param string: a string to be checked
     * @return: whether the string 'string' is a number or not.
     * */
    public boolean isNumber(String string) {
        try {
            Apfloat a = new Apfloat(string);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
