package clinic.code;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import org.kordamp.ikonli.elusive.Elusive;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

/**
 * The MyFrame class represents the main frame of the Clinic Appointment application.
 * It extends the JFrame class and provides the user interface for the application.
 * The frame consists of a header panel, a sidebar, and a content panel.
 * It also includes buttons for navigating to different sections of the application, such as home, department, doctors, blog, about, and contact.
 * Additionally, there is a settings button for accessing the application's settings.
 * The content panel displays different panels based on the selected navigation button.
 * The class provides methods for configuring the visibility of panels and setting up the frame components.
 * Overall, the MyFrame class serves as the central component for the Clinic Appointment application's user interface.
 */
public class MyFrame extends JFrame {

    // Panels
    private JPanel headerPanel;
    private JPanel sideBar;
    private JPanel menuPanel;
    private HomePanel homePanel = new HomePanel(this);
    private DepartmentPanel departmentPanel = new DepartmentPanel(this);
    private DoctorsPanel doctorsPanel = new DoctorsPanel(this);
    private BlogPanel blogPanel = new BlogPanel();
    private AboutPanel aboutPanel = new AboutPanel(this);
    private ContactPanel contactPanel = new ContactPanel(this);
    private Developers developersPanel = new Developers(this);

    // Buttons
    private JButton homeBtn;
    private JButton departmentBtn;
    private JButton doctorsBtn;
    private JButton blogBtn;
    private JButton aboutBtn;
    private JButton contactBtn;
    private JPanel settingsPanel;
    private JButton settingsBtn;

    // Content Panel
    private JPanel contentPanel;

    /**
     * Constructs a new instance of MyFrame.
     * It initializes the components and sets up the frame.
     */
    public MyFrame() {
        super("Clinic-Appointment");
        initComponent();
    }

    /**
     * Initializes the components and sets up the frame.
     */
    private void initComponent() {
        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1300, 750));
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Header Panel
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(80, 50));
        // ...

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

        getContentPane().add(headerPanel, BorderLayout.NORTH);

        // Sidebar Panel
        sideBar = new JPanel();
        sideBar.setPreferredSize(new Dimension(70, 600));
        sideBar.setLayout(new BorderLayout());
        sideBar.setBackground(new Color(38, 55, 56));
        // ...

        // Menu panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new MigLayout("fillx, align center, aligny top "));
        // ...

        // Buttons and settings panel
        homeBtn = new JButton();
        departmentBtn = new JButton();
        doctorsBtn = new JButton();
        blogBtn = new JButton();
        aboutBtn = new JButton();
        contactBtn = new JButton();
        settingsPanel = new JPanel(new MigLayout("fillx, align center"));
        // ...
        homeBtn.setFont(new Font("", Font.PLAIN, 18));
        departmentBtn.setFont(new Font("", Font.PLAIN, 18));
        doctorsBtn.setFont(new Font("", Font.PLAIN, 18));
        blogBtn.setFont(new Font("", Font.PLAIN, 18));
        aboutBtn.setFont(new Font("", Font.PLAIN, 18));
        contactBtn.setFont(new Font("", Font.PLAIN, 18));

        settingsPanel = new JPanel(new MigLayout(" fillx, align center"));
        settingsPanel.setPreferredSize(new Dimension(50, 20));

        settingsBtn = new JButton();
        settingsBtn.setFont(new Font("", Font.PLAIN, 18));
        settingsPanel.setPreferredSize(new Dimension(300, 100));

        settingsPanel.add(settingsBtn, "grow, hmax 50, hmin 50");

        sideBar.add(settingsPanel, BorderLayout.SOUTH);

        iconSidebar(); // default sidebar icon

        expandBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Objects.equals(homeBtn.getText(), "")) {
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


        // Content panel
        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // ...

        contentPanel.add(homePanel);
        contentPanel.add(departmentPanel);
        contentPanel.add(doctorsPanel);
        contentPanel.add(blogPanel);
        contentPanel.add(aboutPanel);
        contentPanel.add(contactPanel);
        contentPanel.add(developersPanel);

        // Add components to the frame
        add(headerPanel, BorderLayout.NORTH);
        add(sideBar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        homeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisibility(true, false, false, false, false, false, false);
            }
        });
        departmentBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisibility(false, true, false, false, false, false, false);
            }
        });
        doctorsBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisibility(false, false, true, false, false, false, false);
            }
        });
        blogBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisibility(false, false, false, true, false, false, false);
            }
        });
        aboutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisibility(false, false, false, false, true, false, false);
            }
        });
        contactBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisibility(false, false, false, false, false, true, false);
            }
        });

        settingsBtn.addActionListener(e -> {
            setVisibility(false, false, false, false, false, false, true);
        });

        // ...

        // Make the frame visible
        this.setVisible(true);
    }

    /**
     * Configures the sidebar icons.
     */
    private void iconSidebar() {
        homeBtn.setText(""); // remove the text
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

    /**
     * Configures the sidebar buttons as text buttons.
     */
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

    /**
     * Sets the visibility of the panels based on the provided parameters.
     *
     * @param home       visibility of the home panel
     * @param department visibility of the department panel
     * @param doctors    visibility of the doctors panel
     * @param blog       visibility of the blog panel
     * @param about      visibility of the about panel
     * @param contact    visibility of the contact panel
     * @param developers visibility of the developers panel
     */
    private void setVisibility(boolean home, boolean department, boolean doctors, boolean blog, boolean about, boolean contact, boolean developers) {

        homePanel.setVisible(home);
        departmentPanel.setVisible(department);
        doctorsPanel.setVisible(doctors);
        blogPanel.setVisible(blog);
        aboutPanel.setVisible(about);
        contactPanel.setVisible(contact);
        developersPanel.setVisible(developers);
    }
}
