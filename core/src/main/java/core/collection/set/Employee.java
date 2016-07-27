package core.collection.set;

class Employee implements Comparable {

    private String name;
    private int salary;

    public Employee() {

    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + this.name + " Salary: " + this.salary;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}