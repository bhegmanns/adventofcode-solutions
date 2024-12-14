package de.hegmanns.training.aoc2022.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarriedCalories {
    List<String> linesOfCalories = new ArrayList<>();
    List<Integer> calories = new ArrayList<>();

    public static CarriedCalories create(){
        return new CarriedCalories();
    }

    public CarriedCalories addCarriedFood(String calories){
        linesOfCalories.add(calories);
        this.calories.add(Integer.parseInt(calories));

        return this;
    }

    public int getTotalCalories(){
        return this.calories.stream().mapToInt(Integer::valueOf).sum();
    }
}
