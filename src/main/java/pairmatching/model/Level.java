package pairmatching.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", Collections.emptyList());

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static String getAllInfosAsString() {
        return Arrays.stream(values())
                .map(level -> String.format("  - %s: %s", level.name, level.getMissionsAsString()))
                .collect(Collectors.joining("\n"));
    }

    private String getMissionsAsString() {
        return String.join(" | ", missions);
    }
}
