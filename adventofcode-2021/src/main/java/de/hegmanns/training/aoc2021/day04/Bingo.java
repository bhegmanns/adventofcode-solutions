package de.hegmanns.training.aoc2021.day04;

import java.util.ArrayList;
import java.util.List;

public class Bingo {
    private List<Line> rows = new ArrayList<>();
    private List<Line> columns = new ArrayList<>();
    private boolean solved = false;

    public List<Line> getRows() {
        return rows;
    }

    public void setRows(List<Line> rows) {
        this.rows = rows;
    }

    public List<Line> getColumns() {
        return columns;
    }

    public void setColumns(List<Line> columns) {
        this.columns = columns;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public void printOut(){
        if (solved) {
            System.out.println("SOLVED");
        } else {
            System.out.println("UNSOLVED");
        }

        var iterator = rows.iterator();
        while (iterator.hasNext()) {
            var line = iterator.next();
            line.printOut();
        }
    }

    public void addRow(List<Integer> row){
        var line = new Line();
        line.setLine(row);
        rows.add(line);
    }

    public void prepareColumns() {
        var countColumns = rows.get(0).getNumbers().size();
        var currentColumn = 0;
        while (currentColumn < countColumns) {
            var line = new Line();
            List<Integer> numbersInColumn = new ArrayList<>();
            var rowIterator = rows.iterator();
            while (rowIterator.hasNext()) {
                numbersInColumn.add(rowIterator.next().getNumbers().get(currentColumn));
            }
            line.setLine(numbersInColumn);
            columns.add(line);

            currentColumn++;
        }
    }

    public boolean solveNumber(int number){
        for (Line row : rows){
            row.markAsSolved(number);
        }
        for (Line column : columns){
            column.markAsSolved(number);
        }

        solved = rows.stream().filter(Line::isSolvedCompleted).count()!=0 || columns.stream().filter(Line::isSolvedCompleted).count() != 0;
        return solved;

    }

    public int getSumSolved(){
        var sum = 0;
        var iterator = rows.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().getSumSolved();
        }
        return sum;
    }
    public int getSumUnsolved() {
        var sum = 0;
        var iterator = rows.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().getSumUnsolved();
        }
        return sum;
    }

}
