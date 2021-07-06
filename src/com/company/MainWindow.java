package com.company;
import Controller.StudentController;
import Model.StudentInfo;
import View.DeleteView;
import View.EnrollView;
import View.SearchView;
import View.UpdateView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    protected EnrollView enrollView;
    protected SearchView searchView;
    protected UpdateView updateView = new UpdateView();
    protected DeleteView deleteView = new DeleteView();

    protected StudentInfo studentInfo = new StudentInfo();
    protected StudentController studentController;

    protected JPanel windowLayout;
    protected JPanel mainMenu;

    protected JButton enrollButton;
    protected JButton searchButton;
    protected JButton deleteButton;
    protected JButton updateButton;

    public MainWindow() {
        createLayout();

        enrollView = new EnrollView(windowLayout, mainMenu);
        searchView = new SearchView(windowLayout, mainMenu, studentInfo.getStudentList());

        studentController = new StudentController(this.studentInfo, this.enrollView, this.searchView);

        this.getContentPane().setBackground(new Color(36, 36, 36));

        this.add(windowLayout);
    }

    public void createLayout() {
        windowLayout = new JPanel();

        windowLayout.setLayout(new BorderLayout());

        createMainMenu();

        windowLayout.add(mainMenu, BorderLayout.CENTER);
    }

    public void createMainMenu() {
        enrollButton = new JButton();
        enrollButton.setText("Enroll");
        enrollButton.setPreferredSize(new Dimension(150, 40));
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowLayout.remove(mainMenu);
                windowLayout.add(enrollView, BorderLayout.CENTER);
                windowLayout.revalidate();
                windowLayout.repaint();
            }
        });

        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setPreferredSize(new Dimension(150, 40));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowLayout.remove(mainMenu);
                windowLayout.add(searchView, BorderLayout.CENTER);
                windowLayout.revalidate();
                windowLayout.repaint();
            }
        });

        deleteButton = new JButton();
        deleteButton.setText("Delete");
        deleteButton.setPreferredSize(new Dimension(150, 40));

        updateButton = new JButton();
        updateButton.setText("Update");
        updateButton.setPreferredSize(new Dimension(150, 40));

        mainMenu = new JPanel();
        mainMenu.setLayout(new GridBagLayout());
        mainMenu.setBackground(new Color(36, 36, 36));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 0, 4, 0);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainMenu.add(enrollButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainMenu.add(searchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainMenu.add(deleteButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainMenu.add(updateButton, gbc);
    }
}
