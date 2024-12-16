package de.hegmanns.training.aoc2024.day05;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@ToString
public class Update {
    private List<Integer> pages = new ArrayList<>();



    public Integer getMiddleNumber() {
        return pages.get(pages.size()/2);
    }

    public Update rebuild(Set<PageOrderingRule> relevantRules) {
        List<PageOrderingRule> list = relevantRules.stream().sorted(PageOrderingRules.getComparator()).toList();

        PageOrderingRules pageOrderingRules = new PageOrderingRules(relevantRules);
        List<Long> newPages = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(pages.get(0));
        for (int i = 1 ; i < pages.size() ; i++) {
            List<PageOrderingRule> rules = pageOrderingRules.getRules(pages.get(i - 1), pages.get(i));

            if (rules.size() == 1) {
                PageOrderingRule rule = rules.get(0);
                if (rule.getBefore() == stack.peek()) {
                    stack.pop();
                    stack.push(rule.getAfter());
                } else {
                    stack.push(rule.getBefore());
                }
            } else {
                throw new RuntimeException("More than one rule found for page " + pages.get(i));
            }
            System.out.println(rules);
        }
        //stack.add();


        return null;
    }
}
