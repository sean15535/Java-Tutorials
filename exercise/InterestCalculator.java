import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterestCalculator extends JFrame {
    private JTextField principalField, rateField, timeField;
    private JLabel resultLabel;

    public InterestCalculator() {
        super("Simple Interest Calculator");
        setLayout(new GridLayout(5, 2, 5,5));

        add(new JLabel("Principal:"));
        principalField = new JTextField();
        add(principalField);

        add(new JLabel("Rate (%):"));
        rateField = new JTextField();
        add(rateField);

        add(new JLabel("Time (Years):"));
        timeField = new JTextField();
        add(timeField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this::calculateInterest);
        add(calculateButton);

        resultLabel = new JLabel("Interest: ");
        add(resultLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void calculateInterest(ActionEvent e) {
        try {
            double principal = Double.parseDouble(principalField.getText());
            double rate = Double.parseDouble(rateField.getText());
            double time = Double.parseDouble(timeField.getText());
            double interest = (principal * rate * time) / 100;
            resultLabel.setText(String.format("Interest: %.2f", interest));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Enter numbers only.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterestCalculator::new);
    }
}