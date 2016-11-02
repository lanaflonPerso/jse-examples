package core.scratch;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ehimnay on 13/10/2016.
 */
public class TimeStamp {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    public static void main(String[] args) {
        System.out.println("Before Parsing : " + "yyyy-MM-dd'T'HH:mm:ssXXX");
        System.out.println("After Parsing : " + parse("2016-10-17T09:15:02+01:00"));
        System.out.println(minDiffInDate(60));

        /*String format2 = timeWithOffset(Calendar.getInstance().getTime());
        System.out.println("Before Parsing : " + format2);
        System.out.println("After Parsing : " + parse(format2));*/
    }

    public static Date parse(final String text) {
        Date date = null;
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        try {
            dateFormat.setTimeZone(TimeZone.getDefault());
            date = dateFormat.parse(text);
        } catch (ParseException ex) {
        }
        return date;
    }

    public static Date minDiffInDate(int minutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, -minutes);
        return calendar.getTime();
    }
    public static String timeWithOffset(final Date date) {
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        sf.setTimeZone(TimeZone.getDefault());
        return sf.format(date);
    }
}
