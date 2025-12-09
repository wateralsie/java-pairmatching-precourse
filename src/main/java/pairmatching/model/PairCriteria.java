package pairmatching.model;

import java.util.Objects;

public class PairCriteria {
    private final Course course;
    private final Mission mission;

    public PairCriteria(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PairCriteria that)) {
            return false;
        }
        return course == that.course && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }
}
