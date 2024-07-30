package app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        // Групування продуктів за категоріями та обчислення середньої ціни
        Map<String, Double> averagePricesByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));

        // Виведення середньої ціни за категоріями
        System.out.println("Середні ціни за категоріями: " + averagePricesByCategory);

        // Знаходження категорії з найвищою середньою ціною
        Optional<Map.Entry<String, Double>> maxAveragePriceCategory = averagePricesByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        // Виведення категорії з найвищою середньою ціною
        maxAveragePriceCategory.ifPresent(entry ->
                System.out.println("Категорія з найвищою середньою ціною: " + entry.getKey() + " (" + entry.getValue() + ")")
        );
    }
}
