package de.hegmanns.training.aoc2022.day14;

import java.awt.*;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.List;

public class SensorBeaconMap {

    private List<Sensor> sensors;

    private long minX = Integer.MAX_VALUE;
    private long maxX = Integer.MIN_VALUE;
    private long minY = Integer.MAX_VALUE;
    private long maxY = Integer.MIN_VALUE;

    public SensorBeaconMap() {
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);

        minX = Math.min(minX, Math.min(sensor.getSensorPosition().getX(), sensor.getClosestBeaconPosition().getX()));
        minY = Math.min(minY, Math.min(sensor.getSensorPosition().getY(), sensor.getClosestBeaconPosition().getY()));

        maxX = Math.max(maxX, Math.max(sensor.getSensorPosition().getX(), sensor.getClosestBeaconPosition().getX()));
        maxY = Math.max(maxY, Math.max(sensor.getSensorPosition().getX(), sensor.getClosestBeaconPosition().getX()));
    }


    public long calculateCountOfNotContainedBeaconsInLine(long lineIndexNumber) {

        RasterRange completeLineRange = new RasterRange(minX, maxX);

        List<RasterRange> rasterRangesForLineNumber = new ArrayList<>();
        for (Sensor sensor : sensors) {
            RasterRange rasterRange = sensor.calculateRangeOfNotAdditionBeaconInLine(lineIndexNumber);
            if (rasterRange == null) {
                System.out.println("no RasterRange for line " + lineIndexNumber + " for sensor " + sensor);
                continue;
            }
            rasterRangesForLineNumber.add(rasterRange);
            completeLineRange.reduce(rasterRange);
        }



        return completeLineRange.calculateNoExcludedCountOfPositions();
    }

}
