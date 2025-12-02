package pairmatching;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.PairMatchingController;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        PairMatchingController controller = new PairMatchingController(inputView, outputView);

        controller.run();
    }
}
