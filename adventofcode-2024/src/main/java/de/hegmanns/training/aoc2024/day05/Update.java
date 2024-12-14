package de.hegmanns.training.aoc2024.day05;

import lombok.*;

import java.util.*;

@Data
public class Update {
    private List<Long> pages = new ArrayList<>();

    public static class Builder {
        private Update update = new Update();
        public static Builder builder() {
            return new Builder();
        }

        public Builder addPage(long page) {
            update.getPages().add(page);
            return this;
        }

        public Update build() {
            return update;
        }
    }
}
