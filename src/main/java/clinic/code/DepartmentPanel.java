package clinic.code;

import java.awt.*;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import org.kordamp.ikonli.medicons.Medicons;
import org.kordamp.ikonli.swing.FontIcon;

public class DepartmentPanel extends JPanel {
    Image image;

    String lorem = "<html><body style='text-align:center; font-size: 15'> Far far away, behind the word mountains, Far far away, behind the word mountains.</body></html>";
    JFrame frame;

    /**
     * Instantiates a new Department panel.
     *
     * @param frame the frame
     */
    public DepartmentPanel(JFrame frame) {
        this.frame = frame;

        setLayout(new CardLayout());

        JPanel cardsPanel = new JPanel();

        cardsPanel.setLayout(new GridLayout(3, 3, 5, 5));

        FontIcon icon = FontIcon.of(Medicons.NEUROLOGY, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "neurology", lorem));

        icon = FontIcon.of(Medicons.OPHTHALMOLOGY, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "Ophthalmology", lorem));

        icon = FontIcon.of(Medicons.MRI_PET, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "Nuclear Magnetic", lorem));

        icon = FontIcon.of(Medicons.SURGERY, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "Surgical", lorem));

        icon = FontIcon.of(Medicons.CARDIOLOGY, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "Cardiology", lorem));

        icon = FontIcon.of(Medicons.RADIOLOGY, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "X-ray", lorem));

        icon = FontIcon.of(Medicons.DENTAL, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "Dental", lorem));

        icon = FontIcon.of(Medicons.PHYSICAL_THERAPY, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "Traumatology", lorem));

        icon = FontIcon.of(Medicons.RESPIRATORY, 100, Color.WHITE);
        cardsPanel.add(createCard(icon, "Respiratory", lorem));

        add(cardsPanel);

    }

    private JPanel createCard(FontIcon icon, String name, String description) {
        JPanel card = new JPanel();
        card.setLayout(new MigLayout("center"));

        JLabel iconLabel = new JLabel(icon);
        JLabel nameLabel = new JLabel(name, JLabel.CENTER);
        nameLabel.setFont(new Font("", Font.PLAIN, 24));
        JLabel descriptionLabel = new JLabel(description, JLabel.CENTER);

        card.add(iconLabel, "align center, wrap, grow, push");
        card.add(nameLabel, "align center, wrap");
        card.add(descriptionLabel, "align center");
        card.setBackground(new Color(59, 63, 79));
        return card;
    }


}
