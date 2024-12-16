package de.hegmanns.training.aoc2024.day05;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
public class PageOrderingRules {
    private final List<PageOrderingRule> rules = new ArrayList<>();


    public PageOrderingRules(Collection<PageOrderingRule> pageOrderingRules) {
        this.rules.addAll(pageOrderingRules);
    }

    private boolean containsMatchingRule(long firstNumber, long secondNumber){
        return rules.stream()
                .anyMatch(pr -> pr.getBefore()==firstNumber && pr.getAfter()==secondNumber);
    }


    public List<PageOrderingRule> getRules(int firstPageNumber, int secondPageNumber) {
        return rules.stream()
                .filter(pr -> pr.contains(firstPageNumber) && pr.contains(secondPageNumber))
                .collect(Collectors.toList());
    }


    public Set<PageOrderingRule> gatherAllRelevantRules(Update update) {
        Set<PageOrderingRule> relevantRules = new HashSet<>();
        List<Integer> pages = update.getPages();
        for (var rule : rules) {
            if (pages.contains(rule.getBefore()) && pages.contains(rule.getAfter())) {
                relevantRules.add(rule);
            }
        }


        return relevantRules;
    }

    public static Comparator<PageOrderingRule> getComparator() {
        return new Comparator<PageOrderingRule>() {
            @Override
            public int compare(PageOrderingRule o1, PageOrderingRule o2) {
                if (o1.getBefore() == o2.getBefore()) {
                    return o1.getAfter() - o2.getAfter();
                } else {
                    return o1.getBefore() - o2.getBefore();
                }
            }
        };
    }

    public boolean isMatching(Update update) {
        int size = update.getPages().size();
        boolean matching = true;
        for (int i = 0 ; i < size - 1 ; i++) {

            for (int j = i + 1 ; j < size ; j++) {
                long firstNumber = update.getPages().get(i);
                long secondNumber = update.getPages().get(j);
                if (!containsMatchingRule(firstNumber, secondNumber)) {
                    matching = false;
                    break;
                }
            }
        }
        return matching;
    }
}
