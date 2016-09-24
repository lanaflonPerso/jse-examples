package core.assignment;

import java.util.Calendar;
import java.util.Date;

public class TimeMain {

    /**
     * @param args
     */
    public static void main(String...args) {
        //		System.out.println(getTime());

    }

    private static Date getTime() {
        final Calendar calender = Calendar.getInstance();
        calender.set(Calendar.HOUR_OF_DAY, 0);
        calender.set(Calendar.MINUTE, 0);
        calender.set(Calendar.SECOND, 0);
        if (calender.getTime().getTime() < System.currentTimeMillis()) {
            calender.set(Calendar.DATE, calender.get(Calendar.DATE) + 1);
        }
        calender.set(Calendar.DATE, calender.get(Calendar.DATE) + 1);
        System.out.println(calender.getTime());
        return calender.getTime();
    }

}
