package clinic.code;

import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;

import javax.swing.*;

/**
 * The Main class is the entry point for the Clinic Appointment application.
 * It sets up the look and theme of the application using the FlatNordIJTheme from the FlatLaf library.
 * The main method initializes the theme, creates an instance of the MyFrame class (the main frame of the application), and launches the application.
 * It serves as the starting point for the Clinic Appointment application and handles the initialization of the user interface and theme configuration.
 */

public class Main {
    /**
     * The main method of the application.
     * It initializes the look and theme, and creates an instance of MyFrame.
     *
     * @param args the command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        System.out.println("Initializing application...");

        // Set up the look and the theme
        try {
            UIManager.setLookAndFeel(new FlatNordIJTheme());
            System.out.println("Theme initialized successfully.");
        } catch (Exception ex) {
            System.err.println("Failed to initialize theme. Using fallback.");
        }

        // Create an instance of MyFrame
        System.out.println("Creating main frame...");
        new MyFrame();

        System.out.println("Application initialized.");
    }
}
