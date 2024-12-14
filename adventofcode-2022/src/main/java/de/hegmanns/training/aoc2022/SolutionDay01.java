package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day01.InputDay01Filter;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Solution of www.adventofcode.com/2022 day 01.
 */
//@AInputData(year = 2022, day = 1)
public class SolutionDay01 implements AoCSolution<Integer, Integer> {


    public static void main(String[] args) {

        InputDay01Filter input = new InputDay01Filter(AoCFileReader.getInputStream(SolutionDay01.class, "day01.txt"));
        input.getNextInstance();

        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01.txt");


        System.out.println(">>>" + System.getenv("aoc_token"));//AOC_TOKEN

        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieStore store = manager.getCookieStore();

        System.out.println("COOKIES:");
        for (HttpCookie cookie : store.getCookies()) {
            System.out.println("" + cookie.getName() + " = " + cookie.getValue());
        }
        System.out.println("====");
        //AInputData annotation = SolutionDay01.class.getAnnotation(AInputData.class);
        //InputHelper inputHelper = new InputHelper(annotation);
        //BufferedReader input1 = inputHelper.getInput();
        /*
        try {
            System.out.println("FIRST LINE = " + input1.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */

        SolutionDay01 solutionDay01 = new SolutionDay01();
        System.out.println(solutionDay01.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println(solutionDay01.solvePart2(inputAsList));
    }
    @Override
    public Integer solvePart1(List<String> input) {
        int mostTakenCalories = 0;
        int subtotal = 0;
        int countElves = 0;
        for (String line : input) {
            if (line.trim().isEmpty()) {
                mostTakenCalories = Math.max(subtotal, mostTakenCalories);
                subtotal = 0;
                countElves++;
                continue;
            }
            subtotal += Integer.parseInt(line);
        }
        System.out.println("Count of elves = " + countElves);
        return mostTakenCalories;
    }

    @Override
    public Integer solvePart2(List<String> input) {
        ArrayList<Integer> calories = new ArrayList<>();

        int subtotal = 0;
        for (String line : input) {
            if (line.trim().isEmpty()) {
                calories.add(subtotal);
                subtotal = 0;
                continue;
            }
            subtotal += Integer.parseInt(line);
        }

        calories.sort(Comparator.reverseOrder());
        System.out.println("Count of elves = " + calories.size());
        return calories.get(0)+calories.get(1)+calories.get(2);
    }

    @Override
    public Integer getSolution1() {
        return null;
    }

    @Override
    public Integer getSolution2() {
        return null;
    }
}
