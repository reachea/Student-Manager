package Controller;

import Model.StudentInfo;
import View.EnrollView;
import View.SearchView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentController {
    StudentInfo studentInfo;
    EnrollView enrollView;
    SearchView searchView;

    public StudentController(StudentInfo _studentInfo, EnrollView _enrollView, SearchView _searchView) {
        studentInfo = _studentInfo;
        enrollView = _enrollView;
        searchView = _searchView;

        enrollView.enrollStudentHandler(new EnrollStudent());
        searchView.getStudentInfo(studentInfo.getStudentList());
    }

    public void enrollStudent() {
        String name = enrollView.getName();
        String major = enrollView.getMajor();
        String department = enrollView.getDepartment();
        String enrollYear = enrollView.getEnrollYear();

        studentInfo.addStudent(name, major, department, enrollYear);

        searchView.getStudentInfo(studentInfo.getStudentList());
        searchView.createStudentListTable();

        JOptionPane.showMessageDialog(enrollView, "Enroll Successfully!");
    }

    class EnrollStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                enrollStudent();
            } catch (NumberFormatException ex) {
                getErrorMessage("Something wrong with input!");
            }
        }
    }

    public void getErrorMessage(String message) {
        JOptionPane.showMessageDialog(enrollView, message);
    }
}
