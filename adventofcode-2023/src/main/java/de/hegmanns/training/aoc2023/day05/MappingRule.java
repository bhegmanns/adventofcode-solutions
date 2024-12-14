package de.hegmanns.training.aoc2023.day05;

import java.util.ArrayList;
import java.util.List;

public class MappingRule {

    private String title;
    private String from;
    private String to;

    private FromTo fromTo;

    private List<MappingDefinition> mappinDefinitions = new ArrayList<>();
    public MappingRule(String titleDefinition, String ... definitionsLines) {
        //seed-to-soil map:
        String[] s = titleDefinition.trim().split(" ");
        String[] split = s[0].trim().split("-");
        this.from = split[0].trim();
        this.to = split[2].trim();
        this.fromTo = new FromTo(from, to);
        this.title = titleDefinition;
        for (String line : definitionsLines) {
            mappinDefinitions.add(MappingDefinition.createMappingDefinition(line));
        }
    }

    public long getCorresponding(long from) {

        for (MappingDefinition mappingDefinition : mappinDefinitions) {
            if (mappingDefinition.source <= from && mappingDefinition.source + mappingDefinition.length > from) {
                long diff = mappingDefinition.destination - mappingDefinition.source;
                return from+diff;
            }
        }


        return from;
    }
    public FromTo getFromTo() {
        return fromTo;
    }

    public String getFrom() {
        return fromTo.from();
    }

    public String getTo() {
        return fromTo.to();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MappingDefinition> getMappinDefinitions() {
        return mappinDefinitions;
    }

    public void setMappinDefinitions(List<MappingDefinition> mappinDefinitions) {
        this.mappinDefinitions = mappinDefinitions;
    }

    private record MappingDefinition(long destination, long source, long length) {

        public static MappingDefinition createMappingDefinition(String mappingDefinitionLine) {
            //50 98 2
            // <destination> <source> <range-length>
            String[] s = mappingDefinitionLine.trim().split(" ");
            long destination = Long.parseLong(s[0].trim());
            long source = Long.parseLong(s[1].trim());
            long length = Long.parseLong(s[2].trim());
            return new MappingDefinition(destination, source, length);
        }
    }


    public static class MappingRuleBuilder{
        private String title;
        private List<String> definitionsLines = new ArrayList<>();

        public static MappingRuleBuilder create(String title) {
            MappingRuleBuilder builder = new MappingRuleBuilder();
            builder.title = title;
            return builder;
        }

        public MappingRuleBuilder withDefinitionLine(String definitionLine) {
            definitionsLines.add(definitionLine);
            return this;
        }

        public MappingRule build() {
            MappingRule rule = new MappingRule(this.title, definitionsLines.toArray(new String[0]));
            return rule;
        }
    }

}
