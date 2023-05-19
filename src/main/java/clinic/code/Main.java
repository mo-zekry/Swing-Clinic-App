package clinic.code;

import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // set up the look and the theme
        try {
            UIManager.setLookAndFeel( new FlatNordIJTheme());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize theme. Using fallback." );
        }

        // call the myframe
       new MyFrame();
    }
}
