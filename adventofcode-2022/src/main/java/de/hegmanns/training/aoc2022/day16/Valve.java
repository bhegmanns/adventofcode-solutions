package de.hegmanns.training.aoc2022.day16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Valve {

    private String name;

    private int flowRate;

    private List<Tunnel> tunnels;
    private Map<String, Tunnel> tunnelMap = new HashMap<>();

    public Valve(String name) {
        this.name = name;
    }

    public void setTunnels(List<Tunnel> tunnels) {
        this.tunnels = tunnels;
    }

    public String getName() {
        return name;
    }

    public int getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(int flowRate) {
        this.flowRate = flowRate;
    }

    public List<Tunnel> getTunnels() {
        return tunnels;
    }
}
