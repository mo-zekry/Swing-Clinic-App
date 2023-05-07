package clinic.code;

import java.awt.*;

import javax.swing.*;

public class contentPanel extends JPanel {

    contentPanel() {
        setLayout(new CardLayout());

        add(new HomePanel(), BorderLayout.CENTER);
    }

}
