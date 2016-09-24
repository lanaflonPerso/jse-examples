package core.collection.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

    public static void main(String...args) {
        Set<Employee> treeSet = new TreeSet<>();
        Employee employee = new Employee();
        treeSet.add(employee);
        employee = null;
        for (Employee str : treeSet) {
            System.out.println(str);
        }

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Iterator<Employee> iterator2 = treeSet.iterator(); iterator2.hasNext();) {
            System.out.println(iterator2.next());
        }

    }

}
