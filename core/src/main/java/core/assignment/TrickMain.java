package core.assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public abstract class TrickMain {

    /**
     * @param args
     */
    public static void main(String...args) {
        //        template();
        forEach();

    }

    public static void template() {
        System.out.println("abc".equals(null));
        date();
        intern();
        match();
        replace();
        int i = finallyIncrement();
        System.out.println(i);
        reverseNumber(123);
        testNaN();
        Runtime.getRuntime().runFinalization();
        Runtime.runFinalizersOnExit(true);
        forEach();
    }

    public static void forEach() {
        for (String name : callForEach()) {
            System.out.println("Hello " + name);

        }
    }

    public static List<String> callForEach() {
        String names[] = new String[] { "Himansu", "Dinesh", "Chaminda" };
        return Arrays.asList(names);
    }

    public static void date() {
        Date javaDate = new Date();
        System.out.println(javaDate);
        java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
        System.out.println(sqlDate);
        java.sql.Date.valueOf("2015-08-19");
        System.out.println(sqlDate);
    }

    public static void intern() {
        String westmeath = new String("athlone");
        String roscommon = new String("athlone");
        System.out.println(westmeath.equals(roscommon));
        System.out.println(westmeath == roscommon);
        System.out.println(roscommon.intern() == westmeath.intern());
    }

    public static void match() {
        String regularExpression = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String email = "himansuxnayak@gmail.co.in";
        System.out.println(email.matches(regularExpression));
    }

    public static void replace() {
        String initial = "himansu nayak 18A Shannon Weir Athlone Westmeath";
        String[] arr = initial.split(" ");
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        arr = (String[]) list.toArray();
        StringBuilder sb = new StringBuilder();
        for (String word : arr) {
            sb.append(" ");
            sb.append(word);
        }
        String result = sb.toString();
        result.replaceFirst(" ", "");
        System.out.println(result);
    }

    public static int finallyIncrement() {
        int i = 0;
        try {
            return i;
        } finally {
            i += 100;
        }
    }

    public static void reverseNumber(long number) {
        long reverse = 0;
        for (; number != 0; number = number / 10) {
            long single = number % 10;
            reverse = reverse * 10 + single;
        }
        System.out.println(reverse);
    }

    public static void testNaN() {
        System.out.println(Double.NaN - Double.NaN);
        if (Double.NaN == Double.NaN)
            System.out.println("Hello");
        System.out.println("World");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("insdie finalize");
    }
}