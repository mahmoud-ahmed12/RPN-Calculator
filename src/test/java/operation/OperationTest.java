package operation;

import operation.Add;
import operation.Operator;
import operation.Validator;
import org.junit.Assert;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public abstract class OperationTest {

    //TODO: maybe add similar hierarchy as operation and arithmetic operation
    @Mock
    protected Stack<Double> processingStack;
    @Mock
    protected Stack<List<Double>> history;

    protected Operator underTest;

    private static final double DELTA = 1e-15;

    protected void canOperateOnTwoNumbers(Double n1, Double n2, Double expected) {
        Mockito.when(processingStack.pop()).thenReturn(n1).thenReturn(n2);
        Mockito.when(processingStack.size()).thenReturn(2);

        ArgumentCaptor<Double> resultCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<List> historyCaptor = ArgumentCaptor.forClass(List.class);

        assertOperateAndCaptor(resultCaptor, historyCaptor);

        Assert.assertEquals(expected, resultCaptor.getValue(), DELTA);
        Assert.assertEquals(List.of(n2, n1), historyCaptor.getValue());
    }

    protected void canOperateOnOneNumber(Double n, Double expected) {
        Mockito.when(processingStack.pop()).thenReturn(n);
        Mockito.when(processingStack.size()).thenReturn(1);

        ArgumentCaptor<Double> resultCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<List> historyCaptor = ArgumentCaptor.forClass(List.class);

        assertOperateAndCaptor(resultCaptor, historyCaptor);

        Assert.assertEquals(expected, resultCaptor.getValue(), DELTA);
        Assert.assertEquals(List.of(n), historyCaptor.getValue());
    }

    protected void canValidateEnoughOperand(int operandAtLeast) {
        Validator validator = (Validator) underTest;
        IntStream.of(0,operandAtLeast-1).forEach( i -> {
            Mockito.when(processingStack.size()).thenReturn(i);
            Assert.assertFalse(validator.validate());
         });
        Mockito.when(processingStack.size()).thenReturn(operandAtLeast);
        Assert.assertTrue(validator.validate());
    }

    private void assertOperateAndCaptor(ArgumentCaptor<Double> resultCaptor, ArgumentCaptor<List> historyCaptor) {
        Assert.assertTrue(underTest.operate());

        Mockito.verify(processingStack, Mockito.times(1))
                .push(resultCaptor.capture());

        Mockito.verify(history, Mockito.times(1))
                .push(historyCaptor.capture());
    }
}
