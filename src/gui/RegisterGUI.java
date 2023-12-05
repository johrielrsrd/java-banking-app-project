package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static data.AppDatabase.testRegister;

public class RegisterGUI extends BaseFrame {
    public RegisterGUI() {
        super("Banking App Registration");
    }

    @Override
    protected void addGuiComponents() {

        JLabel bankingAppLabel = new JLabel("User Application");
        bankingAppLabel.setBounds(0, 20, super.getWidth(), 40);
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingAppLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 120, getWidth() - 30, 24);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(20, 150, getWidth() - 50, 40);
        nameField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 200, getWidth() - 30, 24);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(20, 230, getWidth() - 50, 40);
        emailField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(emailField);

        JLabel numberLabel = new JLabel("Phone Number:");
        numberLabel.setBounds(20, 290, getWidth() - 30, 24);
        numberLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(numberLabel);

        JTextField numberField = new JTextField();
        numberField.setBounds(20, 320, getWidth() - 50, 40);
        numberField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(numberField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(20, 370, getWidth() - 30, 24);
        pinLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(pinLabel);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(20, 400, getWidth() - 50, 40);
        pinField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(pinField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 450, getWidth() - 50, 40);
        registerButton.setFont(new Font("Dialog", Font.BOLD, 20));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                int number = Integer.parseInt(numberField.getText());
                int pin = Integer.parseInt(String.valueOf(pinField.getPassword()));

                testRegister(name, email, number, pin);
            }
        });
        add(registerButton);


    }
}
