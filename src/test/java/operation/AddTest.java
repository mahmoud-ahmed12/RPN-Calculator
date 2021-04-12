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
public class AddTest {

    @Mock
    private Stack<Double> processingStack;

    @Mock
    private Stack<List<Double>> history;

    Add underTest;

    @Before
    public void init() {
        underTest = new Add(processingStack, history);
    }

    @Test
    public void canAddTwoNumbers() {
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

        Assert.assertEquals(5, resultCaptor.getValue(), 0);
        Assert.assertArrayEquals(List.of(3d, 2d).toArray(), historyCaptor.getValue().toArray());

    }

    @Test
    public void canValidateEnoughOperand() {
        Validator validator = (Validator) underTest;
        IntStream.of(0,1).forEach(i -> {
            Mockito.when(processingStack.size()).thenReturn(i);
            Assert.assertFalse(validator.validate());
        });

        Mockito.when(processingStack.size()).thenReturn(2);
        Assert.assertTrue(validator.validate());
    }
}
