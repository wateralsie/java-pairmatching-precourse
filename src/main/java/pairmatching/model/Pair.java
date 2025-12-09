package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> crews;

    public Pair() {
        this.crews = new ArrayList<>();
    }

    public void add(Crew crew) {
        crews.add(crew);
    }

    @Override
    public String toString() {
        return crews.stream()
                .map(Crew::name)
                .collect(Collectors.joining(" : "));
    }
}
