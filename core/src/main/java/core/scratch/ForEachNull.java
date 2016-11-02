package core.scratch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehimnay on 17/10/2016.
 */
public class ForEachNull {
    public static final String DEFAULT_FLS_PMIC_RETENTION_PERIOD_IN_MINUTES = "" + 60 * 24 * 3;

    public static void main(String[] args) {
        System.out.println(DEFAULT_FLS_PMIC_RETENTION_PERIOD_IN_MINUTES);
        // NullPointerException
        /*List<String> list = null;
        for(String string : list){
            System.out.println(string);
        }*/
    }
}
