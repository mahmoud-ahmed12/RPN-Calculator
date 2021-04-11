package operation;

import lombok.Setter;

@Setter
public abstract class ArithmeticOperator extends BasicOperator implements Validator {
    private final int numOfOperand;

    ArithmeticOperator(int numOfOperand) {
        this.numOfOperand = numOfOperand;
    }
    @Override
    public boolean validate() {
        return processingStack.size() >= numOfOperand;
    }
}
