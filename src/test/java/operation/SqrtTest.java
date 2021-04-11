package operation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SqrtTest extends ArithmeticOperatorTest {
    @Before
    public void init() {
        underTest = new Sqrt(processingStack, history);
    }
    @Test
    public void canSqrtNumber() {
        assertOperateOnOneNumber( 3D, Math.sqrt(3D));
    }

    @Test
    public void canValidateEnoughOperand() {
        assertEnoughOperandValidation(1);
    }
}
