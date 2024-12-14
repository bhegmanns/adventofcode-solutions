package de.hegmanns.training.aoc2022.day12;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTreeTest {

    @Test
    void gatherNewSquareOnFullSolutionTreeThrowsException() {
        SolutionTree solutionTree = new SolutionTree();
        Square squareByCoordinates = solutionTree.getSquareByCoordinates(1, 1);
        solutionTree.arrangePossibleSteps();
        Assertions.assertThrows(RuntimeException.class, () -> {
            solutionTree.getSquareByCoordinates(2, 2);
        });
    }

    @Test
    void gatherSquareOnAlreadyCalculatedSquare() {
        SolutionTree solutionTree = new SolutionTree();
        Square squareByCoordinates = solutionTree.getSquareByCoordinates(1, 1);
        squareByCoordinates = solutionTree.getSquareByCoordinates(2, 2);
        solutionTree.getSquareByCoordinates(4, 4);

        MatcherAssert.assertThat(solutionTree.getSquareByCoordinates(2,2), Matchers.sameInstance(squareByCoordinates));
    }

    @Test
    void gatherSquareOnFullSolutionTree() {
        SolutionTree solutionTree = new SolutionTree();
        Square squareByCoordinates = solutionTree.getSquareByCoordinates(1, 1);
        squareByCoordinates = solutionTree.getSquareByCoordinates(2, 2);
        solutionTree.getSquareByCoordinates(4, 4);
        solutionTree.arrangePossibleSteps();

        Square squareByCoordinates1 = solutionTree.getSquareByCoordinates(2, 2);
        MatcherAssert.assertThat(squareByCoordinates1, Matchers.equalTo(squareByCoordinates));
    }
}
