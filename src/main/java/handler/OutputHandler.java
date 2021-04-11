package handler;

import lombok.AllArgsConstructor;

import java.text.DecimalFormat;
import java.util.Stack;

@AllArgsConstructor
public class OutputHandler {
    Stack<Double> resultStack;

    public void displayStack() {
        DecimalFormat fmt = new DecimalFormat("0.##########");
        System.out.print("stack: ");
        resultStack.forEach(value -> {
            System.out.print(fmt.format(value));
            System.out.print(" ");
        });
        System.out.println();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
