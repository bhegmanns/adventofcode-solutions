package de.hegmanns.training.aoc2022.day16.quicksolution;

import java.util.*;
import java.util.regex.Pattern;

public class QuickSolution16 {

    public static void main(String[] args) {
        Map<String, Valve> valveMap = new HashMap<>();
        INPUT_TEST.lines().map(Valve::parse).forEach(v -> {
            valveMap.put(v.id, v);
        });
         part1(valveMap);
        //part2_2(valveMap);
    }

    private static void part1(Map<String, Valve> valveMap) {
        Queue<Step> steps = new ArrayDeque<>();
        steps.add(new Step("AA", 0, 0, 0, new HashSet<>(), Set.of("AA")));
        int maxReleased = Integer.MIN_VALUE;
        Step last = null;
        while (!steps.isEmpty()) {
            Step current = steps.poll();
            if (current.minute() < 30) {
                if (!current.open().contains(current.at()) && valveMap.get(current.at).flowRate() > 0) {
                    steps.add(new Step(current.at(), current.minute() + 1,
                            current.releases() + valveMap.get(current.at).flowRate(),
                            current.released() + current.releases(), current.open(current.at()), current.visited()));
                }
                var availables = valveMap.get(current.at()).available();
                availables.stream().filter(s -> !current.visited.contains(s)).forEach(id -> {
                    steps.add(new Step(id, current.minute() + 1, current.releases(),
                            current.released() + current.releases(), current.open(), current.visit(id)));
                });
            }
            if (maxReleased < current.released()) {
                maxReleased = current.released();
                last = current;
            }
            System.out.println("step.size: " + steps.size() + "\t" + current.minute());
        }
        System.out.println(maxReleased);
    }

//    private static void part2(Map<String, Valve> valveMap) {
//        Stack<ElephantStep> steps = new Stack<>();// new ArrayDeque<>();
//        steps.add(new ElephantStep("AA", "AA", 0, 0, 0, new HashSet<String>(), Set.of("AA"), Set.of("AA")));
//        int maxReleased = Integer.MIN_VALUE;
//        ElephantStep last = null;
//        long c = 0L;
//        while (!steps.isEmpty()) {
//            ++c;
//            var current = steps.pop();
//            if (current.minute() < 26) {
//                var iShouldOpen = !current.open().contains(current.at()) && valveMap.get(current.at).flowRate() > 0;
//                var eShouldOpen = !current.open().contains(current.eAt()) && valveMap.get(current.eAt).flowRate() > 0;
//                if (iShouldOpen && eShouldOpen && !current.at().equals(current.eAt())) {
//                    steps.add(new ElephantStep(current.at(), current.eAt(), current.minute() + 1,
//                            current.releases() + valveMap.get(current.at()).flowRate()
//                                    + valveMap.get(current.eAt()).flowRate(),
//                            current.released() + current.releases(), current.open(current.at(), current.eAt()),
//                            current.visited(), current.eVisited()));
//                } else if (iShouldOpen) {
//                    valveMap.get(current.eAt()).available().stream()
//                            /* .filter(s->!current.eVisited().contains(s)) */.forEach(id -> {
//                                steps.add(new ElephantStep(current.at(), id, current.minute() + 1,
//                                        current.releases() + valveMap.get(current.at()).flowRate(),
//                                        current.released() + current.releases(), current.open(current.at(), null),
//                                        current.visited(), current.eVisit(id)));
//                            });
//                } else if (eShouldOpen) {
//                    valveMap.get(current.at()).available().stream()
//                            /* .filter(s->!current.visited().contains(s)) */.forEach(id -> {
//                                steps.add(new ElephantStep(id, current.eAt(), current.minute() + 1,
//                                        current.releases() + valveMap.get(current.eAt()).flowRate(),
//                                        current.released() + current.releases(), current.open(null, current.eAt()),
//                                        current.visit(id), current.eVisited()));
//                            });
//                } else {
//                    valveMap.get(current.at()).available().stream()
//                            /* .filter(s->!current.visited().contains(s)) */.forEach(id -> {
//                                valveMap.get(current.eAt()).available().stream()
//                                        /* .filter(s->!current.eVisited().contains(s)) */.forEach(eId -> {
//                                            steps.add(new ElephantStep(id, eId, current.minute() + 1,
//                                                    current.releases(), current.released() + current.releases(),
//                                                    current.open(), current.visit(id), current.eVisit(eId)));
//                                        });
//                            });
//                }
//            }
//            if (maxReleased < current.released()) {
//                maxReleased = current.released();
//                last = current;
//            }
//            if (c % 1_000_000 == 0) {
//                System.out.println("step.size: " + steps.size() + "\t" + current.minute() + "\t" + c);
//            }
//        }
//        System.out.println(maxReleased);
//    }

