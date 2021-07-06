package View;

import Model.StudentInfo;
import Model.StudentProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchView extends JPanel {
    // Colors
    Color bgMain = new Color(36, 36, 36);
    Color labelMain = new Color(210, 210, 210);

    // Given Panel for Layout
    JPanel windowLayout;
    JPanel mainMenu;

    // Search View Layout
    JPanel topPanel;
    JPanel searchView;
    JPanel searchTopPanel;
    JPanel searchBottomPanel;

    // Components for body layout (searchView)
    GridBagConstraints gbc = new GridBagConstraints();

    // Components for top layout
    JButton backButton;

    // Student Model Data
    ArrayList<StudentProperties> studentList;

    public SearchView(JPanel _windowLayout, JPanel _mainMenu, ArrayList<StudentProperties> _studentList) {
        windowLayout = _windowLayout;
        mainMenu = _mainMenu;

        studentList = _studentList;

        createSearchViewLayout();
        createBackButton();
        createSearchView();

        this.setLayout(new BorderLayout());

        this.add(topPanel, BorderLayout.NORTH);
        this.add(searchView, BorderLayout.CENTER);
    }

    public void createBackButton() {
        backButton = new JButton("<");
        backButton.addActionListener(new BackButtonHandler());

        topPanel.add(backButton);
    }

    public void createSearchViewLayout() {
        // Top Panel Layout
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        topPanel.setBackground(bgMain);

        // Body Panel Layout
        searchView = new JPanel(new BorderLayout());

        searchTopPanel = new JPanel(new GridBagLayout());
        searchTopPanel.setBackground(bgMain);
        searchBottomPanel = new JPanel(new GridBagLayout());
        searchBottomPanel.setBackground(bgMain);
        searchView.add(searchTopPanel, BorderLayout.NORTH);
        searchView.add(searchBottomPanel, BorderLayout.CENTER);
    }

    public void createSearchView() {
        gbc.gridy = 0;
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 0;
        JLabel idLabel = new JLabel("id");
        idLabel.setForeground(labelMain);
        searchTopPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        JLabel nameLabel = new JLabel("name");
        nameLabel.setForeground(labelMain);
        searchTopPanel.add(nameLabel, gbc);

        gbc.gridx = 2;
        JLabel majorLabel = new JLabel("Major");
        majorLabel.setForeground(labelMain);
        searchTopPanel.add(majorLabel, gbc);

        gbc.gridx = 3;
        JLabel departmentLabel = new JLabel("department");
        departmentLabel.setForeground(labelMain);
        searchTopPanel.add(departmentLabel, gbc);

        gbc.gridx = 4;
        JLabel enrollYearLabel = new JLabel("Enroll Year");
        enrollYearLabel.setForeground(labelMain);
        searchTopPanel.add(enrollYearLabel, gbc);

        createStudentListTable();
    }

    public void createStudentListTable() {
        searchBottomPanel.removeAll();

        gbc.insets = new Insets(0, 4, 4, 4);

        if (studentList.size() <= 0) {
            return;
        }

        for (int i = 0; i < studentList.size(); i++) {
            gbc.gridy = i;

            gbc.gridx = 0;
            JLabel idLabel = new JLabel(studentList.get(i).getId());
            idLabel.setForeground(labelMain);
            searchBottomPanel.add(idLabel, gbc);

            gbc.gridx = 1;
            JLabel nameLabel = new JLabel(studentList.get(i).getName());
            nameLabel.setForeground(labelMain);
            searchBottomPanel.add(nameLabel, gbc);

            gbc.gridx = 2;
            JLabel majorLabel = new JLabel(studentList.get(i).getMajor());
            majorLabel.setForeground(labelMain);
            searchBottomPanel.add(majorLabel, gbc);

            gbc.gridx = 3;
            JLabel departmentLabel = new JLabel(studentList.get(i).getDepartment());
            departmentLabel.setForeground(labelMain);
            searchBottomPanel.add(departmentLabel, gbc);

            gbc.gridx = 4;
            JLabel enrollYearLabel = new JLabel(studentList.get(i).getEnrollYear());
            enrollYearLabel.setForeground(labelMain);
            searchBottomPanel.add(enrollYearLabel, gbc);
        }

        searchView.revalidate();
        searchView.repaint();
    }

    public void getStudentInfo(ArrayList<StudentProperties> _studentInfo) {
        studentList = _studentInfo;
    }

    class BackButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            windowLayout.removeAll();
            windowLayout.add(mainMenu, BorderLayout.CENTER);
            windowLayout.revalidate();
            windowLayout.repaint();
        }
    }
}
