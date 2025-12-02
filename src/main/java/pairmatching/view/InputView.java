package pairmatching.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputView {
    public List<String> readCrewNames(String fileName) throws IOException {
        String url = String.format("src/main/resources/%s", fileName);
        return Files.readAllLines(Paths.get(url));
    }
}
