package org.example.services;

import java.util.function.Predicate;

public class PredicateBuilder {
    private Predicate<Product> predicate = new Predicate<Product>() {
        @Override
        public boolean test(Product product) {
            return true;
        }
    };
    public PredicateBuilder(){}
    private PredicateBuilder(Predicate<Product> predicate){
        this.predicate = predicate;
    }
    public PredicateBuilder cost(int lower, int higher){
        this.predicate = this.predicate.and(product -> product.getCost() >= lower && product.getCost() <= higher);
        return this;
    }
    public PredicateBuilder rate(int lower, int higher){
        this.predicate = this.predicate.and(product -> product.getRate() >= lower && product.getRate() <= higher);
        return this;
    }
    public PredicateBuilder inStock(int lower, int higher){
        this.predicate = this.predicate.and(product -> product.getInStock() >= lower && product.getInStock() <= higher);
        return this;
    }

    public Predicate<Product> getPredicate() {
        return predicate;
    }
}
