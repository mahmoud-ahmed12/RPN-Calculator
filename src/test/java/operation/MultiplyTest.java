package operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

@RunWith(MockitoJUnitRunner.class)
public class MultiplyTest {

    @Mock
    private Stack<Double> processingStack;

    @Mock
    private Stack<List<Double>> history;

    Multiply underTest;

    @Before
    public void init() {
        underTest = new Multiply(processingStack, history);
    }

    @Test
    public void canMultiplyTwoNumbers() {
        // Given
        Mockito.when(processingStack.pop()).thenReturn(2D).thenReturn(3D);
        Mockito.when(processingStack.size()).thenReturn(2);

        // When
        Assert.assertTrue(underTest.operate());

        // Then
        ArgumentCaptor<Double> resultCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<List> historyCaptor = ArgumentCaptor.forClass(List.class);

        Mockito.verify(processingStack, Mockito.times(1))
                .push(resultCaptor.capture());
        Mockito.verify(history, Mockito.times(1))
                .push(historyCaptor.capture());

        Assert.assertEquals(6D, resultCaptor.getValue(), 0);
        Assert.assertArrayEquals(List.of(3d, 2d).toArray(), historyCaptor.getValue().toArray());
    }

    @Test
    public void canValidateEnoughOperand() {
        IntStream.of(0,1).forEach(i -> {
            Mockito.when(processingStack.size()).thenReturn(i);
            Assert.assertFalse(underTest.validate());
        });

        Mockito.when(processingStack.size()).thenReturn(2);
        Assert.assertTrue(underTest.validate());
    }
}
