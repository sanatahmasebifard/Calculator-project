import javax.swing.*;
import java.awt.*;
public class Calculator extends JFrame {
    private JTextField display;
    private CalculatorLogic logic;
    public Calculator() {
        setTitle("ماشین حساب");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        logic = new CalculatorLogic();
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "+/-"
        };
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(e -> handleButtonClick(text));
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    private void handleButtonClick(String command) {
        logic.processInput(command);
        display.setText(logic.getDisplayValue());
    }
}
