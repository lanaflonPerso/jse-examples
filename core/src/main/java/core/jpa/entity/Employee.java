package core.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GEN_ID")
    private Long genID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Override
    public Long getGenID() {
        return genID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Todo [name=" + name + ", address=" + address + "]";
    }

}