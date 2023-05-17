package clinic.code;

import helpers.PaintImage;
import net.miginfocom.swing.MigLayout;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BlogPanel extends JPanel {
    public BlogPanel() {
        setLayout(new BorderLayout());

        JPanel head = new JPanel();
        head.setLayout(new MigLayout(" fill"));

        JLabel headLabel = new JLabel("<html><body style='text-align: center; font-size: 24; font-weight: 800;'> Gets Every Single Updates Here</body></html>");
        JLabel description = new JLabel("<html><body style='text-align: center; font-size: 15'> Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</body></html>");

        head.add(headLabel, "wrap, align center");
        head.add(description, "align center");

        add(head, BorderLayout.NORTH);
        //================================================

        JPanel cardsPanel = new JPanel(new MigLayout(" fill"));

        cardsPanel.add(createCard(new ImageIcon("src/main/resources/img/blog_1.jpg"), "Scary Thing That You Don’t Get Enough Sleep", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts."), "grow");

        cardsPanel.add(createCard(new ImageIcon("src/main/resources/img/blog_2.jpg"), "Scary Thing That You Don’t Get Enough Sleep", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts."), "grow");

        cardsPanel.add(createCard(new ImageIcon("src/main/resources/img/blog_3.jpg"), "Scary Thing That You Don’t Get Enough Sleep", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts."), "grow, wrap");

        cardsPanel.add(createCard(new ImageIcon("src/main/resources/img/blog_4.jpg"), "Scary Thing That You Don’t Get Enough Sleep", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts."), "grow");

        cardsPanel.add(createCard(new ImageIcon("src/main/resources/img/blog_5.jpg"), "Scary Thing That You Don’t Get Enough Sleep", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts."), "grow");

        cardsPanel.add(createCard(new ImageIcon("src/main/resources/img/blog_6.jpg"), "Scary Thing That You Don’t Get Enough Sleep", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts."), "grow");

        add(cardsPanel, BorderLayout.CENTER);

    }

    private JPanel createCard(ImageIcon image, String head, String description) {
        JPanel card = new JPanel(new MigLayout());

        PaintImage cardImage = new PaintImage(image.getImage());
        card.add(cardImage, "wrap, align center, grow, push");

        JPanel infoPanel = new JPanel(new MigLayout());

        JLabel date = new JLabel("JANE 9, 2023");
        JLabel access = new JLabel("ADMIN");
        FontIcon icon = FontIcon.of(MaterialDesign.MDI_MESSAGE, 15, new Color(255, 255, 255));
        JLabel messages = new JLabel("5", icon, JLabel.CENTER);

        infoPanel.add(date);
        infoPanel.add(access);
        infoPanel.add(messages);

        card.add(infoPanel, "wrap");

        JLabel subject = new JLabel("<html><body style='font-size: 14px;'>" + head + "</body></html>");
        JLabel descriptionLabel = new JLabel("<html><body>" + description + "</body></html>");

        card.add(subject, "wrap");
        card.add(descriptionLabel, "wrap");

        JButton reedMore = new JButton("Reed More");

        card.add(reedMore);

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(new Color(78, 86, 101));
                reedMore.setBackground(new Color(46, 52, 64));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(new Color(46, 52, 64));
                reedMore.setBackground(new Color(78, 86, 101));
            }

        });

        return card;
    }

}
