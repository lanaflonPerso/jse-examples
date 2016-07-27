package core.sort.comparator;

public class ComparableCheck {
    public static Comparable<ComparableCheck> sortByName = new Comparable<ComparableCheck>() {

        @Override
        public int compareTo(ComparableCheck obj) {
            return obj.name.compareTo(obj.name);
        }

    };
    private static ComparableCheck obj;
    public static Comparable<ComparableCheck> sortByAge = new Comparable<ComparableCheck>() {

        @Override
        public int compareTo(ComparableCheck object) {
            return obj.age - object.age;
        }

    };
    private int age;
    private String name;

    public ComparableCheck(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void setObj(ComparableCheck obj) {
        ComparableCheck.obj = obj;
    }

}