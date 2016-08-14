package core.sort.comparator.combine;

import java.util.Comparator;

public class ComparableComparator implements Comparable<ComparableComparator> {
    private int age;
    private String name;

    public ComparableComparator(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static Comparator<ComparableComparator> sortByName = new Comparator<ComparableComparator>() {

        @Override
        public int compare(ComparableComparator obj1, ComparableComparator obj2) {
            return obj1.name.compareTo(obj2.name);
        }
    };

    public static Comparator<ComparableComparator> sortByAge = new Comparator<ComparableComparator>() {

        @Override
        public int compare(ComparableComparator obj1, ComparableComparator obj2) {
            return obj1.age - obj2.age;
        }
    };

    @Override
    public int compareTo(ComparableComparator object) {
        return this.name.compareTo(object.name);
    }

    @Override
    public String toString() {
        return "Age : " + age + " Name : " + name;

    }
}