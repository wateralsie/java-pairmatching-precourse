package pairmatching.view;

import java.io.IOException;
import java.util.List;
import pairmatching.model.PairMatchingFunction;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> backendCrewNames, frontendCrewNames;
        try {
            backendCrewNames = inputView.readCrewNames("backend-crew.md");
            frontendCrewNames = inputView.readCrewNames("frontend-crew.md");
        } catch (IOException e) {
            throw new RuntimeException("[ERROR] 파일을 불러오는데 실패했습니다.");
        }
        selectFunction();
        selectCriteria();
    }

    public PairMatchingFunction selectFunction() {
        outputView.printFunctionSelectMenu();
        return inputView.readFunctionSelection();
    }

    public void selectCriteria() {
        outputView.printCourseAndMission();
        System.out.println(inputView.readCriteria());
    }
}
