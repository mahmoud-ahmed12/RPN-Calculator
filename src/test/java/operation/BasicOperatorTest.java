package operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class BasicOperatorTest extends OperationTest {

    @Before
    public void init() {
        underTest = new BasicOperator(processingStack, history);
        ((BasicOperator)underTest).setNumber(3D);
    }

    @Test
    public void canPushNumberToStack() {
        Assert.assertTrue(underTest.operate());
        Mockito.verify(processingStack, Mockito.times(1)).push(3D);
        Mockito.verify(history, Mockito.times(1)).push(Collections.emptyList());
    }

}
