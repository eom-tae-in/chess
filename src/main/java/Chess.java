import controller.Controller;
import domain.service.Answer;
import view.InputView;
import view.OutputView;

public class Chess {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), new Answer());
        controller.start();
    }
}
