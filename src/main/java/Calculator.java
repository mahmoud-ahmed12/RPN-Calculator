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

public void initCalculator() {
    registryMap.putIfAbsent("+", new Add(processingStack, history));
    registryMap.putIfAbsent("-", new Subtract(processingStack, history));
    registryMap.putIfAbsent("*", new Multiply(processingStack, history));
    registryMap.putIfAbsent("/", new Divide(processingStack, history));
    registryMap.putIfAbsent("sqrt", new Sqrt(processingStack, history));
    registryMap.putIfAbsent("clear", new Clear(processingStack, history));
    registryMap.putIfAbsent("undo", new Undo(processingStack, history));
    registryMap.putIfAbsent("default", new BasicOperator(processingStack, history));
}

    public Calculator() {
        processingStack = new Stack<>();
        history = new Stack<>();
        registryMap = new HashMap<>();
    }
    public void evaluate(String[] input) throws Exception{
        int cursor = 1;
        for (String token : input) {
            Operator operator = registryMap.get(token);
            if(operator == null) {
                operator = registryMap.get("default");
                try {
                    Double number = Double.parseDouble(token);
                    //TODO: think of another way to do it, maybe all operations takes token?
                    ((BasicOperator)operator).setNumber(number);
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
