package operation;

import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Push extends BasicOperator {
    @Setter
    private Double number;

    public Push(Stack<Double> processingStack, Stack<List<Double>> history) {
        this.processingStack = processingStack;
        this.history = history;
    }

    @Override
    public boolean operate() {
        processingStack.push(number);
        history.push(Collections.emptyList());
        return true;
    }
}
