package helpers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlphaContainer {
    private final JComponent component;
    private final float startAlpha;
    private final float endAlpha;
    private final int duration;

    public AlphaContainer(JComponent component, float startAlpha, float endAlpha, int duration) {
        this.component = component;
        this.startAlpha = startAlpha;
        this.endAlpha = endAlpha;
        this.duration = duration;
    }

    public void startAnimation() {
        Timer timer = new Timer(duration, new AnimationListener());
        timer.setInitialDelay(0);
        timer.start();
    }

    private class AnimationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Timer timer = (Timer) e.getSource();
            float fraction = (float) timer.getDelay() / duration;
            float alpha = startAlpha + fraction * (endAlpha - startAlpha);
            setAlpha(alpha);

            if (fraction >= 1.0f) {
                timer.stop();
            }
        }
    }

    private void setAlpha(float alpha) {
        if (component instanceof JPanel) {
            JPanel panel = (JPanel) component;
            panel.setOpaque(alpha > 0);
        }
        component.setBackground(new Color(
                component.getBackground().getRed(),
                component.getBackground().getGreen(),
                component.getBackground().getBlue(),
                Math.round(alpha * 255)
        ));
        component.repaint();
    }
}
