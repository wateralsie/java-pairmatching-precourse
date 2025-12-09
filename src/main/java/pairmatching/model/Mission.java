package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Mission {
    CAR_RACING("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),
    CART("장바구니", Level.LEVEL2),
    PURCHASE("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    REFACTOR("성능개선", Level.LEVEL4),
    DEPLOY("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission getMission(String level, String mission) {
        Level lv = Level.getLevelByName(level);
        if (!NAME_LEVEL.containsKey(mission)) {
            throw new IllegalArgumentException(String.format("[ERROR] 입력하신 미션은 존재하지 않습니다 : %s", mission));
        }
        if (!NAME_LEVEL.get(mission).equals(lv)) {
            throw new IllegalArgumentException(String.format("[ERROR] 입력하신 미션은 %s에 존재하지 않습니다 : %s", level, mission));
        }
        return BY_NAME.get(mission);
    }

    public static Map<Level, List<String>> getMissionNameByLevel() {
        return Arrays.stream(values())
                .collect(Collectors.groupingBy(Mission::getLevel,
                        Collectors.mapping(Mission::getName, Collectors.toList())));
    }

    private static final Map<String, Level> NAME_LEVEL =
            Stream.of(values()).collect(Collectors.toMap(Mission::getName, Mission::getLevel));

    private static final Map<String, Mission> BY_NAME =
            Stream.of(values()).collect(Collectors.toMap(Mission::getName, Function.identity()));

    private String getName() {
        return name;
    }

    private Level getLevel() {
        return level;
    }
}
