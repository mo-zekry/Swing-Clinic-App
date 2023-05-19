package clinic.code;

import helpers.ModernButton;
import helpers.PaintImage;
import net.miginfocom.swing.MigLayout;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;


public class DoctorsPanel extends JPanel {

    JFrame frame;

    public DoctorsPanel(JFrame frame) {
        this.frame = frame;

        this.setLayout(new BorderLayout());

        JPanel cardsPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        cardsPanel.add(createCard("Dr. Lloyd Wilson", "NEUROLOGIST",
                "I am an ambitious workaholic, but apart from that, pretty simple pers",
                new ImageIcon("src/main/resources/img/doc_1.jpg")));

        cardsPanel.add(createCard("Dr. Lloyd Wilson", "NEUROLOGIST",
                "I am an ambitious workaholic, but apart from that, pretty simple pers",
                new ImageIcon("src/main/resources/img/doc_2.jpg")));

        cardsPanel.add(createCard("Dr. Lloyd Wilson", "NEUROLOGIST",
                "I am an ambitious workaholic, but apart from that, pretty simple pers",
                new ImageIcon("src/main/resources/img/doc_3.jpg")));

        cardsPanel.add(createCard("Dr. Lloyd Wilson", "NEUROLOGIST",
                "I am an ambitious workaholic, but apart from that, pretty simple pers",
                new ImageIcon("src/main/resources/img/doc_4.jpg")));

        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setBlockIncrement(100);

        this.add(scrollPane, BorderLayout.CENTER);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int columns = width >= 100 ? 3 : 2;
                cardsPanel.setLayout(new GridLayout(0, columns, 5, 5));
                revalidate();
            }
        });
    }

    private JPanel createCard(String doctorName, String department, String description, ImageIcon image) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(300, 500));

        card.setLayout(new MigLayout("fill", "[]", "[grow][][]"));

        JPanel socialIconsImageContainer = new JPanel(new BorderLayout());

        PaintImage doctorImage = new PaintImage(image.getImage());
        doctorImage.setPreferredSize(new Dimension(300, 200)); // Set the desired size for the image

        JPanel socialMediaIconsContainer = new JPanel(new GridLayout(1, 4, 2, 2));
        socialMediaIconsContainer.setBackground(new Color(255, 255, 255));
        socialMediaIconsContainer.setOpaque(true);
        socialMediaIconsContainer.setVisible(false);
        socialMediaIconsContainer.setOpaque(true);

        FontIcon facebookIcon = FontIcon.of(MaterialDesign.MDI_FACEBOOK);
        facebookIcon.setIconColor(new Color(28, 102, 255));
        facebookIcon.setIconSize(30);
        JLabel facebookLabel = new JLabel();
        facebookLabel.setHorizontalAlignment(SwingConstants.CENTER);
        facebookLabel.setIcon(facebookIcon);
        facebookLabel.setPreferredSize(new Dimension(40, 40));
        socialMediaIconsContainer.add(facebookLabel);
        facebookLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        facebookLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                try {
//                    Desktop.getDesktop().browse(URI.create("https://facebook.com/"));
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });

        FontIcon twitter = FontIcon.of(MaterialDesign.MDI_TWITTER_CIRCLE);
        twitter.setIconColor(new Color(28, 102, 255));
        twitter.setIconSize(30);
        JLabel twitterIcon = new JLabel();
        twitterIcon.setHorizontalAlignment(SwingConstants.CENTER);
        twitterIcon.setIcon(twitter);
        twitterIcon.setPreferredSize(new Dimension(40, 40));
        socialMediaIconsContainer.add(twitterIcon);
        twitterIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        twitterIcon.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                try {
//                    Desktop.getDesktop().browse(URI.create("https://twitter.com/"));
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });

        FontIcon instagram = FontIcon.of(MaterialDesign.MDI_INSTAGRAM);
        instagram.setIconColor(new Color(217, 108, 118));
        instagram.setIconSize(30);
        JLabel instagramIcon = new JLabel();
        instagramIcon.setHorizontalAlignment(SwingConstants.CENTER);
        instagramIcon.setIcon(instagram);
        instagramIcon.setPreferredSize(new Dimension(40, 40));
        socialMediaIconsContainer.add(instagramIcon);
        instagramIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        instagramIcon.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                try {
//                    Desktop.getDesktop().browse(URI.create("https://instagram.com/"));
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });

        FontIcon google = FontIcon.of(MaterialDesign.MDI_GOOGLE_PLUS);
        google.setIconColor(new Color(217, 108, 118));
        google.setIconSize(30);
        JLabel googleIcon = new JLabel();
        googleIcon.setHorizontalAlignment(SwingConstants.CENTER);
        googleIcon.setIcon(google);
        googleIcon.setPreferredSize(new Dimension(40, 40));
        socialMediaIconsContainer.add(googleIcon);
        googleIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        googleIcon.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                try {
//                    Desktop.getDesktop().browse(URI.create("https://google.com/"));
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });

        socialIconsImageContainer.add(doctorImage, BorderLayout.CENTER);
        socialIconsImageContainer.add(socialMediaIconsContainer, BorderLayout.SOUTH);

        JPanel nameAndDepartmentContainer = new JPanel(new GridLayout(2, 1, 5, 5));

        JLabel doctorNameLabel = new JLabel("<html><body style='font:15px;'>" + doctorName + "</body></html>");
        JLabel departmentNameLabel = new JLabel(department);

        nameAndDepartmentContainer.add(doctorNameLabel);
        nameAndDepartmentContainer.add(departmentNameLabel);

        JPanel descriptionAndBtnContainer = new JPanel(new GridLayout(2, 1, 5, 5));

        JLabel descriptionLabel = new JLabel("<html><body>" + description + "</body></html>");

        ModernButton bookBtn = new ModernButton("Book Now"); // Update variable name to follow Java naming conventions

        descriptionAndBtnContainer.add(descriptionLabel);
        descriptionAndBtnContainer.add(bookBtn);

        card.add(socialIconsImageContainer, "wrap, growx, growy");
        card.add(nameAndDepartmentContainer, "wrap");
        card.add(descriptionAndBtnContainer);

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Implement mouse hover behavior if needed
                socialMediaIconsContainer.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                socialMediaIconsContainer.setVisible(false);
                // Implement mouse exit behavior if needed
            }
        });


        return card;
    }
}
