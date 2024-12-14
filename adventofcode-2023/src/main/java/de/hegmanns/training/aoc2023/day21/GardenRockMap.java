package de.hegmanns.training.aoc2023.day21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GardenRockMap {
    private int initialWidth;
    private int initialHeight;

    private int width;
    private int height;

    private int leftFactor = 0;
    private int rightFactor = 1;
    private int topFactor = 0;
    private int bottomFactor = 1;

    private Set<MapPosition> rockPositions = new HashSet<>();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Set<MapPosition> getRockPositions() {
        return rockPositions;
    }

    public GardenRockMap(int initialWidth, int initialHeight) {
        this.initialHeight = initialHeight;
        this.initialWidth = initialWidth;
        this.height = initialHeight;
        this.width = initialWidth;
    }

    public List<MapDirection> getOverflows(MapPosition position) {
        List<MapDirection> result = new ArrayList<>(2);

        if (position.x() < -this.width * leftFactor + 1) {
            result.add(MapDirection.LEFT);
        }
        if (position.y() > this.height * bottomFactor) {
            result.add(MapDirection.DOWN);
        }

        if (position.x() > this.width * rightFactor) {
            result.add(MapDirection.RIGHT);
        }

        if (position.y() < -this.height * topFactor + 1) {
            result.add(MapDirection.UP);
        }

        return result;
    }

    public boolean isRock(MapPosition position) {
        int currentX = position.x();
        int currentY = position.y();
        if (currentX > this.width * rightFactor) {
            return false;
        }
        if (currentX <= -this.width * leftFactor) {
            return false;
        }

        if (currentY > this.height * bottomFactor) {
            return false;
        }
        if (currentY <= -this.height * topFactor) {
            return false;
        }

        if (currentX <= 0) {
            currentX = (-currentX / width + 1) * width + currentX;
        }else{
            currentX = currentX%width;
        }

        if (currentY <= 0) {
            currentY = (-currentY / height + 1) * height + currentY;
        }else{
            currentY = currentY%height;
        }

        MapPosition checkPosition = new MapPosition(currentX, currentY);
        return rockPositions.contains(checkPosition);
    }

    public boolean isNoRock(MapPosition position) {
        return !isRock(position);
    }



    private boolean validateStartPosition(MapPosition startPosition) {
        if (startPosition.x() == 0 || startPosition.y() == 0) {
            return false;
        }
        if (startPosition.x() > this.width) {
            return false;
        }
        if (startPosition.y() > this.height) {
            return false;
        }
        return true;
    }

    public void printOut() {
        for (int i = 1; i <= height; i++) {
            StringBuffer lineBuffer = new StringBuffer(".".repeat(width));

            int finalI = i;
            List<MapPosition> list = rockPositions.stream().filter(p -> p.y() ==
                    finalI).toList();
            for (var position : list) {
                lineBuffer.setCharAt(position.x()-1, '#');
            }
            System.out.println(lineBuffer.toString());
        }
    }

    public void expandRightAndBottom(int deltaWidthFactor, int deltaHeightFactor) {
        rightFactor += deltaWidthFactor;
        bottomFactor += deltaHeightFactor;
    }

    public void expandLeftAndTop(int deltaWidthFactor, int deltaHeightFactor) {
        leftFactor += deltaWidthFactor;
        topFactor += deltaHeightFactor;
    }

    public List<MapPosition> getPossibleReachablePositionInNextStep(MapPosition position, boolean ...toExpands) {
        boolean toExpand = false;
        if (toExpands.length == 1) {
            toExpand = toExpands[0];
        }
        if (!validateStartPosition(position)) {
            throw new IllegalArgumentException("...");
        }
        List<MapDirection> overflows = this.getOverflows(position);
        for (MapDirection direction : overflows) {
            direction.acceptWithGardenRockMap(this);
        }


        List<MapPosition> possibleNextPositions = new ArrayList<>();

        MapPosition leftPosition = position.getShiftedMapPosition(-1, 0);
        MapPosition rightPosition = position.getShiftedMapPosition(1, 0);
        MapPosition topPosition = position.getShiftedMapPosition(0, -1);
        MapPosition bottomPosition = position.getShiftedMapPosition(0, 1);

        if (isNoRock(leftPosition)) {
            possibleNextPositions.add(leftPosition);
        }
        if (isNoRock(rightPosition)) {
            possibleNextPositions.add(rightPosition);
        }
        if (isNoRock(topPosition)) {
            possibleNextPositions.add(topPosition);
        }
        if (isNoRock(bottomPosition)) {
            possibleNextPositions.add(bottomPosition);
        }

        return possibleNextPositions;
    }




    public static class Builder {

        private int width;
        private int height;
        private Set<MapPosition> rockPositions = new HashSet<>();
        public static Builder create() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder addRockPosition(int x, int y) {
            return addRockPosition(new MapPosition(x, y));
        }

        public Builder addRockPosition(MapPosition position) {
            checkMapPosition(position);
            rockPositions.add(position);
            this.height = Math.max(this.height, position.y());
            this.width = Math.max(this.width, position.x());
            return this;
        }

        public GardenRockMap build() {

            GardenRockMap gardenRockMap = new GardenRockMap(this.height+1, this.width+1);

            gardenRockMap.rockPositions = this.rockPositions;
            return gardenRockMap;
        }

        private void checkMapPosition(MapPosition position) {
            if (position.x() <= 0 || position.y() <= 0) {
                throw new IllegalArgumentException("x position or y position < 0");
            }
        }
    }
}
