package view;

import domain.service.Answer;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final Answer answer;

    public InputView() {
        scanner = new Scanner(System.in);
        answer = new Answer();
    }

    public String receiveGameState() {
        try {
            String input = scanner.nextLine();
            answer.validation(input);
            return input;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return receiveGameState();
        }
    }
}
