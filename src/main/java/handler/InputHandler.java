package handler;


import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class InputHandler {
    private Scanner input;

    public String[] handleUserInput() {
        String userInput = input.nextLine();
        return userInput.split(" ");
    }

    public boolean hasNextInput() {
        return input.hasNextLine();
    }
}
