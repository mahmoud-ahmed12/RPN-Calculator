package handler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

public class OutputHandlerTest {
    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private OutputHandler underTest;
    private Stack<Double> testStack;

    @Before
    public void init() {
        outStream = new ByteArrayOutputStream();
        testStack = new Stack<Double>();
        underTest = new OutputHandler(testStack, (new PrintStream(outStream)));
    }

    @Test
    public void canPrintStackContent() {
        testStack.push(2d);
        testStack.push(3d);
        testStack.push(4d);
        underTest.displayStack();
        Assert.assertEquals("stack: 2 3 4 \n", outStream.toString());
    }

    @Test
    public void canDisplayMessage() {
        underTest.displayMessage("test display message");
        Assert.assertEquals("test display message\n", outStream.toString());
    }
}
