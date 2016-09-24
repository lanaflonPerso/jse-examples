package core.designpattern.creation.prototype;

import java.util.List;

public class PrototypeMain {

    public static void main(String...args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        Employees employee = emps.clone();
        Employees employee2 = emps.clone();
        List<String> list = employee.getEmpList();
        list.add("Nayak");
        List<String> list1 = employee2.getEmpList();
        list1.remove("Siva");

        System.out.println("emps List: " + emps.getEmpList());
        System.out.println("empsNew List: " + list);
        System.out.println("empsNew1 List: " + list1);
    }

}