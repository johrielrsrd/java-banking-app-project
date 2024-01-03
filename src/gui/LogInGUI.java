package gui;

import data.User;
import data.UserAuthentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static data.UserAuthentication.checkPIN;
import static data.UserAuthentication.logIn;


public class LogInGUI extends BaseFrame {
    public LogInGUI() {
        super("Banking App Login");
    }

    @Override
    protected void addGuiComponents() {
        JLabel bankingAppLabel = new JLabel("Log In Page");
        bankingAppLabel.setBounds(0, 20, super.getWidth(), 40);
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingAppLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 120, getWidth() - 30, 24);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(20, 160, getWidth() - 50, 40);
        emailField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 280, getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 320, getWidth() - 50, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 460, getWidth() - 50, 40);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 20));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String logInEmail = emailField.getText().trim();
                String logInPassword = String.valueOf(passwordField.getPassword());

                User user = logIn(logInEmail, logInPassword);

                if (user != null) {
                    if (checkPIN(logInEmail, logInPassword)) {
                        System.out.println("Required to change PIN");
                        LogInGUI.this.dispose();
                        new Dialpad(user).setVisible(true);
                    } else {
                        LogInGUI.this.dispose();
                        new UserDashboardGUI(user).setVisible(true);
                        System.out.println("Login Successful!");
                    }
                } else {
                    System.out.println("Invalid LogIn");
                }
            }
        });
        add(loginButton);

        JLabel registerLabel = new JLabel("<html><a href=\"#\">Don't have an account? Register Here</a></html>");
        registerLabel.setBounds(0, 510, getWidth() - 10, 30);
        registerLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogInGUI.this.dispose();
                new RegisterGUI().setVisible(true);
            }
        });
        add(registerLabel);
    }
}
