import exception.InsufficientParameterException;
import exception.InvalidInputException;
import lombok.Getter;
import operation.*;
import operation.BasicOperator;

import java.util.*;

public class Calculator {

    @Getter private Stack<Double> processingStack;
    private Stack<List<Double>> history;
    private Map<String, Operator> registryMap;

    public Calculator() {
        processingStack = new Stack<>();
        history = new Stack<>();
        registryMap = new HashMap<>();
        OperatorFactory.setHistory(history);
        OperatorFactory.setProcessingStack(processingStack);
    }

    public void initCalculator() {
        registryMap.putIfAbsent("+", OperatorFactory.getAddInstance());
        registryMap.putIfAbsent("-", OperatorFactory.getSubtractInstance());
        registryMap.putIfAbsent("*", OperatorFactory.getMultiplyInstance());
        registryMap.putIfAbsent("/", OperatorFactory.getDivideInstance());
        registryMap.putIfAbsent("sqrt", OperatorFactory.getSqrtInstance());
        registryMap.putIfAbsent("clear", OperatorFactory.getClearInstance());
        registryMap.putIfAbsent("undo", OperatorFactory.getUndoInstance());
    }

    public void evaluate(String[] input) throws Exception{
        int cursor = 1;
        for (String token : input) {
            Operator operator = registryMap.get(token);
            if(operator == null) {
                try {
                    Double number = Double.parseDouble(token);
                    operator = OperatorFactory.getBasicOperatorInstance(number);
                } catch (NumberFormatException e) {
                    String message = String.format("Not recognized input %s (position: %d)", token, cursor);
                    throw new InvalidInputException(message);
                }
            }
            if(!operator.operate()) {
                String message = String.format("Operator %s (position: %d): insufficient parameters", token, cursor);
                throw new InsufficientParameterException(message);
            }
            cursor += token.length() + 1;
        };
    }
}
