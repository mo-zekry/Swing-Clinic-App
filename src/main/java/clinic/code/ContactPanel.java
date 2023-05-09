package clinic.code;

import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

public class ContactPanel extends JPanel {
    JFrame frame;

    public ContactPanel(JFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        JPanel contactWays = new JPanel(new FlowLayout());
        contactWays.setPreferredSize(new Dimension(500, 210));

        FontIcon icon = FontIcon.of(MaterialDesign.MDI_MAP_MARKER);
        contactWays.add(createCard(icon, "ADDRESS", "198 West 21th Street, Suite 721 New York NY 10016"));

        icon = FontIcon.of(MaterialDesign.MDI_PHONE);
        contactWays.add(createCard(icon, "CONTACT NUMBER", "+ 1235 2355 98"));

        icon = FontIcon.of(MaterialDesign.MDI_EMAIL);
        contactWays.add(createCard(icon, "Email Address", "info@yoursite.com"));

        icon = FontIcon.of(MaterialDesign.MDI_WEB);
        contactWays.add(createCard(icon, "WEBSITE", "info@yoursite.com"));

        //=====================================================

        add(contactWays, BorderLayout.NORTH);
    }

    private JPanel createCard(FontIcon icon, String name, String description) {
        JPanel card = new JPanel(new BorderLayout());
//        card.setBackground(Color.white);
        card.setBackground(new Color(59, 63, 79));
        card.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        card.setPreferredSize(new Dimension(300, 100));

        // Panel for the rounded icon
        JPanel iconPanel = new JPanel(new BorderLayout());
//        iconPanel.setBackground(new Color(240, 240, 240));
        iconPanel.setBackground(new Color(78, 83, 98));
        iconPanel.setPreferredSize(new Dimension(70, 70));
        iconPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        icon.setIconSize(35);
        icon.setIconColor(new Color(255, 255, 255));
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setFont(iconLabel.getFont().deriveFont(40f));
        iconPanel.add(iconLabel, BorderLayout.CENTER);

        // Panel for the contact name
        JPanel namePanel = new JPanel();
//        namePanel.setBackground(Color.white);
        namePanel.setBackground(new Color(59, 63, 79));
        JLabel nameLabel = new JLabel(name);
//        nameLabel.setForeground(new Color(0, 0, 0));
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 18f));
        namePanel.add(nameLabel);

        // Panel for the description
        JPanel descriptionPanel = new JPanel(new BorderLayout());
//        descriptionPanel.setBackground(Color.white);
        descriptionPanel.setBackground(new Color(59, 63, 79));
        JTextArea descriptionArea = new JTextArea(description);
//        descriptionArea.setForeground(new Color(0, 0, 0));
        descriptionArea.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 14f));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));
        descriptionPanel.add(descriptionArea, BorderLayout.CENTER);

        // Add the panels to the card
        card.add(iconPanel, BorderLayout.WEST);
        card.add(namePanel, BorderLayout.NORTH);
        card.add(descriptionPanel, BorderLayout.CENTER);

        return card;
    }

}
