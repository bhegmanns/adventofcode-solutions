package de.hegmanns.training.aoc2024.day05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.*;

public class PageOrderingRulesTest {

    @Test
    public void findTheOnlyRightRelevantRule() {

        PageOrderingRule pageOrderingRule1 = new PageOrderingRule(1, 2);
        PageOrderingRule pageOrderingRule2 = new PageOrderingRule(2, 3);
        PageOrderingRules rules = new PageOrderingRules(Arrays.asList(pageOrderingRule1, pageOrderingRule2));
        Update update = new Update(Arrays.asList(1, 2));

        Set<PageOrderingRule> rules1 = rules.gatherAllRelevantRules(update);
        Assertions.assertThat(rules1).hasSize(1);
        Assertions.assertThat(rules1).contains(pageOrderingRule1);
    }
}
