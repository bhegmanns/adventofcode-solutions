package de.hegmanns.training.aoc2022.day16;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc2022.SolutionDay16;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValveRasterTest {

    @Test
    public void loadValve() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay16.class, "day16.txt");

        ValveRaster valveRaster = new ValveRaster();
        valveRaster.readRasterDefinition(inputAsList);

        Set<Valve> valves = valveRaster.getValves();
        MatcherAssert.assertThat(valves, Matchers.hasSize(10));

        Map<String, Valve> valveMap = valveRaster.getValveMap();

        Valve valve = valveMap.get("AA");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("AA"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(0));
        List<Tunnel> tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(3));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("BB");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("BB"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(13));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(2));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("CC");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("CC"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(2));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(2));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("DD");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("DD"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(20));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(3));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("EE");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("EE"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(3));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(2));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("FF");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("FF"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(0));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(2));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("GG");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("GG"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(0));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(2));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("HH");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("HH"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(22));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(1));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("II");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("II"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(0));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(2));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));

        valve = valveMap.get("JJ");
        MatcherAssert.assertThat(valve, Matchers.notNullValue());
        MatcherAssert.assertThat(valve.getName(), Matchers.is("JJ"));
        MatcherAssert.assertThat(valve.getFlowRate(), Matchers.is(21));
        tunnels = valve.getTunnels();
        MatcherAssert.assertThat(tunnels, Matchers.hasSize(1));
        MatcherAssert.assertThat(tunnels.stream().filter(t -> t.getConnectedValves().size()!=2).count(), Matchers.is(0L));
    }
}
