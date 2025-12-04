package pairmatching.view;

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
        List<String> backendCrewNames = inputView.readCrewNames("backend-crew.md");
        List<String> frontendCrewNames = inputView.readCrewNames("frontend-crew.md");
        while (true) {
            PairMatchingFunction selectedFunction = selectFunction();
            if (selectedFunction == PairMatchingFunction.MATCHING) {
                selectCriteria();
                // TODO: 페어 매칭 로직
                // TODO: 페어 매칭 결과 출력
                continue;
            }
            if (selectedFunction == PairMatchingFunction.VIEW) {
                selectCriteria();
                // TODO: 페어 매칭 결과 출력
                continue;
            }
            if (selectedFunction == PairMatchingFunction.RESET) {
                // TODO: 저장된 페어 매칭 내역 전체 삭제
                continue;
            }
            if (selectedFunction == PairMatchingFunction.QUIT) {
                break;
            }
        }
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
