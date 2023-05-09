package clinic.code;

import java.awt.*;

import javax.swing.*;

public class HeaderPanel extends JPanel {
    public HeaderPanel() {
        JButton button = new JButton("side menu");
        button.addActionListener(e -> {
            
        });
        setBackground(new Color(59, 59, 59));
        setPreferredSize(new Dimension(1000, 50));
    }
}
