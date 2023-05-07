package helpers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

public class PaintImage extends JPanel {

    private Image image;

    public PaintImage(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), getParent());
            g2d.dispose();
        }
    }

    public void setImage(Image image) {
        this.image = image;
        repaint();
    }
}