    private static void part2_2(Map<String, Valve> valveMap) {
        var prices = calcPrices(valveMap);
        var valuables = valveMap.values().stream().filter(it -> it.flowRate() > 0).map(Valve::id).toList();
        Stack<ElephantStep> steps = new Stack<>();// new ArrayDeque<>();
        steps.add(new ElephantStep(List.of("AA"), List.of("AA"), new HashSet<String>()));
        int maxReleased = Integer.MIN_VALUE;
        ElephantStep last = null;
        long c = 0L;
        while (!steps.isEmpty()) {
            ++c;
            var current = steps.pop();
            if (current.minutes(prices) < 26 || current.eMinutes(prices) < 26) {
                String start = current.route().get(0);
                String eStart = current.eRoute().get(0);
                valuables.stream().filter(s -> !s.equals(start) && !s.equals(eStart) && !current.open().contains(s)).forEach(v -> {
                    valuables.stream().filter(eS -> !eS.equals(start) && !eS.equals(eStart) && !current.open().contains(eS) && !eS.equals(v))
                            .forEach(eV -> {
                                steps.add(new ElephantStep(current.visit(v), current.eVisit(eV), current.open(v, eV)));
                            });
                });
            }
            if(maxReleased < current.released(prices, valveMap)) {
                maxReleased = current.released(prices, valveMap);
                last = current;
                System.out.println(maxReleased);
                System.out.println(last);
            }
            if (c % 1_000_000 == 0) {
                System.out.println("step.size: " + steps.size() + "\t" + current.minutes(prices) + "\t" + current.eMinutes(prices)+"\t"+ c);
            }
        }
        System.out.println(maxReleased);
    }

    private static final record Valve(String id, int flowRate, List<String> available) {

        private static final Pattern PATTERN = Pattern
                .compile("Valve (\\w+) has flow rate=(\\d+); \\w+ \\w+ to \\w+ (.+)");
        static Valve parse(String line) {
            var matcher = PATTERN.matcher(line);
            if (matcher.matches()) {
                String id = matcher.group(1);
                int rate = Integer.parseInt(matcher.group(2));
                List<String> next = Arrays.asList(matcher.group(3).trim().split(", "));
                return new Valve(id, rate, next);
            }
            throw new IllegalArgumentException("does not match: " + line);
        }
    }

    private static final record Step(String at, int minute, int releases, int released, Set<String> open,
                                     Set<String> visited) {
        Set<String> open(String v) {
            var copy = new HashSet<>(open);
            copy.add(v);
            return copy;
        }

        Set<String> visit(String v) {
            var copy = new HashSet<>(visited);
            copy.add(v);
            return copy;
        }

        int calcMaxRelease() {
            return released + (30 - minute) * releases;
        }
    }

    private static final record ElephantStep(List<String> route, List<String> eRoute, Set<String> open) {
        Set<String> open(String v, String eV) {
            var copy = new HashSet<>(open);
            if (v != null) {
                copy.add(v);
            }
            if (eV != null) {
                copy.add(eV);
            }
            return copy;
        }

        List<String> visit(String v) {
            var copy = new LinkedList<>(route);
            copy.addFirst(v);
            return copy;
        }

