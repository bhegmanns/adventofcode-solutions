package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day08.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution of www.adventofcode.com/2022 day 08.
 */
public class SolutionDay08 implements AoCSolution<Integer, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, "day08.txt");

        SolutionDay08 solution = new SolutionDay08();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }
    @Override
    public Integer solvePart1(List<String> input) {
        List<List<Tree>> treeGrid = new ArrayList<>();

        for (String line : input) {
            List<Tree> treeLine = new ArrayList<>();

            for (char c : line.toCharArray()) {
                treeLine.add(new Tree(Integer.parseInt("" + c)));
            }
            treeGrid.add(treeLine);
            setToVisible(treeLine);

            // von rechts nach links
            List<Tree> reverse = new ArrayList<>(treeLine);
            Collections.reverse(reverse);
            setToVisible(reverse);
        }

        // columns erstellen
        List<List<Tree>> columnsOfTrees = new ArrayList<>();
        int countColumns = treeGrid.get(0).size();
        int countOfRows = treeGrid.size();

        for (int column = 0; column < countColumns; column++) {
            List<Tree> treeColumn = new ArrayList<>();
            for (int row = 0; row < countOfRows; row++) {
                treeColumn.add(treeGrid.get(row).get(column));
            }
            columnsOfTrees.add(treeColumn);
            setToVisible(treeColumn);
            List<Tree> reverseColumn = new ArrayList<>(treeColumn);
            Collections.reverse(reverseColumn);
            setToVisible(reverseColumn);
        }

        return (int) treeGrid.stream().map(l -> getCountVisibleTrees(l)).mapToLong(Long::longValue).sum();
    }

    @Override
    public Long solvePart2(List<String> input) {
        List<List<Tree>> treeGrid = new ArrayList<>();

        for (String line : input) {
            List<Tree> treeLine = new ArrayList<>();

            for (char c : line.toCharArray()) {
                Tree currentTree = new Tree(Integer.parseInt("" + c));
                treeLine.add(currentTree);

            }
            treeGrid.add(treeLine);
        }

        long maxScore = 0;
        int countOfColumns = treeGrid.get(0).size();

        for (int row = 0; row < treeGrid.size(); row++) {
            for (int column = 0; column < countOfColumns; column++) {
                List<Tree> top = buildFromColumnTop(column, row, treeGrid);
                List<Tree> down = buildFromColumnDown(column, row, treeGrid);
                List<Tree> left = buildFromRowLeft(row, column, treeGrid);
                List<Tree> right = buildFromRowRight(row, column, treeGrid);

                long topScore = getCountDirectVisibleTreesInRow(top);
                long downScore = getCountDirectVisibleTreesInRow(down);
                long leftScore = getCountDirectVisibleTreesInRow(left);
                long rightScore = getCountDirectVisibleTreesInRow(right);
                long currentScore = topScore*downScore*leftScore*rightScore;
                maxScore = Math.max(currentScore, maxScore);
            }
        }

        return maxScore;
    }

    @Override
    public Integer getSolution1() {
        return null;
    }

    @Override
    public Long getSolution2() {
        return null;
    }

    public void setToVisible(List<Tree> treeRow) {
        int currentMaxHeight = -1;
        for (Tree tree : treeRow) {
            if (currentMaxHeight < tree.getRelativeHeight()) {
                tree.setVisible();
                currentMaxHeight = tree.getRelativeHeight();
            }
        }
    }

    public long getCountVisibleTrees(List<Tree> row) {
        return row.stream().filter(Tree::isVisible).count();
    }

    public List<Tree> extractFromToLeft(List<Tree> trees, int index) {
        List<Tree> extracted = new ArrayList<>();

        for (int currentIndex = index; currentIndex >= 0; currentIndex--) {
            extracted.add(trees.get(currentIndex));
        }

        return extracted;
    }

    private List<Tree> buildFromRowLeft(int rowIndex, int startColumnIndex, List<List<Tree>> treeGrid){
        List<Tree> result = new ArrayList<>();
        List<Tree> currentRow = treeGrid.get(rowIndex);

        for (int column = startColumnIndex; column >= 0; column--) {
            result.add(currentRow.get(column));
        }

        return result;
    }

    private List<Tree> buildFromRowRight(int rowIndex, int startColumnIndex, List<List<Tree>> treeGrid){
        List<Tree> result = new ArrayList<>();
        List<Tree> currentRow = treeGrid.get(rowIndex);

        for (int column = startColumnIndex; column < currentRow.size(); column++) {
            result.add(currentRow.get(column));
        }

        return result;
    }

    private List<Tree> buildFromColumnTop(int columnIndex, int startRowIndex, List<List<Tree>> treeGrid){
        List<Tree> result = new ArrayList<>();

        for (int row = startRowIndex; row >= 0; row--) {
            result.add(treeGrid.get(row).get(columnIndex));
        }

        return result;
    }

    private List<Tree> buildFromColumnDown(int columnIndex, int startRowIndex, List<List<Tree>> treeGrid){
        List<Tree> result = new ArrayList<>();

        for (int row = startRowIndex; row < treeGrid.size(); row++) {
            result.add(treeGrid.get(row).get(columnIndex));
        }

        return result;
    }

    private int getCountDirectVisibleTreesInRow(List<Tree> trees) {
        int height = 0;
        int count = 0;
        boolean started = true;
        Tree reverenceTree = trees.get(0);



        for (Tree tree : trees) {
            if (started) {
                started=false;
                height = reverenceTree.getRelativeHeight();
                continue;
            }

            count++;
            if (tree.getRelativeHeight() >= height) {
                break;
            }
        }

        return count;
    }
}
