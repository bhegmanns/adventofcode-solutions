package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day07.SimpleLeaf;
import de.hegmanns.training.aoc2022.day07.SimpleNode;
import de.hegmanns.training.aoc2022.day07.SimpleTree;

import java.util.Comparator;
import java.util.List;

/**
 * Solution of www.adventofcode.com/2022 day 07.
 */
public class SolutionDay07 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, "day07.txt");

        SolutionDay07 solution = new SolutionDay07();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }
    @Override
    public Long solvePart1(List<String> input) {
        SimpleTree simpleTree = parseInputArrayIntoSimpleTree(input);

        long completeSize = simpleTree.getAllContainedNodes().stream().map(SimpleNode::getCompleteSize).filter(l -> l < 100000L).mapToLong(Long::longValue).sum();

        return completeSize;
    }

    @Override
    public Long solvePart2(List<String> input) {
        SimpleTree simpleTree = parseInputArrayIntoSimpleTree(input);

        /*
        List<SimpleNode> allContainedNodes = simpleTree.getAllContainedNodes();


        allContainedNodes.stream().forEach(n -> {
            System.out.println("" + n.getCompleteSize());
        });
         */
        Comparator<SimpleNode> nodeComparator = (a, b) -> {return Long.compare(a.getCompleteSize(), b.getCompleteSize());};

        long completeSize = simpleTree.getCompleteSize();
        long freeSize = 70000000L - completeSize;
        long minimum = 30000000L - freeSize;

        long smallestDeletableSize = simpleTree.getAllContainedNodes().stream().filter(node -> node.getCompleteSize() >= minimum).sorted(nodeComparator).map(SimpleNode::getCompleteSize).findFirst().get();


        return smallestDeletableSize;
    }

    @Override
    public Long getSolution1() {
        return null;
    }

    @Override
    public Long getSolution2() {
        return null;
    }


    private SimpleTree parseInputArrayIntoSimpleTree(List<String> input) {
        SimpleTree tree = new SimpleTree();
        SimpleNode currentNode = tree;
        boolean currentCommandList = false;
        for (String line : input) {
            if (line.startsWith("$")) {
                if (line.equals("$ ls")) {
                    currentCommandList = true;
                } else {
                    currentCommandList = false;
                    String[] s = line.split(" ");
                    if (s[2].trim().equals("/")) {
                        currentNode = tree;
                    }else{
                        if (s[2].trim().equals("..")) {
                            currentNode = currentNode.traverseToParent();
                        } else {
                            // now the directory :)
                            currentNode = currentNode.traverseToNode(s[2].trim());
                        }
                    }
                }
            } else {
                if (!currentCommandList) {
                    throw new RuntimeException("there is no '$ ls'-command prior ...");
                }
                if (line.startsWith("dir")) {
                    String[] s = line.split(" ");
                    currentNode.addNode(new SimpleNode(s[1].trim(), currentNode));
                } else {
                    String[] s = line.split(" ");
                    SimpleLeaf leaf = new SimpleLeaf(Long.parseLong(s[0]), s[1].trim());
                    currentNode.addLeaf(leaf);
                }
            }
        }

        return tree;
    }
}
