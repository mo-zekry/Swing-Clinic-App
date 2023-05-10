package clinic.code;

import javax.swing.*;

import helpers.CustomBorder;
import org.intellij.lang.annotations.JdkConstants;
import org.kordamp.ikonli.elusive.Elusive;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {

    JPanel headerPanel;

    JPanel sideBar;
    private JPanel menuPanel;
    private JButton homeBtn;
    private JButton departmentBtn;
    private JButton doctorsBtn;
    private JButton blogBtn;
    private JButton aboutBtn;
    private JButton contactBtn;
    private JPanel settingsPanel;

    public MyFrame() {

        super("Clinic-Appointment");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1200, 750));
        this.setLayout(new BorderLayout());
//        this.setResizable(false);

        // this.setUndecorated(true);

        this.setLocationRelativeTo(null);

        sideBar = new JPanel();
        //========================================
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(80, 50));
        JLabel expandBtn = new JLabel();
        FontIcon menuIcon = FontIcon.of(MaterialDesign.MDI_MENU);
        menuIcon.setIconSize(40);
        menuIcon.setIconColor(new Color(255, 255, 255));
        expandBtn.setHorizontalAlignment(SwingConstants.CENTER);
        expandBtn.setFocusable(false);
        expandBtn.setIcon(menuIcon);
        expandBtn.setPreferredSize(new Dimension(50, 35));
        expandBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerPanel.add(expandBtn, BorderLayout.WEST);
        //===================================
        this.add(headerPanel, BorderLayout.NORTH);

        sideBar.setPreferredSize(new Dimension(300, 600));
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        menuPanel = new JPanel();
//        sideBar.setBorder(new CustomBorder(1, Color.WHITE, false, false, false, true, false));
        menuPanel.setLayout(new GridLayout(6, 1, 0, 0));

        homeBtn = new JButton("Home");
        homeBtn.setFont(new Font("", Font.PLAIN, 18));
//        homeBtn.setBorder(null);
//        homeBtn.setMargin(null);
        departmentBtn = new JButton("Department");
        departmentBtn.setFont(new Font("", Font.PLAIN, 18));
//        departmentBtn.setBorder(null);
//        departmentBtn.setMargin(null);
        doctorsBtn = new JButton("Doctors");
        doctorsBtn.setFont(new Font("", Font.PLAIN, 18));
//        doctorsBtn.setBorder(null);
//        doctorsBtn.setMargin(null);
        blogBtn = new JButton("Blog");
        blogBtn.setFont(new Font("", Font.PLAIN, 18));
//        blogBtn.setBorder(null);
//        blogBtn.setMargin(null);
        aboutBtn = new JButton("About");
        aboutBtn.setFont(new Font("", Font.PLAIN, 18));
//        aboutBtn.setBorder(null);
//        aboutBtn.setMargin(null);
        contactBtn = new JButton("Contact");
        contactBtn.setFont(new Font("", Font.PLAIN, 18));
//        contactBtn.setBorder(null);
//        contactBtn.setMargin(null);
        expandBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (homeBtn.getText() == "Home") {
                    homeBtn.setText("");
                    FontIcon homeIcon = FontIcon.of(MaterialDesign.MDI_HOME, 40, new Color(198, 215, 231));
                    homeBtn.setIcon(homeIcon);

                    aboutBtn.setText("");
                    FontIcon aboutIcon = FontIcon.of(MaterialDesign.MDI_INFORMATION, 40, new Color(198, 215, 231));
                    aboutBtn.setIcon(aboutIcon);

                    doctorsBtn.setText("");
                    FontIcon doctorIcon = FontIcon.of(Elusive.GROUP, 40, new Color(198, 215, 231));
                    doctorsBtn.setIcon(doctorIcon);

                    departmentBtn.setText("");
                    FontIcon departmentIcon = FontIcon.of(Elusive.TH, 40, new Color(198, 215, 231));
                    departmentBtn.setIcon(departmentIcon);

                    blogBtn.setText("");
                    FontIcon blogIcon = FontIcon.of(Elusive.BLOGGER, 40, new Color(198, 215, 231));
                    blogBtn.setIcon(blogIcon);

                    contactBtn.setText("");
                    FontIcon contactIcon = FontIcon.of(MaterialDesign.MDI_CONTACT_MAIL, 40, new Color(198, 215, 231));
                    contactBtn.setIcon(contactIcon);

                    sideBar.setPreferredSize(new Dimension(70, 600));


                } else {
                    homeBtn.setText("Home");
                    homeBtn.setIcon(null);

                    aboutBtn.setText("About");
                    aboutBtn.setIcon(null);

                    departmentBtn.setText("Department");
                    departmentBtn.setIcon(null);

                    doctorsBtn.setText("Doctors");
                    doctorsBtn.setIcon(null);

                    contactBtn.setText("Contact");
                    contactBtn.setIcon(null);

                    blogBtn.setText("Blog");
                    blogBtn.setIcon(null);

                    sideBar.setPreferredSize(new Dimension(300, 600));

                }

            }
        });

        menuPanel.add(homeBtn);
        menuPanel.add(aboutBtn);
        menuPanel.add(departmentBtn);
        menuPanel.add(doctorsBtn);
        menuPanel.add(blogBtn);
        menuPanel.add(contactBtn);
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
        ContactPanel contactPanel = new ContactPanel(this);

        contentPanel.add(homePanel);
        contentPanel.add(departmentPanel);
        contentPanel.add(doctorsPanel);
        contentPanel.add(blogPanel);
        contentPanel.add(aboutPanel);
        contentPanel.add(contactPanel);

        this.add(sideBar, BorderLayout.WEST);
        this.add(contentPanel, BorderLayout.CENTER);

        homeBtn.addMouseListener(new MouseAdapter() {
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
        departmentBtn.addMouseListener(new MouseAdapter() {
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
        doctorsBtn.addMouseListener(new MouseAdapter() {
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
        blogBtn.addMouseListener(new MouseAdapter() {
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
        aboutBtn.addMouseListener(new MouseAdapter() {
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
        contactBtn.addMouseListener(new MouseAdapter() {
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
