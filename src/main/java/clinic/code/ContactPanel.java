package clinic.code;

import com.github.lgooddatepicker.components.DatePicker;
import org.jdesktop.swingx.JXDatePicker;

import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class ContactPanel extends JPanel {
    JFrame frame;

    public ContactPanel(JFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        JPanel contactWays = new JPanel(new FlowLayout());
        contactWays.setPreferredSize(new Dimension(500, 210));

        FontIcon icon = FontIcon.of(MaterialDesign.MDI_MAP_MARKER);
        contactWays.add(createCard(icon, "ADDRESS", "198 West 21th Street, Suite 721 New York NY 10016"));

        icon = FontIcon.of(MaterialDesign.MDI_PHONE);
        contactWays.add(createCard(icon, "CONTACT NUMBER", "+ 1235 2355 98"));

        icon = FontIcon.of(MaterialDesign.MDI_EMAIL);
        contactWays.add(createCard(icon, "Email Address", "info@yoursite.com"));

        icon = FontIcon.of(MaterialDesign.MDI_WEB);
        contactWays.add(createCard(icon, "WEBSITE", "info@yoursite.com"));

        //=====================================================

        JPanel containerPanel = new JPanel();
        JPanel emptyPanel_1 = new JPanel();
        JPanel emptyPanel_2 = new JPanel();

        JPanel form = new JPanel(new GridBagLayout());


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("", Font.PLAIN, 18));
        JTextField firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(400, 40));
        c.gridx = 0;
        c.gridy = 0;
        form.add(firstNameLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        form.add(firstNameField, c);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("", Font.PLAIN, 18));
        JTextField lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(400, 40));
        c.gridx = 0;
        c.gridy = 1;
        form.add(lastNameLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        form.add(lastNameField, c);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("", Font.PLAIN, 18));

//        JXDatePicker datePicker = new JXDatePicker();
//        UIDefaults uiDefaults = UIManager.getDefaults();
//        uiDefaults.put("JXMonthView.background", Color.LIGHT_GRAY); // Set background color of the date chooser menu

        DatePicker data = new DatePicker();
        data.setPreferredSize(new Dimension(400, 40));
        c.gridx = 0;
        c.gridy = 2;
        form.add(dateLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        form.add(data, c);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("", Font.PLAIN, 18));

        SpinnerDateModel timeModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        timeModel.setValue(calendar.getTime());

//        JTextField timeField = new JTextField();

        timeSpinner.setPreferredSize(new Dimension(400, 40));
        c.gridx = 0;
        c.gridy = 3;
        form.add(timeLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        form.add(timeSpinner, c);

        JLabel serviceLabel = new JLabel("Service Type:");
        serviceLabel.setFont(new Font("", Font.PLAIN, 18));
        String[] serviceTypes = {"Type 1", "Type 2", "Type 3"};
        JComboBox<String> serviceComboBox = new JComboBox<>(serviceTypes);
        serviceComboBox.setFont(new Font("", Font.PLAIN, 18));
        c.gridx = 0;
        c.gridy = 4;
        form.add(serviceLabel, c);
        c.gridx = 1;
        c.gridy = 4;
        form.add(serviceComboBox, c);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("", Font.PLAIN, 18));

        JRadioButton maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("", Font.PLAIN, 18));
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("", Font.PLAIN, 18));

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        c.gridx = 0;
        c.gridy = 5;
        form.add(genderLabel, c);
        c.gridx = 1;
        c.gridy = 5;
        form.add(maleRadioButton, c);
        c.gridx = 1;
        c.gridy = 6;
        form.add(femaleRadioButton, c);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("", Font.PLAIN, 18));
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 1;
        form.add(submitBtn, c);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String date = data.getText();
                String time = timeSpinner.getValue().toString();
                String serviceType = serviceComboBox.getSelectedItem().toString();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";

                // Perform actions with the form data
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Date: " + date);
                System.out.println("Time: " + time);
                System.out.println("Service Type: " + serviceType);
                System.out.println("Gender: " + gender);
                // Reset the form fields
                firstNameField.setText("");
                lastNameField.setText("");
                data.setText("");
                timeModel.setValue(calendar.getTime());
                serviceComboBox.setSelectedIndex(0);
                genderButtonGroup.clearSelection();
            }
        });


        containerPanel.add(emptyPanel_1, BorderLayout.EAST);
        containerPanel.add(form, BorderLayout.CENTER);
        containerPanel.add(emptyPanel_2, BorderLayout.EAST);

        add(contactWays, BorderLayout.NORTH);
        add(containerPanel, BorderLayout.CENTER);
    }

    private JPanel createCard(FontIcon icon, String name, String description) {
        JPanel card = new JPanel(new BorderLayout());
//        card.setBackground(Color.white);
        card.setBackground(new Color(59, 63, 79));
        card.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        card.setPreferredSize(new Dimension(300, 100));

        // Panel for the rounded icon
        JPanel iconPanel = new JPanel(new BorderLayout());
//        iconPanel.setBackground(new Color(240, 240, 240));
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
