package helpers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.Serial;

import javax.swing.border.AbstractBorder;

public class CustomBorder extends AbstractBorder {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int thickness;
    private final Color color;
    private final boolean topBorder;
    private final boolean leftBorder;
    private final boolean bottomBorder;
    private final boolean rightBorder;
    private final boolean rounded;

    public CustomBorder(int thickness, Color color, boolean topBorder, boolean leftBorder, boolean bottomBorder, boolean rightBorder, boolean rounded) {
        this.thickness = thickness;
        this.color = color;
        this.topBorder = topBorder;
        this.leftBorder = leftBorder;
        this.bottomBorder = bottomBorder;
        this.rightBorder = rightBorder;
        this.rounded = rounded;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        if (rounded) {
            g.drawRoundRect(x, y, width - 1, height - 1, 10, 10);
        } else {
            if (topBorder) {
                g.fillRect(x, y, width, thickness);
            }
            if (leftBorder) {
                g.fillRect(x, y, thickness, height);
            }
            if (bottomBorder) {
                g.fillRect(x, y + height - thickness, width, thickness);
            }
            if (rightBorder) {
                g.fillRect(x + width - thickness, y, thickness, height);
            }
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        int top = topBorder ? thickness : 0;
        int left = leftBorder ? thickness : 0;
        int bottom = bottomBorder ? thickness : 0;
        int right = rightBorder ? thickness : 0;
        return new Insets(top, left, bottom, right);
    }
}
