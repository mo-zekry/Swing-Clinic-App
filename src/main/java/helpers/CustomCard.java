package helpers;

import javax.swing.*;
import java.awt.*;

public class CustomCard extends JPanel {

    public CustomCard(ImageIcon icon, String title, String description, int width, int height) {
        setLayout(new BorderLayout());
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        iconLabel.setPreferredSize(new Dimension(width / 3, height));

        JLabel titleLabel = new JLabel(title);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextArea textArea = new JTextArea(description);
        // align the text area to the center
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
         setBackground(new Color(0, 0, 0, 200));

        add(iconLabel, BorderLayout.WEST);
        add(titleLabel, BorderLayout.CENTER);
        add(textArea, BorderLayout.SOUTH);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // // Define your custom gradient colors
        Color color1 = new Color(176, 239, 237); // white
        Color color2 = new Color(71, 174, 241); // teal

        // Create the gradient paint object
        GradientPaint gp = new GradientPaint(100, 100, color2, w, h, color1);
        g2d.setPaint(gp);
        
    }
}
