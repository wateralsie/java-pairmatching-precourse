package pairmatching.view;

import pairmatching.model.PairMatchingFunction;

public class OutputView {
    public void printFunctionSelectMenu() {
        System.out.println("기능을 선택하세요.");
        for (PairMatchingFunction func : PairMatchingFunction.values()) {
            System.out.println(func.toString());
        }
    }
}
