package clinic.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The type About panel.
 */
public class AboutPanel extends JPanel {
    ImageIcon image;
    String lorem = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a lectus fermentum, venenatis sapien a, dignissim magna. Morbi nec turpis felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed et ex euismod, malesuada tortor et, tincidunt nulla. Aenean et placerat leo, non suscipit massa. Nullam in dolor gravida, venenatis enim et, cursus turpis. Integer cursus scelerisque dui, eget cursus tellus tincidunt nec.""";

    private JFrame frame;

    public AboutPanel(JFrame frame) {
        // this.frame = frame;

        // Add a ComponentListener to the HomePanel
        // addComponentListener(new ComponentAdapter() {
        // @Override
        // public void componentResized(ComponentEvent e) {
        // int maxWidth = 1000;
        // int currentWidth = getWidth();

        // if (currentWidth <= maxWidth) {
        // frame.setResizable(true);
        // Dimension frameSize = frame.getSize();
        // if (frameSize.width > maxWidth) {
        // frame.setSize(maxWidth, frameSize.height);
        // }
        // } else {
        // frame.setResizable(false);
        // }
        // }
        // });

        setLayout(new BorderLayout());

        // Create the Content panel with the background image
        image = new ImageIcon("src/main/resources/img/home_background.jpg");
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                g2d.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                g2d.setPaint(new Color(0, 0, 0, 100));
                g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

                int rectWidth = getWidth() / 3 * 2;
                int rectHeight = getHeight() / 3 * 2;
                int rectX = getWidth() / 2 - rectWidth / 2;
                int rectY = getHeight() / 2 - rectHeight / 2;
                g2d.setBackground(new Color(250, 66, 66, 0));
                g2d.fillRoundRect(rectX, rectY, rectWidth, rectHeight, 30, 30);

                Font font = new Font("Arial", Font.BOLD, 18);
                int maxWidth = 500; // Maximum width for each line

                g2d.setFont(font);
                g2d.setColor(Color.WHITE);

                String[] words = lorem.split(" ");

                int stringX = (getWidth() - maxWidth) / 2; // Starting x-coordinate for drawing
                int stringY = getHeight() / 2 - font.getSize(); // Starting y-coordinate for drawing
                int lineHeight = g2d.getFontMetrics().getHeight();

                StringBuilder line = new StringBuilder();

                for (String oneWord : words) {
                    // Append the word to the current line
                    String currentLine = line.toString();
                    line.append(oneWord).append(" ");

                    // Check if the current line exceeds the maximum width
                    int lineWidth = g2d.getFontMetrics().stringWidth(currentLine + oneWord);
                    if (lineWidth > maxWidth) {
                        // Draw the current line and move to the next line
                        g2d.drawString(currentLine, stringX, stringY);
                        stringY += lineHeight;
                        line = new StringBuilder(oneWord + " ");
                    }
                }
                // clean up
                g2d.dispose();

            }
        };

        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        // Header
        JLabel headerLabel = new JLabel("We are Mediplus, a Medical Clinic");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(300, 100));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        JButton appointmentButton = new JButton("Make an Appointment");
        appointmentButton.setPreferredSize(new Dimension(300, 50));
        JButton contactButton = new JButton("Contact Us");
        contactButton.setPreferredSize(new Dimension(300, 50));
        buttonsPanel.add(appointmentButton);
        buttonsPanel.add(contactButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