        List<String> eVisit(String v) {
            var copy = new LinkedList<>(eRoute);
            copy.addFirst(v);
            return copy;
        }

        int minutes(Map<IdPair, Integer> prices) {
            return minutes(route, prices);
        }

        int eMinutes(Map<IdPair, Integer> prices) {
            return minutes(eRoute, prices);
        }

        private int minutes(List<String> r, Map<IdPair, Integer> prices) {
            if (r.size() < 2) {
                return 0;
            }
            int sum = 0;
            String prev = r.get(r.size()-1);
            for (int i = r.size()-2; i >= 0; --i) {
                ++sum;
                String next = r.get(i);
                sum += prices.get(new IdPair(prev, next));
                prev = next;
            }
            return sum;
        }

        int released(Map<IdPair, Integer> prices, Map<String, Valve> valves) {
            return released(route, prices, valves) + released(eRoute, prices, valves);
        }

        private int released(List<String> r, Map<IdPair, Integer> prices, Map<String, Valve> valves) {
            int res = 0;
            int rate = 0;
            int left = 26;
            //while(left>0) {
            String prev = r.get(r.size()-1);
            for (int i = r.size()-2; i >= 0 && left > 0; --i) {
                String next = r.get(i);
                var price = prices.get(new IdPair(prev, next));
                if(left-price>1) {
                    left -= price;
                    res += (price+1) * rate;
                    --left;
                    rate += valves.get(next).flowRate();
                } else {
                    res += left * rate;
                    left = 0;
                }
                prev = next;
            }
            //}
            return res;
        }
    }

    private static Map<IdPair, Integer> calcPrices(Map<String, Valve> valveMap) {
        var valuables = new ArrayList<>(valveMap.values().stream().filter(v -> v.flowRate() > 0).toList());
        valuables.add(valveMap.get("AA"));
        var result = new HashMap<IdPair, Integer>();
        valuables.forEach(from -> {
            valuables.forEach(to -> {
                if (from != to && !to.id.equals("AA")) {
                    int price = calcPrice(from.id(), to.id(), valveMap);
                    result.put(new IdPair(from.id(), to.id()), price);
                }
            });
        });
        return result;
    }

    private static int calcPrice(String from, String to, Map<String, Valve> valveMap) {
        Queue<List<String>> go = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        visited.add(from);
        go.add(List.of(from));
        while (!go.isEmpty()) {
            var n = go.poll();
            if (n.get(0).equals(to)) {
                return n.size() - 1;
            }
            valveMap.get(n.get(0)).available().stream().filter(s -> !visited.contains(s)).forEach(nn -> {
                var nnn = new LinkedList<>(n);
                nnn.addFirst(nn);
                go.add(nnn);
                visited.add(nn);
            });
        }
        throw new IllegalArgumentException();
    }

    private static final record IdPair(String from, String to) {

    }

