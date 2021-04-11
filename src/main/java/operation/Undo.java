package operation;

import java.util.List;
import java.util.Stack;

public class Undo extends BasicOperator {

    public Undo(Stack<Double> processingStack, Stack<List<Double>> history) {
        this.processingStack = processingStack;
        this.history = history;
    }

    @Override
    public boolean operate() {
        if (!processingStack.empty()) {
            processingStack.pop();
            List<Double> lastHistory = history.pop();
            lastHistory.forEach(d -> processingStack.push(d));
        }
        return true;
    }
}
