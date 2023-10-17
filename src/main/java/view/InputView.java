package view;

import domain.Answer;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String receiveGameState() {
        try {
            String input = scanner.nextLine();
            Answer.validation(input);
            return input;
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            return receiveGameState();
        }
    }
}
