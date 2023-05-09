package clinic.code;

import javax.swing.*;

import helpers.CustomBorder;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {

    JPanel headerPanel;

    JPanel sideBar;
    private JPanel menuPanel;
    private JButton homeButton;
    private JButton departmentButton;
    private JButton doctorsButton;
    private JButton blogButton;
    private JButton aboutButton;
    private JButton contactButton;
    private JPanel settingsPanel;

    public MyFrame() {

        super("Clinic-Appointment");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 700));
        this.setLayout(new BorderLayout());
//        this.setResizable(false);

        // this.setUndecorated(true);

        this.setLocationRelativeTo(null);

        sideBar = new JPanel();

        //========================================
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(80, 50));
        JLabel closeButton = new JLabel();
        FontIcon menuIcon = FontIcon.of(MaterialDesign.MDI_MENU);
        menuIcon.setIconSize(40);
        menuIcon.setIconColor(new Color(255, 255, 255));
        closeButton.setHorizontalAlignment(SwingConstants.CENTER);
        closeButton.setFocusable(false);
        closeButton.setIcon(menuIcon);
        closeButton.setPreferredSize(new Dimension(50, 35));
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (sideBar.isVisible()) {
                    sideBar.setVisible(false);
                } else {
                    sideBar.setVisible(true);
                }

            }
        });
//        closeButton.addActionListener(e -> {
//        });
        headerPanel.add(closeButton, BorderLayout.WEST);
        //===================================
        this.add(headerPanel, BorderLayout.NORTH);

        sideBar.setPreferredSize(new Dimension(300, 600));
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        menuPanel = new JPanel();
        sideBar.setBorder(new CustomBorder(1, Color.WHITE, false, false, false, true, false));
        menuPanel.setLayout(new GridLayout(6, 1, 0, 0));

        homeButton = new JButton("Home");
        departmentButton = new JButton("Department");
        doctorsButton = new JButton("Doctors");
        blogButton = new JButton("Blog");
        aboutButton = new JButton("About");
        contactButton = new JButton("Contact");

        menuPanel.add(homeButton);
        menuPanel.add(aboutButton);
        menuPanel.add(departmentButton);
        menuPanel.add(doctorsButton);
        menuPanel.add(blogButton);
        menuPanel.add(contactButton);
        sideBar.add(menuPanel);

        settingsPanel = new JPanel();
        settingsPanel.setPreferredSize(new Dimension(300, 20));

        sideBar.add(settingsPanel);

        // ============================================================================
        JPanel contentPanel = new JPanel(new CardLayout());
        HomePanel homePanel = new HomePanel(this);
        DepartmentPanel departmentPanel = new DepartmentPanel(this);
        DoctorsPanel doctorsPanel = new DoctorsPanel(this);
        BlogPanel blogPanel = new BlogPanel();
        AboutPanel aboutPanel = new AboutPanel(this);
        ContactPanel contactPanel = new ContactPanel();

        contentPanel.add(homePanel);
        contentPanel.add(departmentPanel);
        contentPanel.add(doctorsPanel);
        contentPanel.add(blogPanel);
        contentPanel.add(aboutPanel);
        contentPanel.add(contactPanel);

        this.add(sideBar, BorderLayout.WEST);
        this.add(contentPanel, BorderLayout.CENTER);

        homeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePanel.setVisible(true);
                departmentPanel.setVisible(false);
                doctorsPanel.setVisible(false);
                blogPanel.setVisible(false);
                aboutPanel.setVisible(false);
                contactPanel.setVisible(false);
            }
        });
        departmentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePanel.setVisible(false);
                departmentPanel.setVisible(true);
                doctorsPanel.setVisible(false);
                blogPanel.setVisible(false);
                aboutPanel.setVisible(false);
                contactPanel.setVisible(false);
            }
        });
        doctorsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePanel.setVisible(false);
                departmentPanel.setVisible(false);
                doctorsPanel.setVisible(true);
                blogPanel.setVisible(false);
                aboutPanel.setVisible(false);
                contactPanel.setVisible(false);
            }
        });
        blogButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePanel.setVisible(false);
                departmentPanel.setVisible(false);
                doctorsPanel.setVisible(false);
                blogPanel.setVisible(true);
                aboutPanel.setVisible(false);
                contactPanel.setVisible(false);
            }
        });
        aboutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePanel.setVisible(false);
                departmentPanel.setVisible(false);
                doctorsPanel.setVisible(false);
                blogPanel.setVisible(false);
                aboutPanel.setVisible(true);
                contactPanel.setVisible(false);
            }
        });
        contactButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePanel.setVisible(false);
                departmentPanel.setVisible(false);
                doctorsPanel.setVisible(false);
                blogPanel.setVisible(false);
                aboutPanel.setVisible(false);
                contactPanel.setVisible(true);
            }
        });
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        this.pack();
        this.setVisible(true);
    }


}
