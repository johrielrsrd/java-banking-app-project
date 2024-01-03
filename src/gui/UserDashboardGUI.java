package gui;

import com.mysql.cj.log.Log;
import data.User;
import data.UserAuthentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDashboardGUI extends BaseFrame {

    public UserDashboardGUI(User user) {
        super("User Dashboard", user);
    }

    @Override
    protected void addGuiComponents() {
        JLabel bankingAppLabel = new JLabel("User Dashboard");
        bankingAppLabel.setBounds(0, 20, super.getWidth(), 40);
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankingAppLabel);

        JLabel welcomeLabel = new JLabel("Welcome " + user.getName());
        welcomeLabel.setBounds(20, 120, getWidth() - 30, 24);
        welcomeLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(welcomeLabel);

        JLabel emailLabel = new JLabel("Your email is: " + user.getEmail());
        emailLabel.setBounds(20, 160, getWidth() - 30, 24);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(emailLabel);

        JLabel numberLabel = new JLabel("Your number is: " + user.getNumber());
        numberLabel.setBounds(20, 200, getWidth() - 30, 24);
        numberLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(numberLabel);

        JButton changePin = new JButton("Change PIN");
        changePin.setBounds(20, 460, getWidth() - 50, 40);
        changePin.setFont(new Font("Dialog", Font.BOLD, 20));
        changePin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDashboardGUI.this.dispose();
                new Dialpad(user).setVisible(true);
            }
        });
        add(changePin);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(20, 510, getWidth() - 50, 40);
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 20));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDashboardGUI.this.dispose();
                User user = new User(null, null, null);
                new LogInGUI().setVisible(true);
            }
        });
        add(logoutButton);
    }
}
