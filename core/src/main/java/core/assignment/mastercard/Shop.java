package core.assignment.mastercard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ehimnay on 07/09/2016.
 */
public class Shop {
    public static void main(String...args) {
        Map<String, Double> priceList = new HashMap<String, Double>() {
            {
                put("pen", 1.0);
                put("pencil", 2.3);
                put("eraser", 3.0);
                put("apple", 5.0);
                put("banana", 3.0);
            }
        };
    }
}
