package de.hegmanns.training.aoc2022.day24.grid;

import de.hegmanns.training.aoc2022.day24.Pair;
import de.hegmanns.training.aoc2022.day24.location.Loc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class InfiniteGrid implements Grid {
    public final Map<Loc, Character> grid;

    public InfiniteGrid(char[][] g) {
        this(g, ' ');
    }

    public InfiniteGrid(char[][] g, char transparent) {
        this();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if(transparent != g[i][j]) {
                    grid.put(new Loc(j, i), g[i][j]);
                }
            }
        }
    }

    public InfiniteGrid(Map<Loc, Character> grid) {
        this.grid = new HashMap<>(grid);
    }

    public InfiniteGrid() {
        this(new HashMap<>());
    }

    public InfiniteGrid(String s) {
        this(new CharGrid(s).grid);
    }

    public IntStream iterate() {
        return grid.values().stream().mapToInt(e -> e);
    }

    public Optional<Character> get(Loc p) {
        return grid.containsKey(p) ? of(grid.get(p)) : empty();
    }

    public char getChar(Loc p) {
        return get(p).orElse((char)0);
    }

    public void set(Loc p, char c) {
        grid.put(p, c);
    }

    public String toString() {
        long minX = minX();
        long minY = minY();
        CharGrid g = new CharGrid(' ', new Loc(width(), height()));
        grid.forEach((p, i) -> g.set(new Loc(p.x-minX, p.y-minY), i));
        return g.toString();
    }

    public static Collector<Loc, Map<Loc, Character>, InfiniteGrid> toInfiniteGrid(char c) {
        final Supplier<Map<Loc, Character>> supplier = HashMap::new;
        final BiConsumer<Map<Loc, Character>, Loc> accumulator = (a, b) -> a.put(b, c);
        final BinaryOperator<Map<Loc, Character>> combiner = (a, b) -> {a.putAll(b); return a;};
        final Function<Map<Loc, Character>, InfiniteGrid> finisher = InfiniteGrid::new;
        return Collector.of(supplier, accumulator, combiner, finisher);
    }

    public boolean canPlace(InfiniteGrid g, long r, long c) {
        return g.grid.keySet().stream().map(l -> l.move(c, r)).noneMatch(grid::containsKey);
    }

    public boolean canPlace(InfiniteGrid g) {
        return g.grid.keySet().stream().noneMatch(grid::containsKey);
    }

    public long minY() {
        return grid.keySet().stream().mapToLong(e -> e.y).min().orElse(0);
    }

    public long maxY() {
        return grid.keySet().stream().mapToLong(e -> e.y).max().orElse(0);
    }

    public long minX() {
        return grid.keySet().stream().mapToLong(e -> e.x).min().orElse(0);
    }

    public long maxX() {
        return grid.keySet().stream().mapToLong(e -> e.x).max().orElse(0);
    }

    public InfiniteGrid move(long x, long y) {
        return null;//return new InfiniteGrid(grid.entrySet().stream().map(e -> new Pair(e.getKey().move(x, y), e.getValue())).collect(Collectors.toMap(Pair::a, Pair::b)));
    }

    public void place(InfiniteGrid s) {
        s.grid.forEach(this::set);
    }

    public long height() {
        return maxY()+1-minY();
    }

    public long width() {
        return maxX()+1-minX();
    }

    public boolean contains(Loc p) {
        return grid.keySet().contains(p);
    }

    public Stream<Loc> stream() {
        return grid.keySet().stream();
    }

    public void removeIf(BiPredicate<Loc, Character> p) {
        new HashSet<>(grid.entrySet()).stream().filter(e -> p.test(e.getKey(), e.getValue())).forEach(e -> grid.remove(e.getKey()));
    }
}
