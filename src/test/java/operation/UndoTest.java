package operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

@RunWith(MockitoJUnitRunner.class)
public class UndoTest {

    @Mock
    protected Stack<Double> processingStack;
    @Mock
    protected Stack<List<Double>> history;

    protected Undo underTest;

    @Before
    public void init() {
        underTest = new Undo(processingStack, history);
    }

    @Test
    public void canUndoEmptyStack() {
        Mockito.when(processingStack.empty()).thenReturn(true);
        Assert.assertTrue(underTest.operate());
    }

    @Test
    public void canUndoLastHistory() {
        // Given
        Mockito.when(history.pop()).thenReturn(List.of(2D, 3D));

        // When
        Assert.assertTrue(underTest.operate());

        // Then
        InOrder orderVerify = Mockito.inOrder(processingStack, history);
        orderVerify.verify(processingStack, Mockito.times(1)).pop();
        orderVerify.verify(history, Mockito.times(1)).pop();
        orderVerify.verify(processingStack, Mockito.times(1)).push(2D);
        orderVerify.verify(processingStack, Mockito.times(1)).push(3D);
    }

    @Test
    public void canUndoEmptyHistory() {
        // Given
        Mockito.when(history.pop()).thenReturn(Collections.EMPTY_LIST);

        // When
        Assert.assertTrue(underTest.operate());

        // Then
        Mockito.verify(processingStack, Mockito.times(1)).pop();
        Mockito.verify(history, Mockito.times(1)).pop();
        Mockito.verify(processingStack, Mockito.never()).push(Mockito.anyDouble());

    }
}
