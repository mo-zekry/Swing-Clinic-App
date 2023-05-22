package clinic.code;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import helpers.FoldingCube;
import helpers.PaintImage;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The HomePanel class is a Swing panel that represents the home screen of a clinic application.
 * It features a welcome message, along with four cards showcasing different services provided by the clinic.
 * Each card displays a service name, a description, and an associated image.
 * The panel dynamically adjusts the layout based on the window size, allowing for a responsive user interface.
 * The cards are interactive, changing color when hovered over.
 * Overall, the HomePanel provides an engaging and informative introduction to the clinic application.
 */

public class HomePanel extends JPanel {
    String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Praesent tincidunt justo sed luctus bibendum." +
            "Praesent tincidunt justo sed luctus bibendum.";

    JFrame frame;

    /**
     * Constructs a HomePanel object.
     *
     * @param frame the JFrame containing the panel
     */
    public HomePanel(JFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());
        setOpaque(true);

        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create four cards with service name and description
        JPanel card1 = createCard("Emergency Services",
                lorem,
                new ImageIcon("src/main/resources/img/ambulance.jpg"));
        JPanel card2 = createCard("Outdoors Checkup", lorem,
                new ImageIcon("src/main/resources/img/home_background.jpg"));
        JPanel card3 = createCard("24 Hours Service", lorem,
                new ImageIcon("src/main/resources/img/home_3.jpg"));
        JPanel card4 = createCard("Qualified Doctors", lorem,
                new ImageIcon("src/main/resources/img/doc_3.jpg"));

        // Add the cards to the HomePanel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        JLabel label = new JLabel("Welcome To Mideplus");
        label.setFont(new Font("Gotham", Font.BOLD, 25));
        welcomePanel.add(label, BorderLayout.CENTER);
        welcomePanel.add(new FoldingCube(), BorderLayout.EAST);

        add(welcomePanel, BorderLayout.NORTH);

        JPanel cardsPanel = new JPanel();

        cardsPanel.setLayout(new GridLayout(2, 2, 5, 5));
        cardsPanel.add(card1);
        cardsPanel.add(card2);
        cardsPanel.add(card3);
        cardsPanel.add(card4);

        JScrollPane scrollPane = new JScrollPane(cardsPanel);

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();

        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setBlockIncrement(100);

        add(scrollPane, BorderLayout.CENTER);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int columns = width >= 1000 ? 3 : 2;
                cardsPanel.setLayout(new GridLayout(0, columns, 5, 5));
                revalidate();
            }
        });
    }

    /**
     * Creates a card panel with a service name, description, and image.
     *
     * @param serviceName        the name of the service
     * @param serviceDescription the description of the service
     * @param image              the ImageIcon associated with the service
     * @return a JPanel representing the card
     */
    private JPanel createCard(String serviceName, String serviceDescription, ImageIcon image) {

        JPanel card = new JPanel();

        JLabel serviceNameLabel = new JLabel(serviceName);

        JTextArea serviceDescriptionArea = new JTextArea(serviceDescription);

        PaintImage paintImage = new PaintImage(image.getImage());

        card.setLayout(new BorderLayout());
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(new Color(98, 102, 121));

                card.setForeground(Color.WHITE);
                serviceDescriptionArea.setForeground(Color.WHITE);
                serviceNameLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(new Color(59, 63, 79));
                card.setForeground(new Color(183, 183, 192));
                serviceDescriptionArea.setForeground(new Color(183, 183, 192));
                serviceNameLabel.setForeground(new Color(183, 183, 192));
            }
        });

        // Create a JLabel with the service name and add it to the top of the card
        serviceNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        serviceNameLabel.setPreferredSize(new Dimension(0, 50));
        serviceNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        card.add(serviceNameLabel, BorderLayout.NORTH);

        // creating image panel
        card.add(paintImage, BorderLayout.CENTER);

        // Create a JTextArea with the service description and add it to the center of
        // the card
        serviceDescriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        serviceDescriptionArea.setEditable(false);
        serviceDescriptionArea.setLineWrap(true);
        serviceDescriptionArea.setWrapStyleWord(true);
        serviceDescriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        card.add(serviceDescriptionArea, BorderLayout.SOUTH);

        card.setBackground(new Color(59, 63, 79));
        card.setForeground(new Color(183, 183, 192));
        card.setPreferredSize(new Dimension(300, 400));
        serviceDescriptionArea.setForeground(new Color(183, 183, 192));
        serviceNameLabel.setForeground(new Color(183, 183, 192));

        return card;
    }

}
