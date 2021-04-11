package operation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MultiplyTest extends ArithmeticOperatorTest {
    @Before
    public void init() {
        underTest = new Multiply(processingStack, history);
    }

    @Test
    public void canMultiplyTwoNumbers() {
        assertOperateOnTwoNumbers(2D, 3D, 6D);
    }

    @Test
    public void canValidateEnoughOperand() {
        assertEnoughOperandValidation(2);
    }
}
