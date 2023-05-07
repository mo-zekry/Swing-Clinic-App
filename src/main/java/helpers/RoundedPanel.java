package helpers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class RoundedPanel extends JPanel {

    private Color backgroundColor;

    public RoundedPanel(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        g2.setColor(backgroundColor);
        g2.fill(roundRect);
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.draw(roundRect);
    }
}