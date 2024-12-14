package de.hegmanns.training.aoc2023.day05;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MappingRuleTest {

    @Test
    public void builderWorks() {
        MappingRule.MappingRuleBuilder builder = MappingRule.MappingRuleBuilder.create("seed-to-soil");
        builder.withDefinitionLine("50 98 2");
        builder.withDefinitionLine("2 50 48");

        MappingRule mappingRule = builder.build();

        MatcherAssert.assertThat(mappingRule.getFrom(), Matchers.is("seed"));
        MatcherAssert.assertThat(mappingRule.getTo(), Matchers.is("soil"));
    }

    @ParameterizedTest
    @CsvSource({"50, 52", "98, 50", "99, 51", "100, 100", "101, 101","97, 99", "79, 81", "14, 14", "49, 49", "55,57", "13, 13"})
    public void findOilForSeed(long from, long expectedCorresponding) {
        MappingRule.MappingRuleBuilder builder = MappingRule.MappingRuleBuilder.create("seed-to-soil");
        builder.withDefinitionLine("50 98 2");
        builder.withDefinitionLine("52 50 48");

        MappingRule mappingRule = builder.build();

        long corresponding = mappingRule.getCorresponding(from);
        MatcherAssert.assertThat(corresponding, Matchers.is(expectedCorresponding));

    }

    @Test
    void foo(){
        MappingRule.MappingRuleBuilder builder = MappingRule.MappingRuleBuilder.create("seed-to-soil");
        builder.withDefinitionLine("50 98 2");
        builder.withDefinitionLine("52 50 48");

        MappingRule mappingRule = builder.build();

        long corresponding = mappingRule.getCorresponding(55L);
        MatcherAssert.assertThat(corresponding, Matchers.is(57L));

    }
}
