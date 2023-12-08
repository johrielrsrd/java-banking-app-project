package gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static data.UserAuthentication.setPIN;

public class Dialpad extends BaseFrame {
    private String pinInput = "";
    private String name;
    private String email;
    private String number;

    public Dialpad(String name, String email, String number) {
        super("Enter PIN");
        this.name = name;
        this.email = email;
        this.number = number;
    }

    @Override
    protected void addGuiComponents() {

        JLabel setPinLabel = new JLabel("Enter 6-digit PIN");
        setPinLabel.setBounds(0, 20, super.getWidth(), 40);
        setPinLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        setPinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(setPinLabel);

        JTextField pinField = new JTextField();
        pinField.setBounds(20, 80, getWidth() - 50, 40);
        pinField.setFont(new Font("Dialog", Font.PLAIN, 28));
        pinField.setHorizontalAlignment(SwingConstants.CENTER);
        pinField.setEditable(false);
        add(pinField);

        JButton dialButton1 = new JButton("1");
        dialButton1.setBounds(20, 150, 50, 50);
        dialButton1.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton1);

        JButton dialButton2 = new JButton("2");
        dialButton2.setBounds(80, 150, 50, 50);
        dialButton2.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton2);

        JButton dialButton3 = new JButton("3");
        dialButton3.setBounds(140, 150, 50, 50);
        dialButton3.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton3);

        JButton dialButton4 = new JButton("4");
        dialButton4.setBounds(20, 210, 50, 50);
        dialButton4.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton4);

        JButton dialButton5 = new JButton("5");
        dialButton5.setBounds(80, 210, 50, 50);
        dialButton5.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton5);

        JButton dialButton6 = new JButton("6");
        dialButton6.setBounds(140, 210, 50, 50);
        dialButton6.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton6);

        JButton dialButton7 = new JButton("7");
        dialButton7.setBounds(20, 270, 50, 50);
        dialButton7.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton7);

        JButton dialButton8 = new JButton("8");
        dialButton8.setBounds(80, 270, 50, 50);
        dialButton8.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton8);

        JButton dialButton9 = new JButton("9");
        dialButton9.setBounds(140, 270, 50, 50);
        dialButton9.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton9);

        JButton clearButton = new JButton("C");
        clearButton.setBounds(20, 330, 50, 50);
        clearButton.setFont(new Font("Dialog", Font.BOLD, 10));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput = "";
                pinField.setText(pinInput);
            }
        });
        add(clearButton);

        JButton dialButton0 = new JButton("0");
        dialButton0.setBounds(80, 330, 50, 50);
        dialButton0.setFont(new Font("Dialog", Font.BOLD, 10));
        dialButton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput += e.getActionCommand();
                pinField.setText(pinInput);
            }
        });
        add(dialButton0);

        JButton enterButton = new JButton("Enter");
        enterButton.setBounds(140, 330, 50, 50);
        enterButton.setFont(new Font("Dialog", Font.BOLD, 10));
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinInput = pinField.getText();

                if (pinInput.length() == 6) {
                    JOptionPane.showMessageDialog(Dialpad.this, "PIN Updated!");
                    setPIN(name, email, number, pinInput);
                } else {
                    JOptionPane.showMessageDialog(Dialpad.this, "Invalid PIN!");
                }

            }
        });
        add(enterButton);
    }
}


