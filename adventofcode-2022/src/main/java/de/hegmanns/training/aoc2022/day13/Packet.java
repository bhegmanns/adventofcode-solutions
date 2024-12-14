package de.hegmanns.training.aoc2022.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Packet  implements Comparable<Packet>{


    private List<Packet> children;
    private  int val;
    private boolean integer = true;
    private String line;

    public Packet(String packet) {
        line = packet;

        children = new ArrayList<>();
        if (packet.equals("[]")) {
            val = -1;
        }
        if (!packet.startsWith("[")) {
            val = Integer.parseInt(packet);
        } else {
            packet = packet.substring(1, packet.length() - 1);
            int level = 0;
            String tmp = "";
            for (char c : packet.toCharArray()) {
                if (c == ',' && level == 0) {
                    children.add(new Packet(tmp));
                    tmp = "";
                } else {
                    level += (c == '[') ? 1 : (c == ']') ? -1 : 0;
                    tmp += c;
                }
            }
            if (!tmp.equals("")) {
                children.add(new Packet(tmp));
            }
            integer = false;
        }
    }

    public String getLine() {
        return line;
    }

    @Override
    public int compareTo(Packet other) {
        if (integer && other.integer) {
            return other.val - val;
        }
        if (!integer && !other.integer) {
            for (int i = 0; i < Math.min(children.size(), other.children.size()); i++) {
                int val = children.get(i).compareTo(other.children.get(i));
                if (val != 0) {
                    return val;
                }
            }
            return other.children.size() - children.size();
        }
        Packet lst1 = integer ? new Packet("[" + val + "]") : this;
        Packet lst2 = other.integer ? new Packet("[" + other.val + "]") : other;
        return lst1.compareTo(lst2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packet packet = (Packet) o;
        return Objects.equals(line, packet.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    @Override
    public String toString() {
        return "Packet{" +
                "line='" + line + '\'' +
                '}';
    }
}

