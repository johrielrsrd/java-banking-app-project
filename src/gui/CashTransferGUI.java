package gui;

import data.CashTransfer;
import data.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static data.CashTransfer.cashTransfer;

public class CashTransferGUI extends BaseFrame {

    public CashTransferGUI(User user) {
        super("Cash Transfer", user);
    }

    @Override
    protected void addGuiComponents() {
        JLabel cashTransferLabel = new JLabel("Cash Transfer");
        cashTransferLabel.setBounds(0, 20, super.getWidth(), 40);
        cashTransferLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        cashTransferLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(cashTransferLabel);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(20, 100, getWidth() - 30, 24);
        amountLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(amountLabel);

        JTextField cashTransferField = new JTextField();
        cashTransferField.setBounds(20, 130, getWidth() - 50, 40);
        cashTransferField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(cashTransferField);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(20, 180, getWidth() - 30, 24);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(20, 210, getWidth() - 50, 40);
        nameField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(nameField);

        JLabel accountIDLabel = new JLabel("Account ID");
        accountIDLabel.setBounds(20, 260, getWidth() - 30, 24);
        accountIDLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(accountIDLabel);

        JTextField accountIDField = new JTextField();
        accountIDField.setBounds(20, 290, getWidth() - 50, 40);
        accountIDField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(accountIDField);

        JButton transferButton = new JButton("Transfer");
        transferButton.setBounds(20, 530, getWidth() - 50, 40);
        transferButton.setFont(new Font("Dialog", Font.BOLD, 20));
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(cashTransferField.getText());
                    String name = nameField.getText();
                    int accountID = Integer.parseInt(accountIDField.getText());

                    if (cashTransfer(user, amount, accountID, name)) {
                        JOptionPane.showMessageDialog(CashTransferGUI.this, "Transfer Successful.");
                        CashTransferGUI.this.dispose();
                        new UserDashboardGUI(user).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(CashTransferGUI.this, "Transfer Unsuccessful.\n Please check name and account id.");
                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(CashTransferGUI.this, "Invalid Input.");
                }
            }
        });
        add(transferButton);

        JButton transferCancelButton = new JButton("Cancel");
        transferCancelButton.setBounds(20, 580, getWidth() - 50, 40);
        transferCancelButton.setFont(new Font("Dialog", Font.BOLD, 20));
        transferCancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashTransferGUI.this.dispose();
                new UserDashboardGUI(user).setVisible(true);
            }
        });
        add(transferCancelButton);
    }
}
