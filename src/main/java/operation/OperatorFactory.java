package operation;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Stack;

public class OperatorFactory {
    @Setter
    private static Stack<Double> processingStack;
    @Setter
    private static Stack<List<Double>> history;

    private static Add addOperator;
    private static Subtract subtractOperator;
    private static Divide divideOperator;
    private static Multiply multiplyOperator;
    private static Sqrt sqrtOperator;
    private static Undo undoOperator;
    private static Clear clearOperator;
    private static Push pushOperator;

    public synchronized static Add getAddInstance() {
        if(addOperator == null) {
            addOperator = new Add(processingStack, history);
        }
        return addOperator;
    }

    public synchronized static Subtract getSubtractInstance() {
        if(subtractOperator == null) {
            subtractOperator = new Subtract(processingStack, history);
        }
        return subtractOperator;
    }

    public synchronized static Divide getDivideInstance() {
        if(divideOperator == null) {
            divideOperator = new Divide(processingStack, history);
        }
        return divideOperator;
    }

    public synchronized static Multiply getMultiplyInstance() {
        if(multiplyOperator == null) {
            multiplyOperator = new Multiply(processingStack, history);
        }
        return multiplyOperator;
    }

    public synchronized static Sqrt getSqrtInstance() {
        if(sqrtOperator == null) {
            sqrtOperator = new Sqrt(processingStack, history);
        }
        return sqrtOperator;
    }

    public synchronized static Undo getUndoInstance() {
        if(undoOperator == null) {
            undoOperator = new Undo(processingStack, history);
        }
        return undoOperator;
    }

    public synchronized static Clear getClearInstance() {
        if(clearOperator == null) {
            clearOperator = new Clear(processingStack, history);
        }
        return clearOperator;
    }

    public synchronized static Push getPushOperatorInstance(Double number) {
        if(pushOperator == null) {
            pushOperator = new Push(processingStack, history);
        }
        pushOperator.setNumber(number);
        return pushOperator;
    }

}
