package core.collection.set;

import java.util.TreeSet;

public class TreeMapCustomSortMain {

    public static void main(String a[]) {
        TreeSet<Employee> nameSet = new TreeSet<Employee>(new EmployeeNameComparator());
        nameSet.add(new Employee("Himansu", 3000));
        nameSet.add(new Employee("Shruti", 6000));
        nameSet.add(new Employee("Manoj", 10000));
        nameSet.add(new Employee("Rachana", 20000));
        for (Employee employee : nameSet) {
            System.out.println(employee);
        }

        TreeSet<Employee> salarySet = new TreeSet<Employee>(new EmployeeSalaryComparator());
        nameSet.add(new Employee("Himansu", 3000));
        nameSet.add(new Employee("Shruti", 6000));
        nameSet.add(new Employee("Manoj", 10000));
        nameSet.add(new Employee("Rachana", 20000));
        for (Employee e : salarySet) {
            System.out.println(e);
        }
    }
}