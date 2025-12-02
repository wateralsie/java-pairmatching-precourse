package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.PairMatchingFunction;

public class OutputView {
    public void printFunctionSelectMenu() {
        System.out.println("기능을 선택하세요.");
        for (PairMatchingFunction func : PairMatchingFunction.values()) {
            System.out.println(func.toString());
        }
    }

    public void printCourseAndMission() {
        System.out.println("#############################################");
        System.out.println("과정: ");
        for (Course course : Course.values()) {
            System.out.printf("%s ", course.getName());
        }
        System.out.println("미션: ");
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
    }
}
