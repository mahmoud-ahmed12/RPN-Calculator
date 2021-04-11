package handler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class InputHandlerTest {

    private Scanner input;

    InputHandler underTest;

    @Test
    public void canHandleUserInput() {
        mockUserInput("1 2 3 4 +");
        String[] expectedOutput = {"1", "2", "3", "4", "+"};
        String[] output = underTest.handleUserInput();
        Assert.assertArrayEquals(expectedOutput, output);
        Assert.assertFalse(underTest.hasNextInput());
    }

    @Test
    public void canCheckForNextInput() {
        mockUserInput("1 2 3");
        Assert.assertTrue(underTest.hasNextInput());
    }

    private void mockUserInput(String userInput) {
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        input = new Scanner(in);
        underTest = new InputHandler(input);
    }
}
