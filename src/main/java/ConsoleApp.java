import handler.InputHandler;
import handler.OutputHandler;

import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {

        Calculator rpnCalculator = new Calculator();
        rpnCalculator.initCalculator();
        InputHandler inputHandler = new InputHandler(new Scanner(System.in));
        OutputHandler outputHandler = new OutputHandler(rpnCalculator.getProcessingStack(), System.out);
        outputHandler.displayMessage("Please enter RPN expression space separated!");
        while(inputHandler.hasNextInput()) {
            String[] input = inputHandler.handleUserInput();
            try {
                rpnCalculator.evaluate(input);
            } catch (Exception e) {
                outputHandler.displayMessage(e.getMessage());
            }
            outputHandler.displayStack();
        }
    }
}
