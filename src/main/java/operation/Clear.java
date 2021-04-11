package operation;

import java.util.List;
import java.util.Stack;

public class Clear extends BasicOperator {

    public Clear(Stack<Double> processingStack, Stack<List<Double>> history) {
        this.processingStack = processingStack;
        this.history = history;
    }

    @Override
    public boolean operate() {
        processingStack.clear();
        history.clear();
        return true;
    }
}
