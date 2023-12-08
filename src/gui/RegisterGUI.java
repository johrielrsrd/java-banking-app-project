package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static data.UserAuthentication.registration;

public class RegisterGUI extends BaseFrame {
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

        JTextField numberField = new JTextField();
        numberField.setBounds(20, 370, getWidth() - 50, 40);
        numberField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(numberField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(20, 420, getWidth() - 30, 24);
        pinLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(pinLabel);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(20, 450, getWidth() - 50, 40);
        pinField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(pinField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 500, getWidth() - 50, 40);
        registerButton.setFont(new Font("Dialog", Font.BOLD, 20));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = firstNameField.getText() + " " + lastNameField.getText();
                String email = emailField.getText();
                String number = numberField.getText();
                String pin = String.valueOf(pinField.getPassword());

                if(registration(name, email, number, pin)) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Registration Successful!");
                } else {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "ERROR: Name/Email/Phone Number already exist.");
                }
            }
        });
        add(registerButton);
    }
}
