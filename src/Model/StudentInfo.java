package Model;

import java.util.ArrayList;

public class StudentInfo {
    protected ArrayList<StudentProperties> studentList = new ArrayList<StudentProperties>();
    private int tail = 0;

    public void addStudent(String _name, String _major, String _department, String _enrollYear) {
        StudentProperties studentProperties = new StudentProperties();
        studentProperties.setId(Integer.toString(tail));
        studentProperties.setName(_name);
        studentProperties.setMajor(_major);
        studentProperties.setDepartment(_department);
        studentProperties.setEnrollYear(_enrollYear);

        studentList.add(studentProperties);
        tail += 1;
    }

    public ArrayList<StudentProperties> getStudentList() {
        return studentList;
    }
}