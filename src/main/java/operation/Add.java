package operation;

import java.util.List;
import java.util.Stack;


public class Add extends ArithmeticOperator {

    public Add(Stack<Double> processingStack, Stack<List<Double>> history) {
        super(2);
        this.processingStack = processingStack;
        this.history = history;
    }

    @Override
    public boolean operate(){
        if(!validate()) {
            return false;
        }
        Double n1 = processingStack.pop();
        Double n2 = processingStack.pop();
        processingStack.push(n2 + n1);
        history.push(List.of(n2, n1));
        return true;
    }
}
