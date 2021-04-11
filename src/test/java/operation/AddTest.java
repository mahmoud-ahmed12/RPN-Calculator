package operation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddTest extends ArithmeticOperatorTest {

    @Before
    public void init() {
        underTest = new Add(processingStack, history);
    }

    @Test
    public void canAddTwoNumbers() {
        assertOperateOnTwoNumbers(2D, 3D, 5D);
    }

    @Test
    public void canValidateEnoughOperand() {
        assertEnoughOperandValidation(2);
    }
}
