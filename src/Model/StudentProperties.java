package Model;

public class StudentProperties {
    protected String id;
    protected String name;
    protected String major;
    protected String department;
    protected String enrollYear;


    // ID: GETTER/SETTER
    public void setId(String _id) {
        id = _id;
    }
    public String getId() {
        return id;
    }


    // NAME: GETTER/SETTER
    public void setName(String _name) {
        name = _name;
    }
    public String getName() {
        return name;
    }


    // MAJOR: GETTER/SETTER
    public void setMajor(String _major) {
        major = _major;
    }
    public String getMajor() {
        return major;
    }


    // DEPARTMENT: GETTER/SETTER
    public void setDepartment(String _department) {
        department = _department;
    }
    public String getDepartment() {
        return department;
    }


    // ENROLL YEAR: GETTER/SETTER
    public void setEnrollYear(String _enrollYear) {
        enrollYear = _enrollYear;
    }
    public String getEnrollYear() {
        return enrollYear;
    }
}