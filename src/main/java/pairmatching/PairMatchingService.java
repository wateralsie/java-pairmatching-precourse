package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Pair;
import pairmatching.model.PairCriteria;

public class PairMatchingService {
    private final Map<PairCriteria, List<Pair>> pairMatchingArchive = new HashMap<>();
    private final Map<Course, List<Crew>> crews = new HashMap<>();

    public List<Pair> start(PairCriteria criteria, List<String> backendNames, List<String> frontendNames) {
        initCrews(backendNames, frontendNames);
        List<Pair> matchedPairs = match(criteria);
        pairMatchingArchive.put(criteria, matchedPairs);
        return matchedPairs;
    }

    public List<Pair> match(PairCriteria criteria) {
        List<Crew> selectedCrews = shuffle(crews.get(criteria.getCourse()));
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < selectedCrews.size(); i += 2) {
            if (i == selectedCrews.size() - 1) {
                pairs.getLast().add(selectedCrews.get(i));
                break;
            }
            Pair pair = new Pair();
            pair.add(selectedCrews.get(i));
            pair.add(selectedCrews.get(i + 1));
            pairs.add(pair);
        }
        return pairs;
    }

    public void initCrews(List<String> backendNames, List<String> frontendNames) {
        List<Crew> backendCrews = backendNames.stream().map(name -> new Crew(Course.BACKEND, name)).toList();
        List<Crew> frontendCrews = frontendNames.stream().map(name -> new Crew(Course.FRONTEND, name)).toList();
        crews.put(Course.BACKEND, backendCrews);
        crews.put(Course.FRONTEND, frontendCrews);
    }

    public List<Crew> shuffle(List<Crew> crews) {
        return Randoms.shuffle(crews);
    }
}
