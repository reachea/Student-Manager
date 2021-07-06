package com.company;

import javax.swing.*;

public class StudentManager {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();

        mainWindow.setSize(1024, 768);
        mainWindow.setTitle("ITE Management");
        mainWindow.setLocation(200, 0);
        mainWindow.setVisible(true);

        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
