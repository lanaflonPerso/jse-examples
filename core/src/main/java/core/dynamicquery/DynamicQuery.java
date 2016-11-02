package core.dynamicquery;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ehimnay on 10/10/2016.
 */
public class DynamicQuery {
    private static final String FLS_PM_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(FLS_PM_DATE_FORMAT);

    public static void main(String[] args) {
        int noOfDays = 3;

        System.out.println(removeDays(noOfDays));
        List<FLSQueryBuilder> filters = new ArrayList<FLSQueryBuilder>() {
            {
                add(new FLSQueryBuilder("fileCreationTimeInOss", "<", "a", "current_timestamp - INTERVAL '" + noOfDays + " days'"));
            }
        };
        System.out.println(buildQuery(filters));

    }

    public static Date removeDays(int days) {
        return DateUtils.addDays(new Date(), -days);
    }

    public static String buildQuery(List<FLSQueryBuilder> criteriaBuilder) {
        StringBuffer queryBuffer = new StringBuffer()
                .append("PMRopInfo")
                .append(" e");
        if (criteriaBuilder != null && !criteriaBuilder.isEmpty()) {
            queryBuffer.append(" where");
            for (FLSQueryBuilder criteria : criteriaBuilder) {
                queryBuffer.append(" e.")
                        .append(criteria.getField())
                        .append(" ")
                        .append(criteria.getOperator())
                        .append(" :")
                        .append(criteria.getPlaceHolder())
                        .append(" AND");
            }
            queryBuffer.delete(queryBuffer.lastIndexOf(" AND"), queryBuffer.length());
        }
        return queryBuffer.toString();
    }
}
