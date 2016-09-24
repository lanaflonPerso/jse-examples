package core.collection.set;

import java.util.HashSet;

public class HashSetPuzzle {
    public static void main(String...args) {
        Employer employee = new Employer("rajeev", 24);
        Employer employee1 = new Employer("rajeev", 25);
        Employer employee2 = new Employer("rajeev", 24);

        HashSet<Employer> employees = new HashSet<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        System.out.println(employees);
        System.out.println(employees.contains(employee2));
        System.out.println(
                "employee.hashCode():  " + employee.hashCode() + "  employee2.hashCode():" + employee2.hashCode());
    }
}

class Employer {

    String name;
    int age;

    public Employer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employer employee = (Employer) obj;
        return employee.getName() == this.getName();
    }

    // commented
    /*
     * @Override public int hashCode() { int result=17; result=31*result+age; result=31*result+(name!=null ?
     * name.hashCode():0); return result; }
     */
}
