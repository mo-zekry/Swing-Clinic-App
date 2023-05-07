package helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class FoldingCube extends JPanel {

    private static final int CUBE_SIZE = 30;
    private static final Color CUBE_COLOR = new Color(245, 79, 79);
    private static final Color FACE_COLOR = Color.WHITE;
    private static final int ANIMATION_DELAY = 1500; // ms

    private int cubeRotation = 0;

    public FoldingCube() {
        setPreferredSize(new Dimension(CUBE_SIZE, CUBE_SIZE));

        Timer animationTimer = new Timer();
        animationTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cubeRotation += 90;
                if (cubeRotation >= 360) {
                    cubeRotation = 0;
                }
                repaint();
            }
        }, ANIMATION_DELAY, ANIMATION_DELAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g2d.translate(centerX, centerY);
        g2d.rotate(Math.toRadians(cubeRotation));

        int cubeHalfSize = CUBE_SIZE / 2;

        g2d.setColor(CUBE_COLOR);
        g2d.fillRect(-cubeHalfSize, -cubeHalfSize, CUBE_SIZE, CUBE_SIZE);

        g2d.setColor(FACE_COLOR);
        g2d.fillRect(-cubeHalfSize, -cubeHalfSize, cubeHalfSize, cubeHalfSize);
        g2d.fillRect(0, 0, cubeHalfSize, cubeHalfSize);
        g2d.fillRect(-cubeHalfSize, cubeHalfSize, cubeHalfSize, cubeHalfSize);

        g2d.dispose();
    }

}
