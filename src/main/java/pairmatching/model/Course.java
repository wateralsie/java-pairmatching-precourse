package pairmatching.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static String getAllNamesAsString() {
        return Arrays.stream(values())
                .map(Course::getName)
                .collect(Collectors.joining(" | "));
    }

    private String getName() {
        return name;
    }
}
