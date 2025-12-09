package pairmatching.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.PairMatchingFunction;

public class OutputView {
    public void printFunctionSelectMenu() {
        System.out.println();
        System.out.println("기능을 선택하세요.");
        for (PairMatchingFunction func : PairMatchingFunction.values()) {
            System.out.println(func.toString());
        }
    }

    public void printCourseAndMission() {
        System.out.println();
        System.out.println("#############################################");
        System.out.printf("과정: %s%n", Course.getAllNamesAsString());
        printMission();
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
    }

    public void printMission() {
        System.out.println("미션: ");
        System.out.println();
        Map<Level, List<String>> missions = Mission.getMissionNameByLevel();
        for (Level level : Level.values()) {
            String missionNames = String.join(" | ", missions.getOrDefault(level, Collections.emptyList()));
            System.out.printf("  - %s: %s%n", level.getName(), missionNames);
        }
        System.out.println();
    }
}
