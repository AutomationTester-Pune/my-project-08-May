import java.util.Date;

public class Playground {

    public static void main(String[] args) {
        Date date = new Date();
        String dateAsString = date.toString();
        dateAsString = dateAsString.replace(" ", "_");
        dateAsString = dateAsString.replace("_IST_2024", "");
        dateAsString = dateAsString.replace(":","_");
        System.out.println(dateAsString);
    }
}
