package core.tricks;

import java.util.Objects;
import java.util.TimeZone;

public class TricksMain {

    /**
     * @param args
     */
    public static void main(String...args) {
        String test = "Himansu";
        System.out.println(Objects.requireNonNull(test));

        System.out.println(TimeZone.getDefault().getID());
        System.out.println(TimeZone.getTimeZone(TimeZone.getDefault().getID()));

        /*
         * transient String test = "test"; static String test = "test"; String test; System.out.println(test);
         */
    }

}
