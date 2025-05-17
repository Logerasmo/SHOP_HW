package org.example.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.Main.scanner;

public class Cart {
    private final Map<Product, Integer> cart = new HashMap<>();
    private final UserCommunication uc;

    protected Cart(UserCommunication uc){
        this.uc = uc;
    }

    public Map<Product, Integer> getProductMap(Boolean printResult) {
        if (printResult){
            StringBuilder sb = new StringBuilder();
            int i = 1;
            sb.append("Корзина товаров\n");
            for (Product product : cart.keySet()){
                sb.append("Продукт #").
                        append(i).
                        append("\nТовар: ").append(product.getName()).
                        append("\nКоличество: ").append(cart.get(product)).
                        append("\nНа сумму: ").append(product.getCost() * cart.get(product)).
                        append("\n------------------------\n");
                i++;
            }
            sb.append("Итого: ").append(getCost());
            System.out.println(sb);
        }
        return cart;
    }
    public double getCost(){
        double cost = 0;
        for(Product product : cart.keySet()){
            cost += product.getCost() * cart.get(product);
        }
        return cost;
    }
    public void buy(){
        Map<Product, Integer> productMap = getProductMap(true);
        System.out.println("Вы уверены что хотите купить товары из корзины?(оставьте пустым для отказа)");
        double cost = getCost();
        String s = scanner.nextLine();
        if (s.isBlank()) return;
        for (Product product : uc.getProductList(false)){
            for (Product cartProduct : productMap.keySet()){
                if (product.equals(cartProduct)){
                    product.buy(productMap.get(product));
                }
            }
        }
        System.out.println("Совершена покупка на " + cost + " р.");
    }
    public void add(){
        List<Product> list = uc.getProductList(true);
        System.out.print("Введите номер товара для покупки: ");
        String a = scanner.nextLine();
        while (!a.isEmpty()) {
            int productNum;
            try {
                productNum = Integer.parseInt(a) - 1;
            } catch (Exception e) {
                throw new RuntimeException("Введите ТОЛЬКО номер товара");
            }
            System.out.print("Введите количество товара ");
            a = scanner.nextLine();
            int productCount;
            try {
                productCount = Integer.parseInt(a);
            } catch (Exception e) {
                throw new RuntimeException("Введите ТОЛЬКО количество товара");
            }
            Product product = list.get(productNum);
            if (cart.containsKey(product)){
                productCount += cart.get(product);
            }
            double costPerProduct = product.toCart(productCount);
            if (costPerProduct > 0){
                cart.put(new Product(product, productCount), productCount);
                System.out.println("В корзину добавлен" +
                        "\nТовар: " + product.getName() +
                        "\nНа сумму: " + costPerProduct);
            } else {
                System.out.println("Недостаточно товаров на складе!");
            }
            getProductMap(true);
            System.out.print("Введите номер товара для покупки(оставьте пустым для окончания составления корзины): ");
            a = scanner.nextLine();

        }

    }
}
