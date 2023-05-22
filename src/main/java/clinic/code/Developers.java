package clinic.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Developers extends JPanel {
    private JFrame frame;
    private JLabel imageLabel;
    private String[] imagePaths;
    private String[] developerNames;
    private String[] developerDescriptions;
    private int currentIndex;

    public Developers(JFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        // Array of image paths for the developers
        imagePaths = new String[]{
                "src/main/resources/img/doc_1.jpg",
                "src/main/resources/img/doc_2.jpg",
                "src/main/resources/img/doc_3.jpg",
                "src/main/resources/img/doc_4.jpg",
                "src/main/resources/img/doc_1.jpg",
                "src/main/resources/img/doc_2.jpg"
        };

        // Array of developer names
        developerNames = new String[]{
                "Developer 1",
                "Developer 2",
                "Developer 3",
                "Developer 4",
                "Developer 5",
                "Developer 6"
        };

        // Array of developer descriptions
        developerDescriptions = new String[]{
                "Description 1",
                "Description 2",
                "Description 3",
                "Description 4",
                "Description 5",
                "Description 6"
        };

        // Create the image label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(500, 300));
        add(imageLabel, BorderLayout.CENTER);

        // Update the image to display the first developer's image
        currentIndex = 0;
        updateImage();

        // Create the card panel for developer information
        JPanel cardPanel = new JPanel(new CardLayout());
        add(cardPanel, BorderLayout.SOUTH);

        // Create card components for each developer
        for (int i = 0; i < imagePaths.length; i++) {
            JPanel card = createCard(developerNames[i], developerDescriptions[i]);
            cardPanel.add(card, String.valueOf(i));
        }

        // Create the timer for the slideshow
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Increment the current index and update the image and card
                currentIndex++;
                if (currentIndex >= imagePaths.length) {
                    currentIndex = 0; // Reset to the first developer
                }
                updateImage();
                showDeveloperCard(cardPanel);
            }
        });

        // Start the slideshow
        timer.start();
    }

    private JPanel createCard(String name, String description) {
        JPanel card = new JPanel(new BorderLayout());

        // Create labels for name and description
        JLabel nameLabel = new JLabel(name);
        JLabel descriptionLabel = new JLabel(description);

        // Customize labels if needed
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Add labels to card
        card.add(nameLabel, BorderLayout.NORTH);
        card.add(descriptionLabel, BorderLayout.CENTER);

        return card;
    }

    private void updateImage() {
        // Load the image from the current path and set it on the label
        ImageIcon imageIcon = new ImageIcon(imagePaths[currentIndex]);
        Image image = imageIcon.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
    }

    private void showDeveloperCard(JPanel cardPanel) {
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, String.valueOf(currentIndex));
    }
}
