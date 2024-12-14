package de.hegmanns.training.aoc2023.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Almanach {




    private Map<FromTo, MappingRule> mappingRules = new HashMap<>();

    public Almanach() {

    }

    public void addMappingRule(MappingRule rule) {
        mappingRules.put(rule.getFromTo(), rule);
    }

    private Long getSearchResult(Long from, List<MappingRule> rules) {
        long corresponding = -1;
        Long source = from;
        for (MappingRule rule : rules) {
            Long finalSource = source;
            corresponding = rule.getCorresponding(finalSource);
            source = corresponding;
        }
        return corresponding;
    }

    public Map<Long, Long> getLocationsFromSeed(String from, String to, List<Long> froms) {
        List<MappingRule> mappingRules1 = organizeSearch(to, from);

        Map<Long, Long> result = new HashMap<>();
        for (Long i : froms) {
            Long searchResult = getSearchResult(i, mappingRules1);
            result.put(i, searchResult);
        }

        return result;
    }

    public Long getLowestNumber(String from, String to, long start, long range) {
        List<MappingRule> searchAlgorithm = organizeSearch(to, from);
        Long lowestNumber = getSearchResult(start, searchAlgorithm);
        for (long l = start+1; l <= start + range; l++) {
            lowestNumber = Math.min(lowestNumber, getSearchResult(l, searchAlgorithm));
        }
        return lowestNumber;
    }

    private List<MappingRule> organizeBackwardSearch(String search, String start) {
        List<MappingRule> searchProcess = new ArrayList<>();
        String currentSearch = search;

        while (!currentSearch.equals(start)) {
            String finalCurrentSearch = currentSearch;
            FromTo fromTo = mappingRules.keySet().stream().filter(f -> f.to().equals(finalCurrentSearch)).findFirst().get();
            currentSearch = fromTo.from();
            searchProcess.add(mappingRules.get(fromTo));
        }

        return searchProcess;
    }

    private List<MappingRule> organizeSearch(String search, String start) {
        List<MappingRule> searchProcess = new ArrayList<>();

        String finalStart = start;
        FromTo from = mappingRules.keySet().stream().filter(f -> f.from().equals(finalStart)).findFirst().get();
        searchProcess.add(mappingRules.get(from));


        while (!from.to().equals(search)) {
            String newStart = from.to();
            from = mappingRules.keySet().stream().filter(f -> f.from().equals(newStart)).findFirst().orElseThrow(() -> new RuntimeException("" + newStart +" missing"));
            searchProcess.add(mappingRules.get(from));
        }

        return searchProcess;
    }
}
