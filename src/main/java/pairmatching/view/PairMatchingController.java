package pairmatching.view;

import java.util.List;
import pairmatching.PairMatchingService;
import pairmatching.model.Course;
import pairmatching.model.Mission;
import pairmatching.model.Pair;
import pairmatching.model.PairCriteria;
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
        PairMatchingService pairMatchingService = new PairMatchingService();
        while (true) {
            PairMatchingFunction selectedFunction = selectFunction();
            if (selectedFunction == PairMatchingFunction.MATCHING) {
                List<Pair> pairs = pairMatchingService.match(selectCriteria(), backendCrewNames, frontendCrewNames);
                for (Pair pair : pairs) {
                    System.out.println(pair);
                }
                continue;
            }
            if (selectedFunction == PairMatchingFunction.VIEW) {
                List<Pair> pairs = pairMatchingService.view(selectCriteria());
                for (Pair pair : pairs) {
                    System.out.println(pair);
                }
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

    public PairCriteria selectCriteria() {
        outputView.printCourseAndMission();
        List<String> criteriaNames = inputView.readCriteria();
        Course course = Course.getCourseByName(criteriaNames.getFirst());
        Mission mission = Mission.getMission(criteriaNames.get(1), criteriaNames.getLast());
        PairCriteria criteria = new PairCriteria(course, mission);
        return criteria;
    }
}
