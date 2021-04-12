package operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Stack;

@RunWith(MockitoJUnitRunner.class)
public class ClearTest  {

    @Mock
    protected Stack<Double> processingStack;
    @Mock
    protected Stack<List<Double>> history;

    protected Clear underTest;

    @Before
    public void init() {
        underTest = new Clear(processingStack, history);
    }

    @Test
    public void canClearStackAndHistory() {
        Assert.assertTrue(underTest.operate());
        Mockito.verify(processingStack, Mockito.times(1)).clear();
        Mockito.verify(history, Mockito.times(1)).clear();
    }

}
