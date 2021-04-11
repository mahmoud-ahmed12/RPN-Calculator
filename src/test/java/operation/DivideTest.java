package operation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DivideTest extends ArithmeticOperatorTest {
    @Before
    public void init() {
        underTest = new Divide(processingStack, history);
    }
    @Test
    public void canDivideTwoNumbers() {
        assertOperateOnTwoNumbers(2D, 3D, 1.5);
    }

    @Test
    public void canValidateEnoughOperand() {
        assertEnoughOperandValidation(2);
    }
}
