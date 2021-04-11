package operation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DivideTest extends OperationTest {
    @Before
    public void init() {
        underTest = new Divide(processingStack, history);
    }
    @Test
    public void canDivideTwoNumbers() {
        canOperateOnTwoNumbers(2D, 3D, 3D/2D);
    }

    @Test
    public void canValidateEnoughOperand() {
        canValidateEnoughOperand(2);
    }
}
