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
public class SqrtTest {

    @Mock
    private Stack<Double> processingStack;

    @Mock
    private Stack<List<Double>> history;

    Sqrt underTest;

    @Before
    public void init() {
        underTest = new Sqrt(processingStack, history);
    }
    @Test
    public void canSqrtNumber() {
        // Given
        Mockito.when(processingStack.pop()).thenReturn(3D);
        Mockito.when(processingStack.size()).thenReturn(1);

        // When
        underTest.operate();

        // Then
        ArgumentCaptor<Double> resultCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<List> historyCaptor = ArgumentCaptor.forClass(List.class);

        Mockito.verify(processingStack, Mockito.times(1))
                .push(resultCaptor.capture());
        Mockito.verify(history, Mockito.times(1))
                .push(historyCaptor.capture());

        Assert.assertEquals(Math.sqrt(3), resultCaptor.getValue(), 0);
        Assert.assertArrayEquals(List.of(3d).toArray(), historyCaptor.getValue().toArray());
    }

    @Test
    public void canValidateEnoughOperand() {
        Mockito.when(processingStack.size()).thenReturn(0);
        Assert.assertFalse(underTest.validate());

        Mockito.when(processingStack.size()).thenReturn(1);
        Assert.assertTrue(underTest.validate());
    }
}
