package pairmatching.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourseByName(String name) {
        if (!BY_NAME.containsKey(name)) {
            throw new IllegalArgumentException(String.format("[ERROR] 입력하신 과정은 존재하지 않습니다 : %s", name));
        }
        return BY_NAME.get(name);
    }

    private static final Map<String, Course> BY_NAME =
            Stream.of(values()).collect(Collectors.toMap(Course::getName, Function.identity()));

    public static String getAllNamesAsString() {
        return Arrays.stream(values())
                .map(Course::getName)
                .collect(Collectors.joining(" | "));
    }

    private String getName() {
        return name;
    }
}
