package reusablecomponents;

import java.util.Date;

public class UtilFunctions {

    public static String getDynamicEmailId() {
        Date date = new Date();
        String dateAsString = date.toString();
        dateAsString = dateAsString.replace(" ", "_");
        dateAsString = dateAsString.replace("_IST_2024", "");
        dateAsString = dateAsString.replace(":","_");
        dateAsString = dateAsString + "@gmail.com";
        return dateAsString;
    }
}
