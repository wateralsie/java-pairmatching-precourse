package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import pairmatching.model.PairMatchingFunction;

public class InputView {
    public List<String> readCrewNames(String fileName) throws IOException {
        String url = String.format("src/main/resources/%s", fileName);
        return Files.readAllLines(Paths.get(url));
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
