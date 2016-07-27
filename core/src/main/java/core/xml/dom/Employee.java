package core.xml.dom;

import java.util.Objects;

public class Employee {
    private String name;
    private String gender;
    private int age;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(gender, employee.gender)
                && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, role);
    }

    @Override
    public String toString() {
        return "Employee:: Name=" + this.name + " Age=" + this.age + " Gender=" + this.gender + " Role=" + this.role;
    }

}