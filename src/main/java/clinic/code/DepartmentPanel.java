package clinic.code;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        FontIcon icon = FontIcon.of(Medicons.NEUROLOGY);
        cardsPanel.add(createCard(icon, "Neurology", lorem));

        icon = FontIcon.of(Medicons.OPHTHALMOLOGY);
        cardsPanel.add(createCard(icon, "Ophthalmology", lorem));

        icon = FontIcon.of(Medicons.MRI_PET);
        cardsPanel.add(createCard(icon, "Nuclear Magnetic", lorem));

        icon = FontIcon.of(Medicons.SURGERY);
        cardsPanel.add(createCard(icon, "Surgical", lorem));

        icon = FontIcon.of(Medicons.CARDIOLOGY);
        cardsPanel.add(createCard(icon, "Cardiology", lorem));

        icon = FontIcon.of(Medicons.RADIOLOGY);
        cardsPanel.add(createCard(icon, "X-ray", lorem));

        icon = FontIcon.of(Medicons.DENTAL);
        cardsPanel.add(createCard(icon, "Dental", lorem));

        icon = FontIcon.of(Medicons.PHYSICAL_THERAPY);
        cardsPanel.add(createCard(icon, "Traumatology", lorem));

        icon = FontIcon.of(Medicons.RESPIRATORY);
        cardsPanel.add(createCard(icon, "Respiratory", lorem));

        add(cardsPanel);

    }

    private JPanel createCard(FontIcon icon, String name, String description) {
        JPanel card = new JPanel();
        icon.setIconSize(100);
        icon.setIconColor(new Color(75, 181, 190));
        card.setLayout(new MigLayout("center"));
//        card.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                icon.setIconColor(new Color(75, 181, 190));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                icon.setIconColor(Color.WHITE);
//            }
//        });

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

//    private void hover(JPanel card, FontIcon icon){
//        card.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                icon.setIconColor(new Color(30, 165, 206));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                icon.setIconColor(Color.WHITE);
//            }
//
//        });
//
//
//    }


}
