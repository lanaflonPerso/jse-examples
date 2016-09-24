package core.enums;

import java.util.EnumMap;
import java.util.Iterator;

/*
 * http://www.javaworld.com/article/2073430/the-sleek-enummap-and-enumset.html
 */

public class EnumMapMain {

    public static void main(String...args) {
        EnumMap<DIRECTION, String> enumMap = new EnumMap<DIRECTION, String>(DIRECTION.class);
        enumMap.put(DIRECTION.EAST, "East");
        enumMap.put(DIRECTION.WEST, "West");
        enumMap.put(DIRECTION.NORTH, "North");
        //		enumMap.put(null, "South");

        System.out.println("EnumMap: " + enumMap);
        System.out.println(enumMap.containsKey(DIRECTION.SOUTH));
        System.out.println(enumMap.containsValue(null));

        Iterator<DIRECTION> enumKeySet = null;
        for (enumKeySet = enumMap.keySet().iterator(); enumKeySet.hasNext();) {
            System.out.println(enumMap.get(enumKeySet.next()));
        }
    }
}