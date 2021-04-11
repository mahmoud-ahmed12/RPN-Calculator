package operation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SqrtTest extends OperationTest {
    @Before
    public void init() {
        underTest = new Sqrt(processingStack, history);
    }
    @Test
    public void canSqrtNumber() {
        canOperateOnOneNumber( 3D, Math.sqrt(3D));
    }

    @Test
    public void canValidateEnoughOperand() {
        canValidateEnoughOperand(1);
    }
}
