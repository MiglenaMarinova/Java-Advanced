package SetsAndMaps.Lab;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shopProduct = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            Double price = Double.parseDouble(input.split(", ")[2]);
            shopProduct.putIfAbsent(shop, new LinkedHashMap<>());
            LinkedHashMap<String, Double> productPrice = shopProduct.get(shop);
            productPrice.put(product, price);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Double>> shop : shopProduct.entrySet()) {
            System.out.println(shop.getKey() + "->");
            for (Map.Entry<String, Double> entry : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
            }

        }

    }


}
