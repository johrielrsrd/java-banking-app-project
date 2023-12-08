package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static data.UserAuthentication.registration;

public class RegisterGUI extends BaseFrame {
    private String name;
    private String email;
    private String number;

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

        JButton registerButton = new JButton("Next");
        registerButton.setBounds(20, 500, getWidth() - 50, 40);
        registerButton.setFont(new Font("Dialog", Font.BOLD, 20));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = firstNameField.getText() + " " + lastNameField.getText();
                email = emailField.getText();
                number = numberField.getText();

                if(registration(name, email, number)) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Registration Successful!");
                    RegisterGUI.this.dispose();
                    new Dialpad(name, email, number).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "ERROR: Name/Email/Phone Number already exist.");
                }
            }
        });
        add(registerButton);
    }
}
