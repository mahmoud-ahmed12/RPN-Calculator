package operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClearTest extends OperatorTest {

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
