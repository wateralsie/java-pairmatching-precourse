package pairmatching.model;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    private static final Map<String, Level> BY_NAME =
            Stream.of(values()).collect(Collectors.toMap(Level::getName, Function.identity()));

    Level(String name) {
        this.name = name;
    }

    public static Level getLevelByName(String name) {
        if (!BY_NAME.containsKey(name)) {
            throw new IllegalArgumentException(String.format("[ERROR] 입력하신 레벨은 존재하지 않습니다 : %s", name));
        }
        return BY_NAME.get(name);
    }

    public String getName() {
        return name;
    }
}
