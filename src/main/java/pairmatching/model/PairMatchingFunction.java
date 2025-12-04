package pairmatching.model;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PairMatchingFunction {
    MATCHING("1", "페어 매칭"),
    VIEW("2", "페어 조회"),
    RESET("3", "페어 초기화"),
    QUIT("Q", "종료"),
    ;

    public final String shortcut;
    public final String name;

    PairMatchingFunction(String shortcut, String name) {
        this.shortcut = shortcut;
        this.name = name;
    }

    public static PairMatchingFunction from(String shortcut) {
        validate(shortcut);
        return BY_SHORTCUT.get(shortcut);
    }

    private static void validate(String shortcut) {
        validateShortcut(shortcut);
    }

    private static void validateShortcut(String shortcut) {
        if (!BY_SHORTCUT.containsKey(shortcut)) {
            throw new IllegalArgumentException(String.format("[ERROR] 존재하지 않는 기능 번호입니다 : %s", shortcut));
        }
    }

    private String getShortcut() {
        return shortcut;
    }

    private static final Map<String, PairMatchingFunction> BY_SHORTCUT =
            Stream.of(values()).collect(Collectors.toMap(PairMatchingFunction::getShortcut, Function.identity()));

    @Override
    public String toString() {
        return String.format("%s. %s", shortcut, name);
    }
}
