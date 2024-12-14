package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc2023.day21.GardenRockMapCreator;
import de.hegmanns.training.aoc2023.day21.GardenRockMapSolutioner;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static de.hegmanns.training.aoc2023.SolutionDay21.getSolutionInstance;

public class SolutionDay21Test {

    public List<String> getTestInputAsList() {
        return AoCFileReader.getInputAsList(SolutionDay21.class, "day21e.txt");
    }

    @Test
    public void exampleForPart1() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(getTestInputAsList());

        Long countOfPossibleReachedGardensAfterSteps = GardenRockMapSolutioner.getCountOfPossibleReachedGardensAfterSteps(gardenRockMapCreator.getGardenRockMap(), gardenRockMapCreator.getStartPosition(), 6);

        MatcherAssert.assertThat(countOfPossibleReachedGardensAfterSteps, Matchers.equalTo(16L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = getTestInputAsList();

        MatcherAssert.assertThat(getSolutionInstance().solvePart2(inputAsList), Matchers.equalTo(405L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat(getSolutionInstance().getSolution1(), Matchers.equalTo(3646L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(getSolutionInstance().getSolution2(), Matchers.equalTo(632003913611L));
    }
}
