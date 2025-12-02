package pairmatching.model;

public enum Mission {
    CAR(Level.LEVEL1, "자동차 경주"),
    LOTTO(Level.LEVEL1, "로또"),
    BASEBALL(Level.LEVEL1, "숫자야구게임"),
    CART(Level.LEVEL2, "장바구니"),
    PURCHASE(Level.LEVEL2, "결제"),
    SUBWAY(Level.LEVEL2, "지하철노선도"),
    REFACTOR(Level.LEVEL4, "성능개선"),
    DEPLOY(Level.LEVEL4, "배포"),
    ;

    private Level level;
    private String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }
}
