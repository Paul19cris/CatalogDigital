package Utils;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

public class Utils {
    public boolean checkIfEntityExistsInArray(String string, ArrayList<String> list) {
        for (String string1 : list) {
            if (string.equals(string1)) return true;
        }
        return false;
    }
}
