package common;

import general.GameData;
import org.apfloat.Apfloat;
import javax.swing.JTable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Common implements Serializable, Cloneable {
    /**
     * This class contains attributes which are common for all classes throughout the game.
     * @author DigitalCreativeApkDev
     */

    // Constants
    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String[][] ELEMENT_CHART = {
            {"ATTACKING\nELEMENT", "TERRA", "FLAME", "SEA", "NATURE", "ELECTRIC", "ICE", "METAL", "DARK", "LIGHT", "WAR",
                    "PURE",
                    "LEGEND", "PRIMAL", "WIND"},
            {"DOUBLE\nDAMAGE", "ELECTRIC\nDARK", "NATURE\nICE", "FLAME\nWAR", "SEA\nLIGHT", "SEA\nMETAL", "NATURE\nWAR",
                    "TERRA\nICE", "METAL\nLIGHT", "ELECTRIC\nDARK", "TERRA\nFLAME", "LEGEND", "PRIMAL", "PURE", "WIND"},
            {"HALF\nDAMAGE", "METAL\nWAR", "SEA\nWAR", "NATURE\nELECTRIC", "FLAME\nICE", "TERRA\nLIGHT", "FLAME\nMETAL",
                    "ELECTRIC\nDARK", "TERRA", "NATURE", "SEA\nICE", "PRIMAL", "PURE", "LEGEND", "N/A"},
            {"NORMAL\nDAMAGE", "OTHER", "OTHER", "OTHER", "OTHER", "OTHER", "OTHER", "OTHER", "OTHER", "OTHER", "OTHER",
                    "OTHER",
                    "OTHER", "OTHER", "OTHER"}
    };

    /**
     * Checks whether a string is a number or not
     * @param string: a string to be checked
     * @return whether the string 'string' is a number or not.
     * */
    public static boolean isNumber(String string) {
        try {
            Apfloat a = new Apfloat(string);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static JTable tabulateElementChart() {
        String[] columnNames = ELEMENT_CHART[0];
        String[][] data = {ELEMENT_CHART[1], ELEMENT_CHART[2], ELEMENT_CHART[3]};
        return new JTable(data, columnNames);
    }

    public static String generateRandomName() {
        String result = ""; // initial value
        int nameLength = (int) (5 + Math.random() * 21);
        for (int i = 0; i < nameLength; i++) {
            result += LETTERS.charAt((int) (Math.random() * LETTERS.length()));
        }
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }

    public static int triangular(int n) {
        return n * (n + 1) / 2;
    }

    public static Apfloat apfloatSumOfList(List<String> aList) {
        Apfloat result = new Apfloat("0");
        for (String elem : aList) {
            if (isNumber(elem)) {
                result = result.add(new Apfloat(elem));
            }
        }

        return result;
    }

    public static Apfloat apfloatProductOfList(List<String> aList) {
        Apfloat result = new Apfloat("1");
        for (String elem : aList) {
            if (isNumber(elem)) {
                result = result.multiply(new Apfloat(elem));
            }
        }

        return result;
    }

    public static Apfloat getElementalDamageMultiplier(String element1, String element2) {
        return switch (element1) {
            case "TERRA" -> new ArrayList<>(List.of("ELECTRIC", "DARK")).contains(element2) ? new Apfloat("2") :
                    new ArrayList<>(List.of("METAL", "WAR")).contains(element2) ? new Apfloat("0.5") :
                            new Apfloat("1");
            case "FLAME" -> new ArrayList<>(List.of("NATURE", "ICE")).contains(element2) ? new Apfloat("2") :
                    new ArrayList<>(List.of("SEA", "WAR")).contains(element2) ? new Apfloat("0.5") :
                            new Apfloat("1");
            case "SEA" -> new ArrayList<>(List.of("FLAME", "WAR")).contains(element2) ? new Apfloat("2") :
                    new ArrayList<>(List.of("NATURE", "ELECTRIC")).contains(element2) ? new Apfloat("0.5") :
                            new Apfloat("1");
            case "NATURE" -> new ArrayList<>(List.of("SEA", "LIGHT")).contains(element2) ? new Apfloat("2") :
                    new ArrayList<>(List.of("FLAME", "ICE")).contains(element2) ? new Apfloat("0.5") :
                            new Apfloat("1");
            case "ELECTRIC" -> new ArrayList<>(List.of("SEA", "METAL")).contains(element2) ? new Apfloat("2") :
                    new ArrayList<>(List.of("TERRA", "LIGHT")).contains(element2) ? new Apfloat("0.5") :
                            new Apfloat("1");
            case "ICE" -> new ArrayList<>(List.of("NATURE", "WAR")).contains(element2) ? new Apfloat("2") :
                    new ArrayList<>(List.of("FLAME", "METAL")).contains(element2) ? new Apfloat("0.5") :
                            new Apfloat("1");
            case "METAL" -> new ArrayList<>(List.of("TERRA", "ICE")).contains(element2) ? new Apfloat("2") :
                    new ArrayList<>(List.of("ELECTRIC", "DARK")).contains(element2) ? new Apfloat("0.5") :
                            new Apfloat("1");
            case "DARK" -> new ArrayList<>(List.of("METAL", "LIGHT")).contains(element2) ? new Apfloat("2") :
                    element2.equals("TERRA") ? new Apfloat("0.5") : new Apfloat("1");
            case "LIGHT" -> new ArrayList<>(List.of("ELECTRIC", "DARK")).contains(element2) ? new Apfloat("2") :
                    element2.equals("NATURE") ? new Apfloat("0.5") : new Apfloat("1");
            case "WAR" -> new ArrayList<>(List.of("TERRA", "FLAME")).contains(element2) ? new Apfloat("2") :
                    new ArrayList<>(List.of("SEA", "ICE")).contains(element2) ? new Apfloat("0.5") :
                            new Apfloat("1");
            case "PURE" -> element2.equals("LEGEND") ? new Apfloat("2") : element2.equals("PRIMAL") ?
                    new Apfloat("0.5") : new Apfloat("1");
            case "LEGEND" -> element2.equals("PRIMAL") ? new Apfloat("2") : element2.equals("PURE") ?
                    new Apfloat("0.5") : new Apfloat("1");
            case "PRIMAL" -> element2.equals("PURE") ? new Apfloat("2") : element2.equals("LEGEND") ?
                    new Apfloat("0.5") : new Apfloat("1");
            case "WIND" -> element2.equals("WIND") ? new Apfloat("2") : new Apfloat("1");
            default -> new Apfloat("1");
        };
    }

    public static Apfloat resistanceAccuracyRule(Apfloat resistance, Apfloat accuracy) {
        if (resistance.subtract(accuracy).compareTo(new Apfloat("0.15")) <= 0) {
            return new Apfloat("0.15");
        }
        else {
            return resistance.subtract(accuracy);
        }
    }

    public static GameData loadGameData(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream restore = new ObjectInputStream(new FileInputStream(filename));
        return (GameData) restore.readObject();
    }

    public static void saveGameData(GameData gameData, String filename) throws IOException {
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(filename));
        save.writeObject(gameData);
        save.close();
    }
}
