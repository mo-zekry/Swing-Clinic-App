package helpers;

import javax.swing.*;
import java.awt.*;

public class ModernButton extends JButton {
    private Color backgroundColor;
    private Color foregroundColor;
    private Color hoverBackgroundColor;
    private Color hoverForegroundColor;
    private Font font;
    private int borderRadius;

    public ModernButton(String text) {
        super(text);
        initializeDefaults();
    }

    private void initializeDefaults() {
        backgroundColor = new Color(51, 153, 255);
        foregroundColor = Color.white;
        hoverBackgroundColor = new Color(102, 179, 255);
        hoverForegroundColor = Color.white;
        font = new Font("Arial", Font.BOLD, 14);
        borderRadius = 10;

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(font);
        setBackground(backgroundColor);
        setForeground(foregroundColor);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(hoverBackgroundColor);
                setForeground(hoverForegroundColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(backgroundColor);
                setForeground(foregroundColor);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);

        // Draw the text
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2.drawString(this.getText(), x, y);

        g2.dispose();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        setForeground(foregroundColor);
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getHoverForegroundColor() {
        return hoverForegroundColor;
    }

    public void setHoverForegroundColor(Color hoverForegroundColor) {
        this.hoverForegroundColor = hoverForegroundColor;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
        super.setFont(font);
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        repaint();
    }
}
