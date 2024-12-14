package de.hegmanns.training.aoc2022.day14;

import java.util.Arrays;

public class Sensor {

    private RasterCoordinate position;

    private RasterCoordinate closestBeaconCoordinate;

    public static Sensor createFromDefinitionLine(String definitionLine) {
        //Sensor at x=2, y=18: closest beacon is at x=-2, y=15

        int firstXPosition = definitionLine.indexOf("x=");
        int secondXDefinition = definitionLine.indexOf("x=", firstXPosition + 1);
        int firstYPosition = definitionLine.indexOf("y=");
        int secondYPosition = definitionLine.indexOf("y=", firstYPosition + 1);

        String[] sensorDefinition = definitionLine.split(":")[0].substring(firstXPosition ).split(", ");
        String[] beaconDefinition = definitionLine.substring(secondXDefinition).split(", ");

        Sensor sensor = new Sensor();
        sensor.position = new RasterCoordinate(Long.parseLong(sensorDefinition[0].split("=")[1]), Long.parseLong(sensorDefinition[1].split("=")[1]));
        sensor.closestBeaconCoordinate = new RasterCoordinate(Long.parseLong(beaconDefinition[0].split("=")[1]), Long.parseLong(beaconDefinition[1].split("=")[1]));

        return sensor;
    }

    public RasterCoordinate getSensorPosition() {
        return position;
    }

    public RasterCoordinate getClosestBeaconPosition() {
        return closestBeaconCoordinate;
    }

    public RasterRange calculateRangeOfNotAdditionBeaconInLine(long lineIndex) {
        long manhattanDistanceToBeacon = position.getManhattanDistance(closestBeaconCoordinate);

        long restOfManhattanDistance = manhattanDistanceToBeacon - Math.abs(this.position.getY() - lineIndex);
        if (restOfManhattanDistance < 0L) {
            return null;
        }
        long deltaX = Math.abs(restOfManhattanDistance);

        RasterRange rasterRange = new RasterRange(this.position.getX()-deltaX, this.position.getX()+deltaX);

        return rasterRange;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "position=" + position +
                '}';
    }
}
