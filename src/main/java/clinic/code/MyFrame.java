package clinic.code;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
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
    private JButton settingsBtn;

    private JPanel contentPanel;

    public MyFrame() {
        super("Clinic-Appointment");
        initComponent();
    }


    private void initComponent() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1300, 750));
        this.setLayout(new BorderLayout());

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
        expandBtn.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));
        expandBtn.setFocusable(false);
        expandBtn.setIcon(menuIcon);
        expandBtn.setPreferredSize(new Dimension(50, 35));
        expandBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerPanel.add(expandBtn, BorderLayout.WEST);
        //===================================
        this.getContentPane().add(headerPanel, BorderLayout.NORTH);

        sideBar.setPreferredSize(new Dimension(70, 600));
        sideBar.setLayout(new BorderLayout());
        sideBar.setBackground(new Color(38, 55, 56));
        menuPanel = new JPanel();
        menuPanel.setLayout(new MigLayout(" fillx, align center,aligny top "));

        homeBtn = new JButton();
        homeBtn.setFont(new Font("", Font.PLAIN, 18));

        departmentBtn = new JButton();
        departmentBtn.setFont(new Font("", Font.PLAIN, 18));

        doctorsBtn = new JButton();
        doctorsBtn.setFont(new Font("", Font.PLAIN, 18));

        blogBtn = new JButton();
        blogBtn.setFont(new Font("", Font.PLAIN, 18));

        aboutBtn = new JButton();
        aboutBtn.setFont(new Font("", Font.PLAIN, 18));

        contactBtn = new JButton();
        contactBtn.setFont(new Font("", Font.PLAIN, 18));

        settingsPanel = new JPanel(new MigLayout(" fillx, align center"));
        settingsPanel.setPreferredSize(new Dimension(50, 20));
        settingsBtn = new JButton();
        settingsBtn.setFont(new Font("", Font.PLAIN, 18));
        settingsPanel.setPreferredSize(new Dimension(300, 100));
        settingsPanel.add(settingsBtn, "grow, hmax 50, hmin 50");
        sideBar.add(settingsPanel, BorderLayout.SOUTH);

        iconSidebar();

        expandBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (homeBtn.getText() == "") {
                    btnSideBar();
                } else {
                    iconSidebar();
                }

            }
        });

        menuPanel.add(homeBtn, "wrap, grow, align center, hmax 70, hmin 50");
        menuPanel.add(aboutBtn, "wrap, grow, align center, hmax 70, hmin 50");
        menuPanel.add(departmentBtn, "wrap, grow, align center, hmax 70, hmin 50");
        menuPanel.add(doctorsBtn, "wrap, grow, align center, hmax 70, hmin 50");
        menuPanel.add(blogBtn, "wrap, grow, align center, hmax 70, hmin 50");
        menuPanel.add(contactBtn, "wrap, grow, align center, hmax 70, hmin 50");
        sideBar.add(menuPanel, BorderLayout.CENTER);

        // ============================================================================
        contentPanel = new JPanel(new CardLayout());

        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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

        this.getContentPane().add(sideBar, BorderLayout.WEST);
        this.getContentPane().add(contentPanel, BorderLayout.CENTER);

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

        this.setVisible(true);
    }


    private void iconSidebar() {
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

        FontIcon settingsIcon = FontIcon.of(MaterialDesign.MDI_SETTINGS, 40, new Color(198, 215, 231));
        settingsBtn.setText("");
        settingsBtn.setIcon(settingsIcon);

        sideBar.setPreferredSize(new Dimension(70, 600));

    }

    private void btnSideBar() {
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

        settingsBtn.setText("Settings");
        settingsBtn.setIcon(null);

        sideBar.setPreferredSize(new Dimension(300, 600));
    }

}
