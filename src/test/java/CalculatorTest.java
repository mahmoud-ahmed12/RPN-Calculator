import exception.InsufficientParameterException;
import exception.InvalidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatorTest {

    static Calculator underTest = new Calculator();

    @Before
    public void init() {
        underTest.initCalculator();
    }

    @Test
    public void t1_canAddTwoNumbers() throws Exception {
        // Given
        String[] input = {"1", "2", "+"};

        // When
        underTest.evaluate(input);

        // Then
        Assert.assertEquals(3, underTest.getProcessingStack().peek(), 0);
    }

    @Test
    public void t2_canSubtractTwoNumbers() throws Exception {
        // Given
        String[] input = {"1", "2", "-"};

        // When
        underTest.evaluate(input);

        // Then
        Assert.assertEquals(-1, underTest.getProcessingStack().peek(), 0);
    }

    @Test
    public void t3_canMultiplyTwoNumbers() throws Exception {
        // Given
        String[] input = {"2", "3", "*"};

        // When
        underTest.evaluate(input);

        // Then
        Assert.assertEquals(6, underTest.getProcessingStack().peek(), 0);
    }

    @Test
    public void t4_canDivideTwoNumbers() throws Exception {
        // Given
        String[] input = {"3", "2", "/"};

        // When
        underTest.evaluate(input);

        // Then
        Assert.assertEquals(1.5, underTest.getProcessingStack().peek(), 0);
    }

    @Test
    public void t5_canSqrtNumber() throws Exception {
        // Given
        String[] input = {"3", "sqrt"};

        // When
        underTest.evaluate(input);

        // Then
        Assert.assertEquals(Math.sqrt(3), underTest.getProcessingStack().peek(), 0);
    }

    @Test
    public void t6_canUndoLastOperation() throws Exception {
        // Given
        String[] input = {"undo"};
        Assert.assertEquals(5, underTest.getProcessingStack().size());
        Assert.assertEquals(Math.sqrt(3), underTest.getProcessingStack().peek(), 0);

        // When
        underTest.evaluate(input);

        // Then
        Assert.assertEquals(5, underTest.getProcessingStack().size());
        Assert.assertEquals(3, underTest.getProcessingStack().peek(), 0);
    }

    @Test
    public void t7_canClearCalculator() throws Exception{
        // Given
        String[] input = {"clear"};
        Assert.assertEquals(5, underTest.getProcessingStack().size());

        // When
        underTest.evaluate(input);

        // Then
        Assert.assertEquals(0, underTest.getProcessingStack().size());
    }

    @Test
    public void t7_canValidateOperator() throws Exception {
        // Given
        String[] input = {"1", "*", "2", "3" };
        Assert.assertEquals(0, underTest.getProcessingStack().size());

        try {
            // When
            underTest.evaluate(input);

        // Then
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), InsufficientParameterException.class);
            Assert.assertEquals("Operator * (position: 3): insufficient parameters", e.getMessage());
        }
        Assert.assertEquals(1, underTest.getProcessingStack().size());
    }

    @Test
    public void t8_canValidateInput() {
        // Given
        String[] input = {"1", "3", "#", "3" };
        Assert.assertEquals(1, underTest.getProcessingStack().size());

        try {
            // When
            underTest.evaluate(input);

        // Then
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), InvalidInputException.class);
            Assert.assertEquals("Not recognized input # (position: 5)", e.getMessage());
        }
        Assert.assertEquals(3, underTest.getProcessingStack().size());
    }
}
