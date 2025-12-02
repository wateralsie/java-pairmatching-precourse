package pairmatching;

import pairmatching.view.InputView;
import pairmatching.view.PairMatchingController;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PairMatchingController controller = new PairMatchingController(inputView);

        controller.run();
    }
}
