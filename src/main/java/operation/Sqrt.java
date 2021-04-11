package operation;

import java.util.List;
import java.util.Stack;

public class Sqrt extends ArithmeticOperator {

    public Sqrt(Stack<Double> processingStack, Stack<List<Double>> history) {
        super(1);
        this.processingStack = processingStack;
        this.history = history;
    }
    @Override
    public boolean operate() {
        if(!validate()) {
            return false;
        }
        Double n = processingStack.pop();
        processingStack.push(Math.sqrt(n));
        history.push(List.of(n));
        return true;
    }
}
