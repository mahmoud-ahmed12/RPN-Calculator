package handler;

import lombok.AllArgsConstructor;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Stack;

@AllArgsConstructor
public class OutputHandler {
    Stack<Double> resultStack;
    PrintStream outStream;

    public void displayStack() {
        DecimalFormat fmt = new DecimalFormat("0.##########");
        outStream.print("stack: ");
        resultStack.forEach(value -> {
            outStream.print(fmt.format(value));
            outStream.print(" ");
        });
        outStream.println();
    }

    public void displayMessage(String message) {
        outStream.println(message);
    }
}
