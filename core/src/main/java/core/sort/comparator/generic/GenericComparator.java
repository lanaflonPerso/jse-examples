package core.sort.comparator.generic;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Date;

/**
 * Generic Comparator
 * 
 */
public final class GenericComparator implements Comparator, Serializable {

    private static final long serialVersionUID = 1L;

    private static final int LESSER = -1;
    private static final int EQUAL = 0;
    private static final int GREATER = 1;

    private static final String METHOD_GET_PREFIX = "get";

    private static final String STRING = "java.lang.String";
    private static final String INTEGER = "java.lang.Integer";
    private static final String LONG = "java.lang.Long";
    private static final String FLOAT = "java.lang.Float";
    private static final String DOUBLE = "java.lang.Double";
    private static final String DATE = "java.util.Date";

    private String targetMethod;
    private boolean asc;

    public GenericComparator(boolean asc) {
        super();
        this.targetMethod = null;
        this.asc = asc;
    }

    public GenericComparator(String sortField) {
        this(sortField, true);
    }

    public GenericComparator(String sortField, boolean asc) {
        super();
        this.targetMethod = prepareGetterMethod(sortField);
        this.asc = asc;
    }

    private final static String prepareGetterMethod(String name) {
        StringBuffer fieldName = new StringBuffer(METHOD_GET_PREFIX);
        fieldName.append(name.substring(0, 1).toUpperCase());
        fieldName.append(name.substring(1));
        return fieldName.toString();
    }

    private final static Object invoke(Method method, Object obj)
            throws InvocationTargetException, IllegalAccessException {
        return method.invoke(obj, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compare(Object o1, Object o2) {
        int response = LESSER;
        try {
            Object v1 = (null == this.targetMethod) ? o1 : getValue(o1);
            Object v2 = (null == this.targetMethod) ? o2 : getValue(o2);
            CompareMode cm = findCompareMode(v1, v2);

            if (!cm.equals(CompareMode.DEFAULT)) {
                return compareAlternate(cm);
            }

            final String returnType = (null == this.targetMethod) ? o1.getClass().getName()
                    : getMethod(o1).getReturnType().getName();
            response = compareActual(v1, v2, returnType);
        } catch (NoSuchMethodException nsme) {
        } catch (IllegalAccessException iae) {
        } catch (InvocationTargetException ite) {
        }
        return response;
    }

    /**
     * alternate to actual value comparison i.e., either (lsh &amp; rhs) one the value could be null
     *
     * @param cm
     *            - a enum used to idetify the position for com.org.ds.sorting
     */
    private int compareAlternate(CompareMode cm) {
        int compareState = LESSER;
        switch (cm) {
        case LESS_THAN:
            compareState = LESSER * determinePosition();
            break;
        case GREATER_THAN:
            compareState = GREATER * determinePosition();
            break;
        case EQUAL:
            compareState = EQUAL * determinePosition();
            break;
        }
        return compareState;
    }

    /**
     * actual value comparison for com.org.ds.sorting; both lsh &amp; rhs value available
     *
     * @param v1
     *            - value of lhs
     * @param v2
     *            - value of rhs
     * @param returnType
     *            - datatype of given values
     * @return int - compare return value
     */
    private int compareActual(Object v1, Object v2, String returnType) {
        int acutal = LESSER;
        if (INTEGER.toLowerCase().contains(returnType.toLowerCase())) {
            acutal = (((Integer) v1).compareTo((Integer) v2) * determinePosition());
        } else if (LONG.toLowerCase().contains(returnType.toLowerCase())) {
            acutal = (((Long) v1).compareTo((Long) v2) * determinePosition());
        } else if (STRING.toLowerCase().contains(returnType.toLowerCase())) {
            acutal = compareAlphaNumString((String) v1, (String) v2) * determinePosition();
        } else if (DATE.toLowerCase().contains(returnType.toLowerCase())) {
            acutal = (((Date) v1).compareTo((Date) v2) * determinePosition());
        } else if (FLOAT.toLowerCase().contains(returnType.toLowerCase())) {
            acutal = (((Float) v1).compareTo((Float) v2) * determinePosition());
        } else if (DOUBLE.toLowerCase().contains(returnType.toLowerCase())) {
            acutal = (((Double) v1).compareTo((Double) v2) * determinePosition());
        }
        return acutal;
    }

    private Object getValue(Object obj)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return invoke(getMethod(obj), obj);
    }

    private final Method getMethod(Object obj) throws NoSuchMethodException {
        return obj.getClass().getMethod(targetMethod, null);
    }

    private CompareMode findCompareMode(Object o1, Object o2) {
        CompareMode cm = CompareMode.LESS_THAN;

        if (null != o1 & null != o2) {
            cm = CompareMode.DEFAULT;
        } else if (null == o1 & null != o2) {
            cm = CompareMode.LESS_THAN;
        } else if (null != o1 & null == o2) {
            cm = CompareMode.GREATER_THAN;
        } else if (null == o1 & null == o2) {
            cm = CompareMode.EQUAL;
        }

        return cm;
    }

    /**
     * Determining positing for com.org.ds.sorting
     *
     * @return -1 to change the sort order if appropriate.
     */
    private int determinePosition() {
        return asc ? GREATER : LESSER;
    }

    /**
     * Compares two string ending with numbers.
     *
     * @param s1
     * @param o2
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

    private enum CompareMode {
        EQUAL, LESS_THAN, GREATER_THAN, DEFAULT
    }

}
