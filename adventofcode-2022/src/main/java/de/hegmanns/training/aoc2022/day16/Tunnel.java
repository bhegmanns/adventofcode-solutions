package de.hegmanns.training.aoc2022.day16;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tunnel {

    private List<Valve> connectedValves = new ArrayList<>(2);

    public Tunnel() {

    }

    public void addConnection(Valve valve) {
        if (connectedValves.size() != 1) {
            throw new RuntimeException("you cannot add more than 2 valves for a connection");
        }
        connectedValves.add(valve);
    }

    public List<Valve> getConnectedValves() {
        return connectedValves;
    }

    public boolean isConnectedWith(String valveName) {
        return connectedValves.stream().filter((v) -> v.getName().equals(valveName)).findFirst().isPresent();
    }

    @Override
    public String toString() {
        return "Tunnel{" +
                "connected between=" + connectedValves.stream().map(Valve::getName).collect(Collectors.joining(" and ")) +
                '}';
    }
}
