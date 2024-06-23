package atm;

import javax.swing.*;

public class TransactionUI extends JFrame {
    private Transaction transaction;

    public TransactionUI(Transaction transaction) {
        this.transaction = transaction;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Transaction");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel balanceLabel = new JLabel("Current Balance: $" + transaction.getAccount().getBalance());
        balanceLabel.setBounds(50, 50, 300, 25);
        panel.add(balanceLabel);

        setVisible(true);
    }
}
