package core.sort.comparator.generic;

import java.io.Serializable;
import java.util.Date;

/**
 * Sample Value object
 * 
 */
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Float height;
    private Long salary;
    private String emailId;
    private Date dob;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the height
     */
    public Float getHeight() {
        return height;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(Float height) {
        this.height = height;
    }

    /**
     * @return the salary
     */
    public Long getSalary() {
        return salary;
    }

    /**
     * @param salary
     *            the salary to set
     */
    public void setSalary(Long salary) {
        this.salary = salary;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId
     *            the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob
     *            the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String toString() {
        return "id : " + this.id + " name : " + this.name + " height : " + this.height + " salary : " + this.salary
                + " emailId : " + this.emailId + " dob : " + this.dob + " name : " + this.name;

    }
}