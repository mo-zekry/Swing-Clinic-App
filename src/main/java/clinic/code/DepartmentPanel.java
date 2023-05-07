package clinic.code;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.*;

import helpers.PaintImage;

public class DepartmentPanel extends JPanel {
    Image image;
    ImageIcon icon = new ImageIcon("src/main/resources/img/home.png");
    PaintImage paintImage = new PaintImage(icon.getImage());

    public DepartmentPanel() {
        setLayout(new BorderLayout());
        JButton homeButton = new JButton("Home");

        add(homeButton, BorderLayout.NORTH);

    }

}
