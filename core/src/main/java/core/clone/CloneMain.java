package core.clone;

public class CloneMain {

    public static void main(String...args) throws CloneNotSupportedException {
        Department dept = new Department(1, "Human Resource");
        Employee original = new Employee(1, "Admin", dept);
        Employee cloned = (Employee) original.clone();
        System.out.println(cloned.getEmployeeName().hashCode() == original.getEmployeeName().hashCode());

        System.out.println(original != cloned);

        System.out.println(original.getClass() == cloned.getClass());

        System.out.println(original.equals(cloned));
    }
}