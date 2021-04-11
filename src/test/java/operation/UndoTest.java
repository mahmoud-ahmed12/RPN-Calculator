package operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UndoTest extends OperatorTest {

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
        Mockito.when(history.pop()).thenReturn(List.of(2D, 3D));

        Assert.assertTrue(underTest.operate());

        InOrder orderVerify = Mockito.inOrder(processingStack, history);
        orderVerify.verify(processingStack, Mockito.times(1)).pop();
        orderVerify.verify(history, Mockito.times(1)).pop();
        orderVerify.verify(processingStack, Mockito.times(1)).push(2D);
        orderVerify.verify(processingStack, Mockito.times(1)).push(3D);
    }

    @Test
    public void canUndoEmptyHistory() {
        Mockito.when(history.pop()).thenReturn(Collections.EMPTY_LIST);

        Assert.assertTrue(underTest.operate());

        Mockito.verify(processingStack, Mockito.times(1)).pop();
        Mockito.verify(history, Mockito.times(1)).pop();
        Mockito.verify(processingStack, Mockito.never()).push(Mockito.anyDouble());

    }
}
