package clinic.code;

import helpers.PaintImage;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The AboutPanel class represents a Swing panel that displays information about the clinic and showcases a gallery of images.
 * The panel consists of a description section with formatted text, providing details about the clinic's services and features.
 * It also includes a gallery section with six images displayed in a two-column layout.
 * The panel offers scrolling functionality to navigate through the gallery.
 * At the bottom, there is a button panel containing options to make an appointment and contact the clinic.
 * Overall, the AboutPanel provides an engaging and informative view of the clinic's information and visual content.
 */
public class AboutPanel extends JPanel {

    private JFrame frame;

    public AboutPanel(JFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        // Description Panel
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel descriptionLabel = new JLabel("About Us And Clinic Gallery");
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setFont(new Font("", Font.PLAIN, 30));
        JTextPane description = new JTextPane();
        description.setContentType("text/html");
        description.setText("<html><body style='text-align: center; font-size: 15'>" + getDescriptionText() + "</body></html>");
        description.setEditable(false);

        descriptionPanel.add(descriptionLabel, BorderLayout.NORTH);
        descriptionPanel.add(new JScrollPane(description), BorderLayout.CENTER);
        add(descriptionPanel, BorderLayout.NORTH);

        // Gallery Panel
        JPanel gallery = new JPanel(new MigLayout("wrap 2")); // Set layout with 2 columns

        PaintImage image_1 = new PaintImage(new ImageIcon("src/main/resources/img/about_image_1.jpg").getImage());
        PaintImage image_2 = new PaintImage(new ImageIcon("src/main/resources/img/about_image_2.jpg").getImage());
        PaintImage image_3 = new PaintImage(new ImageIcon("src/main/resources/img/about_image_3.jpg").getImage());
        PaintImage image_4 = new PaintImage(new ImageIcon("src/main/resources/img/about_image_4.jpg").getImage());
        PaintImage image_5 = new PaintImage(new ImageIcon("src/main/resources/img/about_image_5.jpg").getImage());
        PaintImage image_6 = new PaintImage(new ImageIcon("src/main/resources/img/about_image_6.jpg").getImage());

        gallery.add(image_1, "span 1 2, grow, push, hmin 600");
        gallery.add(image_2, "grow, push, hmin 300");
        gallery.add(image_3, "grow, push, hmin 300");
        gallery.add(image_5, "grow, push, hmin 300");
        gallery.add(image_4, "span 1 2, grow, push, hmin 600");
        gallery.add(image_6, "grow, push, hmin 300");

        JScrollPane galleryScroll = new JScrollPane(gallery);
        JScrollBar verticalScrollBar = galleryScroll.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setBlockIncrement(100);
        add(galleryScroll, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.setPreferredSize(new Dimension(300, 50));
        JButton appointmentButton = new JButton("Make an Appointment");
        appointmentButton.setPreferredSize(new Dimension(300, 40));
        JButton contactButton = new JButton("Contact Us");
        contactButton.setPreferredSize(new Dimension(300, 40));
        buttonsPanel.add(appointmentButton);
        buttonsPanel.add(contactButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private String getDescriptionText() {
        return """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a lectus fermentum venenatis sapien a, dignissim magna. Morbi nec turpis felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed et ex euismod, malesuada tortor et, tincidunt nulla. Aenean et placerat leo, non suscipit massa. Nullam in dolor gravida, venenatis enim et, cursus turpis. Integer cursus scelerisque dui, eget cursus tellus tincidunt nec.
                """;
    }
}
