package de.hegmanns.training.aoc2022.day07;

import java.util.ArrayList;
import java.util.List;

public class SimpleNode {

    private String nodeName;
    private List<SimpleNode> nodes = new ArrayList<>();
    private List<SimpleLeaf> leafs = new ArrayList<>();

    private SimpleNode parentNode;

    public SimpleNode(String nodeName, SimpleNode parentNode) {
        this.parentNode = parentNode;
        this.nodeName = nodeName;
    }

    public void addLeaf(SimpleLeaf leaf) {
        leafs.add(leaf);
    }

    public void addNode(SimpleNode node) {
        nodes.add(node);
    }

    public SimpleNode traverseToParent(){
        return parentNode;
    }

    public SimpleNode traverseToNode(String nodeName) {
        return nodes.stream().filter(s -> s.nodeName.equals(nodeName)).findFirst().orElse(new SimpleNode(nodeName, this));
    }

    public List<SimpleNode> getNodes() {
        return nodes;
    }

    public List<SimpleNode> getAllContainedNodes() {
        List<SimpleNode> containedNodes = new ArrayList<>();

        if (!getNodes().isEmpty()) {
            for (SimpleNode node : getNodes()) {
                containedNodes.add(node);
                containedNodes.addAll(node.getAllContainedNodes());
            }
        }

        return containedNodes;
    }

    public long getCompleteSize() {
        long sizeOfLeafs = leafs.stream().map(SimpleLeaf::getSize).mapToLong(Long::longValue).sum();

        long sizeOfNodes = getNodes().stream().map(SimpleNode::getCompleteSize).mapToLong(Long::longValue).sum();

        return sizeOfLeafs + sizeOfNodes;
    }



}
