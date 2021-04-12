package operation;

import lombok.NonNull;

import java.util.List;
import java.util.Stack;

public abstract class BasicOperator implements Operator {
    @NonNull Stack<Double> processingStack;
    @NonNull Stack<List<Double>> history;
}
