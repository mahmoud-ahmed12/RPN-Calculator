package operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubtractTest extends OperationTest {

    @Before
    public void init() {
        underTest = new Subtract(processingStack, history);
    }

    @Test
    public void canSubtractTwoNumbers() {
        canOperateOnTwoNumbers(2D, 3D, 1D);

    }

    @Test
    public void canValidateEnoughOperand() {
        canValidateEnoughOperand(2);
    }
}
