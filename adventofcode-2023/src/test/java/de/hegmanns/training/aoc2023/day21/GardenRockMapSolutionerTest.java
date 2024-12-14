package de.hegmanns.training.aoc2023.day21;

import de.hegmanns.training.aoc2023.SolutionDay21Test;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class GardenRockMapSolutionerTest {

    @Test
    public void correctWidthAndHeight() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());
        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();

        Assertions.assertAll(
                () -> {MatcherAssert.assertThat("height", gardenRockMap.getHeight(), Matchers.is(11));},
                () -> {MatcherAssert.assertThat("width", gardenRockMap.getWidth(), Matchers.is(11));}
        );
    }

    @Test
    public void correctStartPosition() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());
        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();

        MatcherAssert.assertThat(gardenRockMapCreator.getStartPosition(), Matchers.equalTo(new MapPosition(6,6)));
    }

    @Test
    public void ZeroPositionThrowsException() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());
        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();

        MapPosition startPosition = new MapPosition(0, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> gardenRockMap.getPossibleReachablePositionInNextStep(startPosition));
    }

    @Test
    public void MaxPositionThrowsException() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());

        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();
        MapPosition startPosition = new MapPosition(gardenRockMap.getWidth()+1, gardenRockMap.getHeight()+1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> gardenRockMap.getPossibleReachablePositionInNextStep(startPosition));
    }

    @Test
    public void Position_11_11_ThrowsException() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());

        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();
        MapPosition startPosition = new MapPosition(12,12);

        Assertions.assertThrows(IllegalArgumentException.class, () -> gardenRockMap.getPossibleReachablePositionInNextStep(startPosition));
    }

    @Test
    public void leftUppperCorner() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());

        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();
        MapPosition startPosition = new MapPosition(1, 1);

        List<MapPosition> possibleReachablePositionInNextStep = gardenRockMap.getPossibleReachablePositionInNextStep(startPosition);

        MatcherAssert.assertThat(possibleReachablePositionInNextStep, Matchers.containsInAnyOrder(new MapPosition(1, 2), new MapPosition(2, 1)));
    }

    @Test
    public void rightBottomCorner() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());

        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();
        MapPosition startPosition = new MapPosition(gardenRockMap.getWidth(), gardenRockMap.getHeight());

        List<MapPosition> possibleReachablePositionInNextStep = gardenRockMap.getPossibleReachablePositionInNextStep(startPosition);

        MatcherAssert.assertThat(possibleReachablePositionInNextStep, Matchers.containsInAnyOrder(new MapPosition(10,11), new MapPosition(11,10)));
    }
    /*
    In exactly 6 steps, he can still reach 16 garden plots.
In exactly 10 steps, he can reach any of 50 garden plots.
In exactly 50 steps, he can reach 1594 garden plots.
In exactly 100 steps, he can reach 6536 garden plots.
In exactly 500 steps, he can reach 167004 garden plots.
In exactly 1000 steps, he can reach 668697 garden plots.
In exactly 5000 steps, he can reach 16733044 garden plots.
     */

//    @ParameterizedTest
//    @CsvSource({"6, 16", "10, 50", "50, 1594", "100, 6536", "500, 167004", "1000, 668697", "5000, 16733044"})
    public void withExpansion(int steps, long expectedGardenPlots) {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());
        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();
        MapPosition startPosition = gardenRockMapCreator.getStartPosition();

        Long countOfPossibleReachedGardensAfterSteps = GardenRockMapSolutioner.getCountOfPossibleReachedGardensAfterSteps(gardenRockMap, startPosition, steps, true);
        MatcherAssert.assertThat(countOfPossibleReachedGardensAfterSteps, Matchers.is(expectedGardenPlots));
    }

    @Test
    public void withExpansion10Steps() {
        GardenRockMapCreator gardenRockMapCreator = new GardenRockMapCreator(new SolutionDay21Test().getTestInputAsList());
        GardenRockMap gardenRockMap = gardenRockMapCreator.getGardenRockMap();
        MapPosition startPosition = gardenRockMapCreator.getStartPosition();

        Long countOfPossibleReachedGardensAfterSteps = GardenRockMapSolutioner.getCountOfPossibleReachedGardensAfterSteps(gardenRockMap, startPosition, 10, true);
        MatcherAssert.assertThat(countOfPossibleReachedGardensAfterSteps, Matchers.is(50L));
    }


}
