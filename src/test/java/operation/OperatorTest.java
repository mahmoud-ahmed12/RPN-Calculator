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

public abstract class OperatorTest {

    @Mock
    protected Stack<Double> processingStack;
    @Mock
    protected Stack<List<Double>> history;

    protected Operator underTest;
}
