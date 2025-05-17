package org.example.services;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.scanner;

public class UserCommunication {
    public Cart cart = new Cart(this);
    private List<FilterRule> filterRuleList = new ArrayList<>();
    private List<Product> productList = List.of(
            new Product("Белый хлеб", 25),
            new Product("Сырок глазированный", 40),
            new Product("Вода", 60),
            new Product("Печенье", 120),
            new Product("Йогурт", 70),
            new Product("Молоко", 80),
            new Product("Корм для собак", 30),
            new Product("Корм для кошек", 30),
            new Product("Жвачка", 25)
    );
    public void addProduct(Product product){
        productList.add(product);
    }

    public void createFilterRule(){
        PredicateBuilder predicateBuilder = new PredicateBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Создания нового профиля для фильтра");
        System.out.println("Хотите добавить фильтр на стоимость? (оставьте пустым для отказа)");
        if (!scanner.nextLine().isBlank()){
            System.out.println("Введите нижнюю и верхнюю границу через пробел, если границы нет поставьте 0 " +
                    "\nПример: (10 100/10 0)");
            String[] result = scanner.nextLine().split(" ");
            if (result[0].equals("0") && result[1].equals("0")){
                throw new IllegalArgumentException("Границы не должны быть пустыми!");
            }
            predicateBuilder.cost(Integer.parseInt(result[0]), result[1].equals("0") ? Integer.MAX_VALUE : Integer.parseInt(result[1]));
            if (!result[0].equals("0")){
                stringBuilder.append("Стоимость >= ").append(result[0]).append("\n");
            }
            if (!result[1].equals("0")){
                stringBuilder.append("Стоимость <= ").append(result[1]).append("\n");
            }
        }
        System.out.println("Хотите добавить фильтр на товарный рейтинг? (оставьте пустым для отказа)");
        if (!scanner.nextLine().isBlank()) {
            System.out.println("Введите нижнюю и верхнюю границу через пробел, если границы нет поставьте 0 " +
                    "\nПример: (10 100/10 0)");
            String[] result = scanner.nextLine().split(" ");
            if (result[0].equals("0") && result[1].equals("0")){
                throw new IllegalArgumentException("Границы не должны быть пустыми!");
            }
            predicateBuilder.rate(Integer.parseInt(result[0]), result[1].equals("0") ? Integer.MAX_VALUE : Integer.parseInt(result[1]));
            if (!result[0].equals("0")) {
                stringBuilder.append("Товарный рейтинг >= ").append(result[0]).append("\n");
            }
            if (!result[1].equals("0")) {
                stringBuilder.append("Товарный рейтинг <= ").append(result[1]).append("\n");
            }
        }
        System.out.println("Хотите добавить фильтр на количество товара в наличии? (оставьте пустым для отказа)");
        if (!scanner.nextLine().isBlank()) {
            System.out.println("Введите нижнюю и верхнюю границу через пробел, если границы нет поставьте 0 " +
                    "\nПример: (10 100/10 0)");
            String[] result = scanner.nextLine().split(" ");
            if (result[0].equals("0") && result[1].equals("0")){
                throw new IllegalArgumentException("Границы не должны быть пустыми!");
            }
            predicateBuilder.rate(Integer.parseInt(result[0]), result[1].equals("0") ? Integer.MAX_VALUE : Integer.parseInt(result[1]));
            if (!result[0].equals("0")) {
                stringBuilder.append("Товаров в наличии >= ").append(result[0]).append("\n");
            }
            if (!result[1].equals("0")) {
                stringBuilder.append("Товаров в наличии <= ").append(result[1]).append("\n");
            }
        }
        filterRuleList.add(new FilterRule(predicateBuilder.getPredicate(), stringBuilder.toString()));
    }

    public List<FilterRule> getFilterRuleList(Boolean printResult) {
        if (printResult){
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for (FilterRule filterRule : filterRuleList){
                sb.append("Правило #").append(i).append("\n").append(filterRule).append("------------------------\n");
                i++;
            }
            System.out.println(sb);
        }
        return filterRuleList;
    }
    public List<Product> getProductList(Boolean printResult) {
        if (printResult){
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for (Product product : productList){
                sb.append("Продукт #").append(i).append("\n").append(product).append("\n------------------------\n");
                i++;
            }
            System.out.println(sb);
        }
        return productList;
    }

    public List<Product> getFilteredList(Boolean printResult , FilterRule filterRule) {
        List<Product> filteredList = getProductList(false).stream().filter(filterRule.getPredicate()).toList();
        if (printResult){
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for (Product product : filteredList){
                sb.append("Продукт #").append(i).append("\n").append(product).append("\n------------------------\n");
                i++;
            }
            System.out.println(sb);
        }
        return filteredList;
    }




}
