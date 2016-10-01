package core.java8.date;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by ehimnay on 01/10/2016.
 */
public class Date {
    public static void main(String...args) {
        differenceBetween2DatesUsingPeriod();
        differenceBetween2DatesUsingChrono();
        differenceBetween2DatesUsingDuration();
    }

    public static void differenceBetween2DatesUsingPeriod() {
        LocalDate endOfCentury = LocalDate.of(2014, 01, 01);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(endOfCentury, now);
        System.out.printf("Difference is %d years, %d months and %d days old", diff.getYears(), diff.getMonths(),
                diff.getDays());
    }

    public static void differenceBetween2DatesUsingChrono()
    {
        LocalDate dateOfBirth = LocalDate.of(1980, Month.JULY, 4);
        LocalDate currentDate = LocalDate.now();
        long diffInDays = ChronoUnit.DAYS.between(dateOfBirth, currentDate);
        long diffInMonths = ChronoUnit.MONTHS.between(dateOfBirth, currentDate);
        long diffInYears = ChronoUnit.YEARS.between(dateOfBirth, currentDate);
        System.out.println(diffInDays + " " + diffInMonths + " " + diffInYears);
    }

    public static void differenceBetween2DatesUsingDuration()
    {
        LocalDateTime dateTime = LocalDateTime.of(1988, 7, 4, 0, 0);
        LocalDateTime dateTime2 = LocalDateTime.now();
        int diffInNano = Duration.between(dateTime, dateTime2).getNano();
        long diffInSeconds = Duration.between(dateTime, dateTime2).getSeconds();
        long diffInMilli = Duration.between(dateTime, dateTime2).toMillis();
        long diffInMinutes = Duration.between(dateTime, dateTime2).toMinutes();
        long diffInHours = Duration.between(dateTime, dateTime2).toHours();
    }
}
