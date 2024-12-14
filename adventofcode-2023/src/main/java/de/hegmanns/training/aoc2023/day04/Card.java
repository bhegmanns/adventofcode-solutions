package de.hegmanns.training.aoc2023.day04;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    private long number;

    List<Integer> winningNumbers;

    List<Integer> cardNumbers;

    public Card(String definitionLine) {
        String[] split = definitionLine.trim().split(":");
        String[] cardDefinition = split[0].trim().split(" ");


        number = Long.parseLong(Stream.of(cardDefinition).filter(s -> !(s.isEmpty() || s.isBlank())).toList().get(1));

        String[] numbers = split[1].trim().split("\\|");

        winningNumbers = Stream.of(numbers[0].split(" ")).filter(s -> !(s.isBlank()||s.isEmpty()||"".equals(s)||" ".equals(s))).map(Integer::parseInt).collect(Collectors.toList());
        cardNumbers = Stream.of(numbers[1].trim().split(" ")).filter(s -> !(s.isBlank()||s.isEmpty()||"".equals(s)||" ".equals(s))).map(Integer::parseInt).collect(Collectors.toList());
    }

    public long getWorthPoints() {
        long winningNumbers = getCountMatchedNumbers();
        if (winningNumbers == 0) {
            return 0;
        } else {
            return BigInteger.TWO.pow((int)(winningNumbers-1)).longValue();
        }
    }

    public long getCountMatchedNumbers() {
        return cardNumbers.stream().filter(n -> this.winningNumbers.contains(n)).count();
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(List<Integer> cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                '}';
    }
}
