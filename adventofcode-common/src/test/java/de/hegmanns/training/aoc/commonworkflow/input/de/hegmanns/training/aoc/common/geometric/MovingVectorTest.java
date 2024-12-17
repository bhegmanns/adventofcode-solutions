package de.hegmanns.training.aoc.commonworkflow.input.de.hegmanns.training.aoc.common.geometric;

import de.hegmanns.training.aoc.common.geometric.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class MovingVectorTest {

    @Nested
    class TurnRightTest {

        @Test
        public void vectorWithDirectionToTopResultsInDirectionLeft() {
            MovingVector toTop = new MovingVector(0, -1);
            Assertions.assertThat(toTop.turnRight()).isEqualTo(new MovingVector(1, 0));
        }
    }

    @Nested
    class OppositeVectorTest {

        @Test
        public void oppositeVectorWithNoDirectionStaysInNoDirection() {
            MovingVector toTop = new MovingVector(0, 0);
            Assertions.assertThat(toTop.opposite()).isEqualTo(new MovingVector(0, 0));
        }

        @Test
        public void oppositeVectorFromDirectionToTopIsDirectionDown() {
            MovingVector toTop = new MovingVector(0, -1);
            Assertions.assertThat(toTop.opposite()).isEqualTo(new MovingVector(0, 1));
        }

        @Test
        public void oppositeVectorFromDirectionToDownIsDirectionTop() {
            MovingVector toTop = new MovingVector(0, 1);
            Assertions.assertThat(toTop.opposite()).isEqualTo(new MovingVector(0, -1));
        }

        @Test
        public void oppoisiteVectorFromDirectionToLeftIsDirectionRight() {
            MovingVector toTop = new MovingVector(-1, 0);
            Assertions.assertThat(toTop.opposite()).isEqualTo(new MovingVector(1, 0));
        }

        @Test
        public void oppositeVectorFromDirectionToRightIsDirectionLeft() {
            MovingVector toTop = new MovingVector(1, 0);
            Assertions.assertThat(toTop.opposite()).isEqualTo(new MovingVector(-1, 0));
        }

        @Test
        public void oppositeVectorFromDirectionToLongWayToButtonIsDirectionToLongWayDown() {
            MovingVector toTop = new MovingVector(0, -Integer.MAX_VALUE);
            Assertions.assertThat(toTop.opposite()).isEqualTo(new MovingVector(0, Integer.MAX_VALUE));
        }

        @ParameterizedTest
        @CsvSource({"1,1,-1,-1", "-1,-1,1,1", "1,-1,-1,1", "-1,1,1,-1"})
        public void diagonalShortTests(int startX, int startY, int endX, int endY) {
            MovingVector toTop = new MovingVector(startX, startY);
            Assertions.assertThat(toTop.opposite()).isEqualTo(new MovingVector(endX, endY));
        }
    }
}