    private static final String INPUT_TEST = """
            Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
            Valve BB has flow rate=13; tunnels lead to valves CC, AA
            Valve CC has flow rate=2; tunnels lead to valves DD, BB
            Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
            Valve EE has flow rate=3; tunnels lead to valves FF, DD
            Valve FF has flow rate=0; tunnels lead to valves EE, GG
            Valve GG has flow rate=0; tunnels lead to valves FF, HH
            Valve HH has flow rate=22; tunnel leads to valve GG
            Valve II has flow rate=0; tunnels lead to valves AA, JJ
            Valve JJ has flow rate=21; tunnel leads to valve II""";
    private static final String INPUT = """
    Valve QZ has flow rate=0; tunnels lead to valves IR, FA
    Valve FV has flow rate=0; tunnels lead to valves AA, GZ
    Valve GZ has flow rate=0; tunnels lead to valves FV, PO
    Valve QL has flow rate=0; tunnels lead to valves MR, AA
    Valve AA has flow rate=0; tunnels lead to valves QL, GQ, EV, FV
    Valve SQ has flow rate=23; tunnel leads to valve ZG
    Valve PK has flow rate=8; tunnels lead to valves MN, GN, WF, TY, CX
    Valve GQ has flow rate=0; tunnels lead to valves AA, MT
    Valve TI has flow rate=22; tunnels lead to valves GM, CS
    Valve JU has flow rate=17; tunnels lead to valves TT, RR, UJ, JY
    Valve YD has flow rate=7; tunnels lead to valves AT, ZS, BS
    Valve YB has flow rate=0; tunnels lead to valves EA, MW
    Valve FA has flow rate=0; tunnels lead to valves QZ, JT
    Valve TN has flow rate=0; tunnels lead to valves ZS, PO
    Valve MW has flow rate=0; tunnels lead to valves YB, YL
    Valve XN has flow rate=0; tunnels lead to valves VL, VM
    Valve MN has flow rate=0; tunnels lead to valves PK, TT
    Valve IP has flow rate=9; tunnels lead to valves YC, SA, CH, PI
    Valve PD has flow rate=0; tunnels lead to valves YZ, VM
    Valve ZS has flow rate=0; tunnels lead to valves TN, YD
    Valve PC has flow rate=0; tunnels lead to valves MR, XT
    Valve VM has flow rate=13; tunnels lead to valves CX, XN, PD
    Valve PO has flow rate=4; tunnels lead to valves GZ, TN, SA, XT, BM
    Valve GN has flow rate=0; tunnels lead to valves PK, YL
    Valve YL has flow rate=5; tunnels lead to valves MT, YZ, GN, SU, MW
    Valve IR has flow rate=6; tunnels lead to valves LK, PI, BM, QZ, EV
    Valve GM has flow rate=0; tunnels lead to valves TI, RH
    Valve CS has flow rate=0; tunnels lead to valves UJ, TI
    Valve EA has flow rate=18; tunnels lead to valves VL, YB, WF, JY
    Valve LK has flow rate=0; tunnels lead to valves IR, MR
    Valve BM has flow rate=0; tunnels lead to valves IR, PO
    Valve JZ has flow rate=0; tunnels lead to valves RH, RR
    Valve SA has flow rate=0; tunnels lead to valves IP, PO
    Valve XT has flow rate=0; tunnels lead to valves PO, PC
    Valve YC has flow rate=0; tunnels lead to valves IP, IL
    Valve RH has flow rate=15; tunnels lead to valves WJ, JZ, GM
    Valve CH has flow rate=0; tunnels lead to valves IP, BS
    Valve JY has flow rate=0; tunnels lead to valves EA, JU
    Valve TY has flow rate=0; tunnels lead to valves WJ, PK
    Valve WJ has flow rate=0; tunnels lead to valves TY, RH
    Valve IL has flow rate=0; tunnels lead to valves YC, MR
    Valve BS has flow rate=0; tunnels lead to valves YD, CH
    Valve AT has flow rate=0; tunnels lead to valves YD, UX
    Valve UJ has flow rate=0; tunnels lead to valves CS, JU
    Valve VL has flow rate=0; tunnels lead to valves EA, XN
    Valve JT has flow rate=21; tunnels lead to valves ZG, FA
    Valve UX has flow rate=10; tunnel leads to valve AT
    Valve RR has flow rate=0; tunnels lead to valves JZ, JU
    Valve TT has flow rate=0; tunnels lead to valves JU, MN
    Valve MT has flow rate=0; tunnels lead to valves GQ, YL
    Valve EV has flow rate=0; tunnels lead to valves AA, IR
    Valve ZG has flow rate=0; tunnels lead to valves JT, SQ
    Valve WF has flow rate=0; tunnels lead to valves EA, PK
    Valve YZ has flow rate=0; tunnels lead to valves PD, YL
    Valve MR has flow rate=3; tunnels lead to valves LK, IL, QL, SU, PC
    Valve PI has flow rate=0; tunnels lead to valves IR, IP
    Valve CX has flow rate=0; tunnels lead to valves VM, PK
    Valve SU has flow rate=0; tunnels lead to valves YL, MR""";
}
