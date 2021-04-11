import exception.InsufficientParameterException;
import exception.InvalidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Calculator underTest;

    @Before
    public void init() {
        underTest = new Calculator();
        underTest.initCalculator();
    }

    @Test
    public void canAddTwoNumbers() throws Exception {
        String[] input = {"1", "2", "+"};
        assertEvaluate(input, 3D);
    }

    @Test
    public void canSubtractTwoNumbers() throws Exception {
        String[] input = {"1", "2", "-"};
        assertEvaluate(input, -1D);
    }

    @Test
    public void canMultiplyTwoNumbers() throws Exception {
        String[] input = {"2", "3", "*"};
        assertEvaluate(input, 6D);
    }

    @Test
    public void canDivideTwoNumbers() throws Exception {
        String[] input = {"3", "2", "/"};
        assertEvaluate(input, 1.5);
    }

    @Test
    public void canSqrtNumber() throws Exception {
        String[] input = {"3", "sqrt"};
        assertEvaluate(input, Math.sqrt(3));
    }

    @Test
    public void canValidateOperator() throws Exception {
        String[] input = {"1", "*", "2", "3" };
        try {
            underTest.evaluate(input);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), InsufficientParameterException.class);
            Assert.assertEquals("Operator * (position: 3): insufficient parameters", e.getMessage());
        }
        Assert.assertEquals(1, underTest.getProcessingStack().size());
    }

    @Test
    public void canValidateInput() {
        String[] input = {"1", "3", "#", "3" };
        try {
            underTest.evaluate(input);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), InvalidInputException.class);
            Assert.assertEquals("Not recognized input # (position: 5)", e.getMessage());
        }
        Assert.assertEquals(2, underTest.getProcessingStack().size());
    }

    private void assertEvaluate(String[] input, double expected) throws Exception {
        underTest.evaluate(input);
        Assert.assertEquals(expected, underTest.getProcessingStack().peek(), 0D);
    }
}
