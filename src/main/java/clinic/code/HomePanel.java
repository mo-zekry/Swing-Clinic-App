package clinic.code;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import helpers.AppColors;
import helpers.FoldingCube;
import helpers.PaintImage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePanel extends JPanel {
    Image image;
    String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Praesent tincidunt justo sed luctus bibendum." +
            "Praesent tincidunt justo sed luctus bibendum.";

    public HomePanel() {

        setLayout(new BorderLayout());
        setOpaque(true);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        //==========================================
        // Create four cards with service name and description
        JPanel card1 = createCard("Emergency Services",
                lorem,
                new ImageIcon("src/main/resources/img/ambulance.jpg"));
        JPanel card2 = createCard("Outdoors Checkup", lorem,
                new ImageIcon("src/main/resources/img/home_background.jpg"));
        JPanel card3 = createCard("24 Hours Service", lorem,
                new ImageIcon("src/main/resources/img/xdoc-3.jpg.pagespeed.ic.ssPmw2cMao.jpg"));
        JPanel card4 = createCard("Qualified Doctors", lorem,
                new ImageIcon("src/main/resources/img/ximage_5.jpg.pagespeed.ic.IaTxArRsR-.jpg"));

        // Add the cards to the HomePanel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        JLabel label = new JLabel("Welcome To Mideplus");
        label.setFont(new Font("Gotham", Font.BOLD, 25));
        welcomePanel.add(label, BorderLayout.CENTER);
        welcomePanel.add(new FoldingCube(), BorderLayout.EAST);
//===================================================
        add(welcomePanel, BorderLayout.NORTH);

        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(2, 2, 5, 5));
        add(cardsPanel, BorderLayout.CENTER);
        cardsPanel.add(card1);
        cardsPanel.add(card2);
        cardsPanel.add(card3);
        cardsPanel.add(card4);

    }


    private JPanel createCard(String serviceName, String serviceDescription, ImageIcon image) {
        // Create a JPanel with a border and a modern card layout
        JPanel card = new JPanel();
        PaintImage paintImage = new PaintImage(image.getImage());
        card.setLayout(new BorderLayout());
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBorder(BorderFactory.createLineBorder(new Color(245, 79, 79), 1, true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBorder(BorderFactory.createLineBorder(new Color(17, 138, 148), 2, true));
            }
        });

        // Create a JLabel with the service name and add it to the top of the card
        JLabel serviceNameLabel = new JLabel(serviceName);
        serviceNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        serviceNameLabel.setPreferredSize(new Dimension(0, 50));
        serviceNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        card.add(serviceNameLabel, BorderLayout.NORTH);

        // creating image panel
        card.add(paintImage, BorderLayout.CENTER);

        // Create a JTextArea with the service description and add it to the center of
        // the card
        JScrollPane scrollPane = new JScrollPane();
        JTextArea serviceDescriptionArea = new JTextArea(serviceDescription);
        serviceDescriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        serviceDescriptionArea.setEditable(false);
        serviceDescriptionArea.setLineWrap(true);
        serviceDescriptionArea.setWrapStyleWord(true);
        serviceDescriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        card.setBorder(BorderFactory.createLineBorder(new Color(17, 138, 148), 2, true));
        card.add(serviceDescriptionArea, BorderLayout.SOUTH);

        return card;
    }

}
// @Override
// public void paintComponent(Graphics g) {
// super.paintComponent(g);
// Graphics2D g2d = (Graphics2D) g.create();

// g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
// RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

// g2d.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
// g2d.setPaint(new Color(0, 0, 0, 200));
// g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

// // clean up
// g2d.dispose();
// }