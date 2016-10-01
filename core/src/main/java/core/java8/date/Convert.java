package core.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ehimnay on 01/10/2016.
 */
public class Convert {
    public static void main(String...args) {
        stringToDate();
        stringToDateCustom();
    }

    public static void stringToDate(){
        String armisticeDate = "2016-04-04";
        LocalDate aLD = LocalDate.parse(armisticeDate);
        System.out.println(aLD);
        String armisticeDateTime = "2016-04-04T11:50";
        LocalDateTime aLDT = LocalDateTime.parse(armisticeDateTime);
        System.out.println("Date/Time: " + aLDT);
    }

    public static void stringToDateCustom(){
        String anotherDate = "04 Apr 2016";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate random = LocalDate.parse(anotherDate, df);
        System.out.println(anotherDate + " parses as " + random);
    }
}
