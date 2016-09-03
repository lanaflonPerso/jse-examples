/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2016
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/

package main.java.com.org.ds.common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FLSHelper {

   public <T> List<List<T>> choppedList(final List<T> list, final int size) {
        final List<List<T>> choppedList = new ArrayList<>();
        final int N = list.size();
        for (int i = 0; i < N; i += size) {
            choppedList.add(new ArrayList<>(
                    list.subList(i, Math.min(N, i + size)))
            );
        }
        return choppedList;
    }

    public String replaceLast(final String string, final String character) {
        return string.substring(0, string.length() - 1) + character;
    }

    public Date stringToDate(){
        String string = "2016-05-17T23:30:00+05:00";
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(string);
            System.out.println(date);
        }catch(final ParseException exception){
        }
        return date;
    }

    public static void main(String...args) {
        new FLSHelper().stringToDate();
    }
}