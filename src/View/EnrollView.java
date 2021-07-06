package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollView extends JPanel {
    // Colors
    Color bgMain = new Color(36, 36, 36);
    Color labelMain = new Color(210, 210, 210);

    // Given Panel for constructor
    protected JPanel windowLayout;
    protected JPanel mainMenu;

    // Panel for layout
    protected JPanel topPanel;
    protected JPanel enrollViewPanel;

    // Components for body layout (enrollView)
    protected JLabel nameLabel;
    protected JLabel majorLabel;
    protected JLabel departmentLabel;
    protected JLabel enrollYearLabel;

    protected JTextField nameInput;
    protected JTextField majorInput;
    protected JTextField departmentInput;
    protected JTextField enrollYearInput;

    // Components for top layout (topPanel)
    protected JButton backButton;

    JButton submitButton;
    public EnrollView(JPanel _windowLayout, JPanel _mainMenu) {
        windowLayout = _windowLayout;
        mainMenu = _mainMenu;

        this.setLayout(new BorderLayout());

        createEnrollViewLayout();
        createEnrollView();
        createBackButton();

        this.add(topPanel, BorderLayout.NORTH);
        this.add(enrollViewPanel, BorderLayout.CENTER);
    }

    public void createEnrollViewLayout() {
        // top panel
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        topPanel.setBackground(bgMain);

        // body panel
        enrollViewPanel = new JPanel(new GridBagLayout());
        enrollViewPanel.setBackground(bgMain);
    }

    public void createBackButton() {
        backButton = new JButton("<");
        backButton.addActionListener(new BackButtonHandler());

        topPanel.add(backButton);
    }

    public void createEnrollView() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 0, 4, 4);

        nameLabel = new JLabel("Name: ");
        nameLabel.setForeground(labelMain);
        nameInput = new JTextField(16);
        gbc.gridx = 0;
        gbc.gridy = 0;
        enrollViewPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        enrollViewPanel.add(nameInput, gbc);

        majorLabel = new JLabel("Major: ");
        majorLabel.setForeground(labelMain);
        majorInput = new JTextField(16);
        gbc.gridx = 0;
        gbc.gridy = 1;
        enrollViewPanel.add(majorLabel, gbc);
        gbc.gridx = 1;
        enrollViewPanel.add(majorInput, gbc);

        departmentLabel = new JLabel("Department: ");
        departmentLabel.setForeground(labelMain);
        departmentLabel.setHorizontalAlignment(JLabel.RIGHT);
        departmentInput = new JTextField(16);
        gbc.gridx = 0;
        gbc.gridy = 2;
        enrollViewPanel.add(departmentLabel, gbc);
        gbc.gridx = 1;
        enrollViewPanel.add(departmentInput, gbc);

        enrollYearLabel = new JLabel("Enroll Year: ");
        enrollYearLabel.setForeground(labelMain);
        enrollYearInput = new JTextField(16);
        gbc.gridx = 0;
        gbc.gridy = 3;
        enrollViewPanel.add(enrollYearLabel, gbc);
        gbc.gridx = 1;
        enrollViewPanel.add(enrollYearInput, gbc);

        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        enrollViewPanel.add(submitButton, gbc);
    }

    public void enrollStudentHandler(ActionListener _enrollStudentHandler) {
        submitButton.addActionListener(_enrollStudentHandler);
    }

    public String getName() {
        return nameInput.getText();
    }

    public String getMajor() {
        return majorInput.getText();
    }

    public String getDepartment() {
        return departmentInput.getText();
    }

    public String getEnrollYear() {
        return enrollYearInput.getText();
    }

    // Actions

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
