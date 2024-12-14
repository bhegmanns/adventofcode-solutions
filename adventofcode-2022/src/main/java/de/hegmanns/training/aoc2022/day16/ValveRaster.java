package de.hegmanns.training.aoc2022.day16;

import java.util.*;
import java.util.stream.Collectors;

public class ValveRaster {


    private Map<String, Valve> valveMap;
    private Set<Tunnel> tunnels;

    public ValveRaster() {
        this.valveMap = new HashMap<>();
        this.tunnels = new HashSet<>();
    }

    private Valve resolveValveByName(String name) {
        Valve valve = valveMap.get(name);
        if (valve == null) {
            valve = new Valve(name);
            valveMap.put(name, valve);
        }

        return valve;
    }

    private Tunnel resolveTunnelByValveName(Valve valve, String valveName) {

        Optional<Tunnel> first = tunnels.stream().filter(t -> t.isConnectedWith(valve.getName())).filter(t -> t.isConnectedWith(valveName)).findFirst();
        Valve connectedValve = resolveValveByName(valveName);
        Tunnel tunnel = null;
        if (!first.isPresent()) {
            tunnel = new Tunnel();
            tunnels.add(tunnel);
        } else {
            tunnel = first.get();
        }

        tunnel.getConnectedValves().clear();
        tunnel.getConnectedValves().add(valve);
        tunnel.getConnectedValves().add(connectedValve);


        return tunnel;
    }

    public void readRasterDefinition(List<String> input) {
        //Valve JJ has flow rate=21; tunnel leads to valve II
        //Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
        for (String line : input) {
            String[] splitLine = line.split(";");
            Valve valve = parseValve(splitLine[0]);
            List<Tunnel> tunnels = parseTunnels(valve, splitLine[1]);

            this.tunnels.addAll(tunnels);
            valve.setTunnels(tunnels);
        }
    }

    private Valve parseValve(String valvePart) {
        String[] splitValvePart = valvePart.split("=");
        int flowRate = Integer.parseInt(splitValvePart[1]);
        String valveName = splitValvePart[0].split(" ")[1];

        Valve valve = resolveValveByName(valveName);
        valve.setFlowRate(flowRate);
        return valve;
    }

    private List<Tunnel> parseTunnels(Valve valve, String tunnelPart) {
        int indexOfValve = tunnelPart.indexOf("valve");
        String[] connectedValveNames = tunnelPart.substring(indexOfValve + 6).trim().split(", ");

        return Arrays.stream(connectedValveNames).map((n) -> resolveTunnelByValveName(valve, n)).collect(Collectors.toList());
    }

    public Set<Valve> getValves() {
        return new HashSet<>(valveMap.values());
    }

    public Map<String, Valve> getValveMap() {
        return valveMap;
    }
}
