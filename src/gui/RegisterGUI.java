package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static data.UserAuthentication.registration;

public class RegisterGUI extends BaseFrame {
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String number;
    private String password;
    private String repassword;

    public RegisterGUI() {
        super("Banking App Registration");
    }

    @Override
    protected void addGuiComponents() {

        JLabel bankingAppLabel = new JLabel("New User Application");
        bankingAppLabel.setBounds(0, 20, super.getWidth(), 40);
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingAppLabel);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(20, 100, getWidth() - 30, 24);
        firstNameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(firstNameLabel);

        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(20, 130, getWidth() - 50, 40);
        firstNameField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(20, 180, getWidth() - 30, 24);
        lastNameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(20, 210, getWidth() - 50, 40);
        lastNameField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(lastNameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 260, getWidth() - 30, 24);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(20, 290, getWidth() - 50, 40);
        emailField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(emailField);

        JLabel numberLabel = new JLabel("Phone Number:");
        numberLabel.setBounds(20, 340, getWidth() - 30, 24);
        numberLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(numberLabel);

        JTextField countryCodeField = new JTextField("+63");
        countryCodeField.setBounds(20, 370, 55, 40);
        countryCodeField.setFont(new Font("Dialog", Font.PLAIN, 28));
        countryCodeField.setEditable(false);
        add(countryCodeField);

        JTextField numberField = new JTextField();
        numberField.setBounds(80, 370, getWidth() - 110, 40);
        numberField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(numberField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 420, getWidth() - 30, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 450, getWidth() - 50, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(passwordField);

        JLabel repasswordLabel = new JLabel("Re-enter Password:");
        repasswordLabel.setBounds(20, 500, getWidth() - 30, 24);
        repasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(repasswordLabel);

        JPasswordField repasswordField = new JPasswordField();
        repasswordField.setBounds(20, 530, getWidth() - 50, 40);
        repasswordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(repasswordField);

        JButton registerButton = new JButton("Next");
        registerButton.setBounds(20, 580, getWidth() - 50, 40);
        registerButton.setFont(new Font("Dialog", Font.BOLD, 20));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName = firstNameField.getText().trim();
                lastName = lastNameField.getText().trim();
                email = emailField.getText().trim();
                number = numberField.getText().trim();
                password = String.valueOf(passwordField.getPassword());
                repassword = String.valueOf(repasswordField.getPassword());

                if (isInputAllValid(firstName, lastName, email, number, password, repassword)) {
                    name = firstName + " " + lastName;
                    if (registration(name, email, number, password)) {
                        RegisterGUI.this.dispose();
                        new Dialpad(name, email, number).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(RegisterGUI.this, "ERROR: Name/Email/Phone Number is already registered.");
                    }
                } else {
                    System.out.println("Invalid to connect.");
                }
            }
        });
        add(registerButton);
    }

    private boolean isInputAllValid(String firstName, String lastName, String email, String number, String password, String repassword) {
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || number.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            JOptionPane.showMessageDialog(RegisterGUI.this, "Please fill all fields.");
            return false;
        }

        if (!firstName.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(RegisterGUI.this, "InValid Name.");
            return false;
        }

        if (!lastName.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(RegisterGUI.this, "InValid Name.");
            return false;
        }

        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(RegisterGUI.this, "Invalid Email.");
            return false;
        }

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(RegisterGUI.this, "Password must be:\nAt least 8 characters long\nContains at least one digit (0-9)\nContains at least one lowercase letter (a-z)\nContains at least one uppercase letter (A-Z)\nContains at least one special character");
            return false;
        }

        if (!repassword.equals(password)) {
            JOptionPane.showMessageDialog(RegisterGUI.this, "Password do not match.");
            return false;
        }
        return true;
    }

}
