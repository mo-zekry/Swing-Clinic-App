package helpers;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

public class HoverEffect {
    private Component hoverComponent;
    private Component affectedComponent;
    private Color normalColor;
    private Color hoverColor;
    private int animationSpeed;

    private Timer timer;
    private float increment;

    public HoverEffect(Component hoverComponent, Component affectedComponent, Color normalColor, Color hoverColor, int animationSpeed) {
        this.hoverComponent = hoverComponent;
        this.affectedComponent = affectedComponent;
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;
        this.animationSpeed = animationSpeed;

        // Set the initial color
        affectedComponent.setBackground(normalColor);

        // Calculate the increment based on the animation speed
        increment = (float) (1.0 / animationSpeed);

        hoverComponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Start the animation when the mouse enters the hover component
                startAnimation(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Start the animation when the mouse exits the hover component
                startAnimation(normalColor);
            }
        });
    }

    private void startAnimation(Color targetColor) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        int redDiff = targetColor.getRed() - affectedComponent.getBackground().getRed();
        int greenDiff = targetColor.getGreen() - affectedComponent.getBackground().getGreen();
        int blueDiff = targetColor.getBlue() - affectedComponent.getBackground().getBlue();

        timer = new Timer(animationSpeed, e -> {
            int red = affectedComponent.getBackground().getRed();
            int green = affectedComponent.getBackground().getGreen();
            int blue = affectedComponent.getBackground().getBlue();

            red += Math.round(redDiff * increment);
            green += Math.round(greenDiff * increment);
            blue += Math.round(blueDiff * increment);

            affectedComponent.setBackground(new Color(red, green, blue));

            if (affectedComponent.getBackground().equals(targetColor)) {
                ((Timer) e.getSource()).stop();
            }
        });

        timer.start();
    }
}
