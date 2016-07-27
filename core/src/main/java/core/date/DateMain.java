package core.date;

import java.util.Date;

public class DateMain {
    public static void main(String... strings) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
    }
}
