package org.example.services;

import java.util.Objects;
import java.util.Random;

public class Product {
    private final double NDS = 1.2;
    private final String name;
    private final double cost;
    private final int rate;
    private int inStock;
    //FullConstructor
    public Product(String name, double cost, int inStock, int rate) {
        this.name = name;
        this.rate = rate;
        this.cost = cost * NDS;
        this.inStock = inStock;
    }
    //CartConstructor
    public Product(Product obj, int count) {
        this.name = obj.getName();
        this.rate = obj.getRate();
        this.cost = obj.getCost();
        this.inStock = count;
    }
    //SimpleConstructor
    public Product(String name, int cost) {
        Random random = new Random();
        this.name = name;
        this.rate = random.nextInt(101);
        this.cost = cost * NDS;
        this.inStock = random.nextInt(300);
    }


    public int getRate() {
        return rate;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    public void buy(int count){
        setInStock(getInStock() - count);
    }
    public double toCart(int count){
        if (availableForBuy(count)){
            return count * getCost();
        } else return -1;
    }
    private boolean availableForBuy(int count){
        if (count <= 0){
            throw new IllegalArgumentException("Вы должны купить положительное количество товаров");
        }
        return count <= inStock;
    }

    @Override
    public String toString() {
        return "Товар: " + getName() +
                "\nСтоимость: " + getCost() + "р за товар" +
                "\nТоварный рейтинг: " + getRate() + "/100" +
                "\nВ наличии товаров: " + getInStock();
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }
}
