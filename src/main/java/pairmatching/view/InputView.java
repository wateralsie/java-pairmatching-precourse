package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import pairmatching.model.PairMatchingFunction;

public class InputView {
    public List<String> readCrewNames(String fileName) {
        String url = String.format("src/main/resources/%s", fileName);
        try {
            return Files.readAllLines(Paths.get(url));
        } catch (IOException e) {
            throw new RuntimeException(String.format("[ERROR] 파일을 불러오는데 실패했습니다 : %s", fileName));
        }
    }

    public PairMatchingFunction readFunctionSelection() {
        String shortcut = Console.readLine();
        return PairMatchingFunction.from(shortcut);
    }

    public List<String> readCriteria() {
        String criterias = Console.readLine();
        return Arrays.stream(criterias.split(", ")).toList();
    }
}
