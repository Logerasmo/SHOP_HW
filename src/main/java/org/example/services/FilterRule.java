package org.example.services;

import java.util.function.Predicate;

public class FilterRule {
    private final Predicate<Product> predicate;
    private final String describe;
    public FilterRule(Predicate<Product> predicate, String describe) {
        this.predicate = predicate;
        this.describe = describe;
    }

    public Predicate<Product> getPredicate() {
        return predicate;
    }

    @Override
    public String toString() {
        return describe;
    }
}
