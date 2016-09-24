package core.enums;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetMain {
    public static void main(String...args) {
        // approch 1
        EnumSet<DIRECTION> direction = EnumSet.allOf(DIRECTION.class);

        // approch 2
        direction.allOf(DIRECTION.class);
        Iterator<DIRECTION> directionIterator = direction.iterator();
        while (directionIterator.hasNext()) {
            System.out.println(directionIterator.next());
        }
    }
}
