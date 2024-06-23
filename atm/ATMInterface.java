package atm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {
    private ATM atm;
    private Account currentAccount;

    private JTextField accountNumberField;
    private JPasswordField pinField;
    private JLabel statusLabel;

    public ATMInterface(ATM atm) {
        this.atm = atm;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel accountLabel = new JLabel("Account Number:");
        accountLabel.setBounds(50, 50, 150, 25);
        panel.add(accountLabel);

        accountNumberField = new JTextField(20);
        accountNumberField.setBounds(200, 50, 150, 25);
        panel.add(accountNumberField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(50, 100, 150, 25);
        panel.add(pinLabel);

        pinField = new JPasswordField(20);
        pinField.setBounds(200, 100, 150, 25);
        panel.add(pinField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 25);
        panel.add(loginButton);

        statusLabel = new JLabel("");
        statusLabel.setBounds(50, 200, 300, 25);
        panel.add(statusLabel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                authenticateUser();
            }
        });
    }

    private void authenticateUser() {
        try {
            long accountNumber = Long.parseLong(accountNumberField.getText());
            int pin = Integer.parseInt(new String(pinField.getPassword()));

            currentAccount = atm.authenticateUser(accountNumber, pin);

            if (currentAccount != null) {
                statusLabel.setText("Login successful.");
                showTransactionUI();
            } else {
                statusLabel.setText("Invalid account number or PIN.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid input. Please enter valid account number and PIN.");
        }
    }

    private void showTransactionUI() {
        Transaction transaction = new Transaction(currentAccount);
        new TransactionUI(transaction);
        this.dispose(); // Close the login window
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        ATMInterface atmInterface = new ATMInterface(atm);
        atmInterface.setVisible(true);
    }
}
