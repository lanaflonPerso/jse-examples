package core.designpattern.creation.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

    // User for pool
    private List<String> empList;

    public Employees() {
        // initialize the pool
        empList = new ArrayList<String>();
    }

    public Employees(List<String> list) {
        this.empList = list;
    }

    public void loadData() {
        empList.add("Himansu");
        empList.add("Siva");
        empList.add("Harish");
        empList.add("Manoj");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Employees clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>();
        for (String s : this.getEmpList()) {
            temp.add(s);
        }
        return new Employees(temp);
    }

}