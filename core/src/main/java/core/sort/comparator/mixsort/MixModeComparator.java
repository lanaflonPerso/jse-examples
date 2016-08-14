package core.sort.comparator.mixsort;

/*
 * The MixModeComparator Algorithm is an improved com.org.ds.sorting algorithm for com.org.ds.strings
 * containing numbers.  Instead of com.org.ds.sorting numbers in ASCII order like
 * a standard sort, this algorithm sorts numbers in numeric order.
 */

import java.util.Comparator;

/**
 * To use this class: Use the static "sort" method from the java.util.Collections class: Collections.sort(your list, new
 * AlphanumComparator());
 */
public class MixModeComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof String) || !(o2 instanceof String)) {
            return 0;
        }
        return compareAlphaNumString((String) o1, (String) o2);
    }

    /**
     * Compares two string ending with numbers.
     * 
     * @param s1
     * @param s2
     * @return int - compare return value -1, 0 or 1.
     */
    private int compareAlphaNumString(String s1, String s2) {
        int thisMarker = 0;
        int thatMarker = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();
        while (thisMarker < s1Length && thatMarker < s2Length) {
            String thisChunk = getChunk(s1, thisMarker);
            thisMarker += thisChunk.length();

            String thatChunk = getChunk(s2, thatMarker);
            thatMarker += thatChunk.length();

            // If both chunks contain numeric characters, sort them numerically
            int result = 0;
            if (Character.isDigit(thisChunk.charAt(0)) && Character.isDigit(thatChunk.charAt(0))) {
                // Simple chunk comparison by length.
                int thisChunkLength = thisChunk.length();
                result = thisChunkLength - thatChunk.length();
                // If equal, the first different number counts
                if (result == 0) {
                    for (int i = 0; i < thisChunkLength; i++) {
                        result = thisChunk.charAt(i) - thatChunk.charAt(i);
                        if (result != 0) {
                            return result;
                        }
                    }
                }
            } else {
                result = thisChunk.compareTo(thatChunk);
            }

            if (result != 0)
                return result;
        }

        return s1Length - s2Length;
    }

    /**
     * Separate the numeric part from the string
     * 
     * @param s
     *            - string to be processed
     * @param marker
     *            - position
     * 
     * @return numeric substring.
     */
    private final String getChunk(String s, int marker) {
        StringBuilder chunk = new StringBuilder();
        char c = s.charAt(marker);
        chunk.append(c);
        marker++;
        int length = s.length();
        if (Character.isDigit(c)) {
            while (marker < length) {
                c = s.charAt(marker);
                if (!Character.isDigit(c))
                    break;
                chunk.append(c);
                marker++;
            }
        } else {
            while (marker < length) {
                c = s.charAt(marker);
                if (Character.isDigit(c))
                    break;
                chunk.append(c);
                marker++;
            }
        }
        return chunk.toString();
    }
}