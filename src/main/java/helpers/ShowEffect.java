package helpers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class HoverPanel {
//    private Component hoverComponent;
//    private Component panelToShow;
//    private Timer timer;
//    private int animationDuration = 300; // Animation duration in milliseconds
//    private float targetOpacity = 0.8f; // Target opacity for fade-in
//
//    public HoverPanel(Component hoverComponent, Component panelToShow) {
//        this.hoverComponent = hoverComponent;
//        this.panelToShow = panelToShow;
//
//        // Set the panel to initially invisible
//        panelToShow.setVisible(false);
//
//        // Create the timer for the animation
//        timer = new Timer(20, new ActionListener() {
//            private long startTime;
//            private boolean fadeIn;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                long currentTime = System.currentTimeMillis();
//                float progress = (float) (currentTime - startTime) / animationDuration;
//
//                if (progress >= 1.0f) {
//                    timer.stop();
//                    if (!fadeIn && panelToShow.getMousePosition() == null) {
//                        // Mouse is not over the panel anymore, start fade-out animation
//                        startFadeOutAnimation();
//                    }
//                    return;
//                }
//
//                float opacity = fadeIn ? progress * targetOpacity : (1 - progress) * targetOpacity;
//                panelToShow.setBackground(new Color(0, 0, 0, opacity));
//                panelToShow.repaint();
//            }
//
//            public void actionPerformed(ActionEvent e, boolean fadeIn) {
//                this.fadeIn = fadeIn;
//                startTime = System.currentTimeMillis();
//            }
//        });
//
//        hoverComponent.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                if (!timer.isRunning()) {
//                    // Start the fade-in animation
//                    startFadeInAnimation();
//                }
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                if (!timer.isRunning()) {
//                    // Start the fade-out animation
//                    startFadeOutAnimation();
//                }
//            }
//        });
//    }
//
//    private void startFadeInAnimation() {
//        panelToShow.setVisible(true);
//        panelToShow.setBackground(new Color(0, 0, 0, 0));
//        timer.setInitialDelay(0);
//        timer.setRepeats(true);
//        timer.addActionListener(e -> timer.getActionListeners()[0].actionPerformed(e, true));
//        timer.start();
//    }
//
//    private void startFadeOutAnimation() {
//        timer.setInitialDelay(0);
//        timer.setRepeats(true);
//        timer.addActionListener(e -> timer.getActionListeners()[0].actionPerformed(e, false));
//        timer.start();
//    }
}
