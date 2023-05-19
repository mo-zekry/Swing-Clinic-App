package clinic.code;

import com.github.lgooddatepicker.components.DatePicker;


import net.miginfocom.swing.MigLayout;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ContactPanel extends JPanel {
    JFrame frame;

    public ContactPanel(JFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("<html><body style='text-align: center;font-size: 30; background-color: #333; color: #fff; padding: 10px; font-family: 'Helvetica', sans-serif; text-transform: uppercase; letter-spacing: 2px;'>CONTACT US</body></html>");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(title, BorderLayout.CENTER);
        //======================================================

        JPanel container = new JPanel(new MigLayout("fill, debug"));

        JPanel contactWays = new JPanel(new MigLayout("align center, gap 30 20"));
        contactWays.setPreferredSize(new Dimension(500, 210));

        FontIcon icon = FontIcon.of(MaterialDesign.MDI_MAP_MARKER);
        contactWays.add(createCard(icon, "ADDRESS", "198 West 21th Street, Suite 721 New York NY 10016"), "wrap");

        icon = FontIcon.of(MaterialDesign.MDI_PHONE);
        contactWays.add(createCard(icon, "CONTACT NUMBER", "+ 1235 2355 98"), "wrap");

        icon = FontIcon.of(MaterialDesign.MDI_EMAIL);
        contactWays.add(createCard(icon, "Email Address", "info@yoursite.com"), "wrap");

        icon = FontIcon.of(MaterialDesign.MDI_WEB);
        contactWays.add(createCard(icon, "WEBSITE", "info@yoursite.com"), "wrap");

        //=====================================================

        JPanel form = new JPanel(new GridBagLayout());

        GridBagConstraints style = new GridBagConstraints();
        style.fill = GridBagConstraints.HORIZONTAL;
        style.insets = new Insets(10, 10, 10, 10);

        // ================================= start of form ================================
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("", Font.PLAIN, 18));
        JTextField firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(400, 40));
        style.gridx = 0;
        style.gridy = 0;
        form.add(firstNameLabel, style);
        style.gridx = 1;
        style.gridy = 0;
        form.add(firstNameField, style);

        // ====================================================
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("", Font.PLAIN, 18));
        JTextField lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(400, 40));
        style.gridx = 0;
        style.gridy = 1;
        form.add(lastNameLabel, style);
        style.gridx = 1;
        style.gridy = 1;
        form.add(lastNameField, style);

        // ====================================================
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("", Font.PLAIN, 18));
        style.gridx = 0;
        style.gridy = 3;
        form.add(emailLabel, style);

        // Create the email field
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(400, 40));
        style.gridx = 1;
        style.gridy = 3;
        form.add(emailField, style);

        // ====================================================
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("", Font.PLAIN, 18));
        DatePicker data = new DatePicker();
        data.getComponentDateTextField().setBackground(new Color(59, 66, 82));
        data.setPreferredSize(new Dimension(400, 40));
        style.gridx = 0;
        style.gridy = 4;
        form.add(dateLabel, style);
        style.gridx = 1;
        style.gridy = 4;
        form.add(data, style);

        // ====================================================
        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("", Font.PLAIN, 18));

        SpinnerDateModel timeModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        timeModel.setValue(calendar.getTime());
        timeSpinner.setPreferredSize(new Dimension(400, 40));
        style.gridx = 0;
        style.gridy = 5;
        form.add(timeLabel, style);
        style.gridx = 1;
        style.gridy = 5;
        form.add(timeSpinner, style);

        // ====================================================
        JLabel serviceLabel = new JLabel("Service Type:");
        serviceLabel.setFont(new Font("", Font.PLAIN, 18));
        String[] serviceTypes = {"Neurology", "Ophthalmology", "Nuclear Magnetic", "Surgical", "Cardiology", "X-ray", "Dental", "Rheumatology", "Respiratory"};
        JComboBox<String> serviceComboBox = new JComboBox<>(serviceTypes);
        serviceComboBox.setFont(new Font("", Font.PLAIN, 18));
        style.gridx = 0;
        style.gridy = 6;
        form.add(serviceLabel, style);
        style.gridx = 1;
        style.gridy = 6;
        form.add(serviceComboBox, style);

        // ====================================================
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("", Font.PLAIN, 18));

        JRadioButton maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("", Font.PLAIN, 18));
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("", Font.PLAIN, 18));

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        style.gridx = 0;
        style.gridy = 7;
        form.add(genderLabel, style);
        style.gridx = 1;
        style.gridy = 7;
        form.add(maleRadioButton, style);
        style.gridx = 1;
        style.gridy = 8;
        form.add(femaleRadioButton, style);

        // ====================================================
        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("", Font.PLAIN, 18));
        submitBtn.setPreferredSize(new Dimension(100, 40));
        style.gridx = 1;
        style.gridy = 9; // Adjusted row number
        style.gridwidth = 1;
        form.add(submitBtn, style);

        submitBtn.addActionListener(new ActionListener() {

            private boolean isValidName(String name) {
                // Name pattern regular expression (only alphabetic characters)
                String namePattern = "^[a-zA-Z]+$";
                return name.matches(namePattern);
            }

            private boolean isValidEmail(String email) {
                // Email regular expression validation
                String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                return email.matches(emailPattern);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // get the form data
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String date = data.getText();
                String time = timeSpinner.getValue().toString();
                String serviceType = serviceComboBox.getSelectedItem().toString();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";

                // Validate empty fields
                boolean is_empty = firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || date.isEmpty() || time.isEmpty() || serviceType.isEmpty() || gender.isEmpty();

                // Validate first name and last name
                boolean isValidFirstName = isValidName(firstName);
                boolean isValidLastName = isValidName(lastName);

                // Validate email pattern
                boolean isValidEmail = isValidEmail(email);

                if (is_empty) {
                    JOptionPane.showMessageDialog(null, " All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!isValidFirstName || !isValidLastName) {
                    JOptionPane.showMessageDialog(null, "Invalid name. don't use special characters or numbers", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!isValidEmail) {
                    JOptionPane.showMessageDialog(null, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // exit the event
                }

                // Reset the form fields
                clearFields();
            }

            private void clearFields() {
                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                data.setText("");
                timeModel.setValue(calendar.getTime());
                serviceComboBox.setSelectedIndex(0);
                genderButtonGroup.clearSelection();
            }

        });
        // ================================ End of form ====================================

        container.add(form, "cell 0 0, align center, push");
        container.add(contactWays, "cell 1 0");
        add(headerPanel, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
    }

    private JPanel createCard(FontIcon icon, String name, String description) {
        JPanel card = new JPanel(new BorderLayout());
//        card.setBackground(Color.white);
        card.setBackground(new Color(59, 63, 79));
        card.setBorder(BorderFactory.createLineBorder(new Color(87, 91, 108), 2, true));
        card.setPreferredSize(new Dimension(300, 100));

        JPanel iconPanel = new JPanel(new BorderLayout());
        iconPanel.setBackground(new Color(78, 83, 98));
        iconPanel.setPreferredSize(new Dimension(70, 70));
        iconPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        icon.setIconSize(35);
        icon.setIconColor(new Color(255, 255, 255));
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setFont(iconLabel.getFont().deriveFont(40f));
        iconPanel.add(iconLabel, BorderLayout.CENTER);

        // Panel for the contact name
        JPanel namePanel = new JPanel();
        namePanel.setBackground(new Color(59, 63, 79));
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 18f));
        namePanel.add(nameLabel);

        // Panel for the description
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(new Color(59, 63, 79));
        JTextArea descriptionArea = new JTextArea(description);
        descriptionArea.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 14f));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));
        descriptionPanel.add(descriptionArea, BorderLayout.CENTER);

        // Add the panels to the card
        card.add(iconPanel, BorderLayout.WEST);
        card.add(namePanel, BorderLayout.NORTH);
        card.add(descriptionPanel, BorderLayout.CENTER);

        return card;
    }
}
