package operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

@RunWith(MockitoJUnitRunner.class)
public class PushTest {

    @Mock
    protected Stack<Double> processingStack;
    @Mock
    protected Stack<List<Double>> history;

    protected Push underTest;

    @Before
    public void init() {
        underTest = new Push(processingStack, history);
        underTest.setNumber(3D);
    }

    @Test
    public void canPushNumberToStack() {
        Assert.assertTrue(underTest.operate());
        Mockito.verify(processingStack, Mockito.times(1)).push(3D);
        Mockito.verify(history, Mockito.times(1)).push(Collections.emptyList());
    }

}
