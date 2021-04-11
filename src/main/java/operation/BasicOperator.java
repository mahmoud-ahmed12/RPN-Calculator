package operation;

import lombok.NonNull;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Setter
public class BasicOperator implements Operator {
    private Double number;
    @NonNull Stack<Double> processingStack;
    @NonNull Stack<List<Double>> history;

    public BasicOperator() {}
    public BasicOperator(Stack<Double> processingStack, Stack<List<Double>> history) {
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
