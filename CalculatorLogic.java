public class CalculatorLogic {
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private boolean startNewNumber = true;
    private String displayValue = "0";
    public void processInput(String command) {
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            if (startNewNumber) {
                displayValue = command;
                startNewNumber = false;
            } else {
                displayValue += command;
            }
        }
        else if (command.equals("C")) {
            displayValue = "0";
            startNewNumber = true;
            num1 = num2 = result = 0;
        }
        else if (command.equals("+/-")) {
            if (!displayValue.equals("0")) {
                if (displayValue.charAt(0) == '-') {
                    displayValue = displayValue.substring(1);
                } else {
                    displayValue = "-" + displayValue;
                }
            }
        }
        else if (command.equals("=")) {
            num2 = Double.parseDouble(displayValue);
            calculateResult();
            displayValue = String.valueOf(result);
            startNewNumber = true;
        }
        else {
            operator = command.charAt(0);
            num1 = Double.parseDouble(displayValue);
            startNewNumber = true;
        }
    }
    private void calculateResult() {
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
        }
    }
    public String getDisplayValue() {
        return displayValue;
    }
}