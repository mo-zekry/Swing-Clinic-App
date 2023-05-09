package clinic.code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import helpers.PaintImage;

public class DepartmentPanel extends JPanel {
    Image image;
    ImageIcon icon = new ImageIcon("src/main/resources/img/home.png");
    PaintImage paintImage = new PaintImage(icon.getImage());

    JFrame frame;

    public DepartmentPanel(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        JButton homeButton = new JButton("Home");

        add(homeButton, BorderLayout.NORTH);

    }

}
