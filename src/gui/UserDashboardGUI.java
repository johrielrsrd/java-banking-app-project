package gui;

import com.mysql.cj.log.Log;
import data.User;
import data.UserAuthentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static data.CashIn.cashIn;
import static data.CheckBalance.checkBalance;

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

        JLabel numberLabel = new JLabel("Your number is: +63" + user.getNumber());
        numberLabel.setBounds(20, 200, getWidth() - 30, 24);
        numberLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(numberLabel);

        JLabel idLabel = new JLabel("Your ID number: " + user.getId());
        idLabel.setBounds(20, 240, getWidth() - 30, 24);
        idLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(idLabel);

        JTextField cashInField = new JTextField();
        cashInField.setBounds(20, 330, getWidth() - 50, 40);
        cashInField.setFont(new Font("Dialog", Font.PLAIN, 28));
        cashInField.setHorizontalAlignment(SwingConstants.CENTER);
        add(cashInField);

        JButton cashInButton = new JButton("Cash In");
        cashInButton.setBounds(20, 380, getWidth() - 50, 40);
        cashInButton.setFont(new Font("Dialog", Font.BOLD, 20));
        cashInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double cashInAmount = Double.parseDouble(cashInField.getText());
                    cashIn(user, cashInAmount);
                    JOptionPane.showMessageDialog(UserDashboardGUI.this, "Your Cash In amount is: " + cashInAmount);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(UserDashboardGUI.this, "Invalid Input");
                }
            }
        });
        add(cashInButton);

        JButton cashTransferButton = new JButton("Cash Transfer");
        cashTransferButton.setBounds(20, 430, getWidth() - 50, 40);
        cashTransferButton.setFont(new Font("Dialog", Font.BOLD, 20));
        cashTransferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDashboardGUI.this.dispose();
                new CashTransferGUI(user).setVisible(true);
            }
        });
        add(cashTransferButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(20, 480, getWidth() - 50, 40);
        checkBalanceButton.setFont(new Font("Dialog", Font.BOLD, 20));
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(UserDashboardGUI.this, "Your current balance is: " + checkBalance(user));
            }
        });
        add(checkBalanceButton);

        JButton changePin = new JButton("Change PIN");
        changePin.setBounds(20, 530, getWidth() - 50, 40);
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
        logoutButton.setBounds(20, 580, getWidth() - 50, 40);
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 20));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDashboardGUI.this.dispose();
                User user = new User(0, null, null, null);
                new LogInGUI().setVisible(true);
            }
        });
        add(logoutButton);
    }


}
