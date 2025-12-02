package pairmatching.view;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.List;

public class PairMatchingController {
    private final InputView inputView;

    public PairMatchingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> backendCrewNames, frontendCrewNames;
        try {
            backendCrewNames = inputView.readCrewNames("backend-crew.md");
            frontendCrewNames = inputView.readCrewNames("frontend-crew.md");
            System.out.println(backendCrewNames);
            System.out.println(frontendCrewNames);
        } catch (IOException e) {
            throw new RuntimeException("[ERROR] 파일을 불러오는데 실패했습니다.");
        }
    }
}
