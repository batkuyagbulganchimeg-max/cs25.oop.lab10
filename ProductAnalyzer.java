import java.util.*;
import java.util.stream.*;

public class ProductAnalyzer {
    public static class Product {
        private String name;
        private String category;
        private double price;
        public Product(String name, String category, double price) {
            this.name     = name;
            this.category = category;
            this.price    = price;
        }
        public String getName()     { return name;     }
        public String getCategory() { return category; }
        public double getPrice()    { return price;    }

        @Override
        public String toString() {
            return name + " (" + (int) price + ")";
        }
    }
    public static Map<String, List<Product>> analyze(List<Product> products) {
        return products.stream()
            .filter(p -> p.getPrice() > 1000)
            .sorted(Comparator
                .comparing(Product::getCategory)
                .thenComparing(Comparator.comparingDouble(Product::getPrice).reversed()))
            .collect(Collectors.groupingBy(
                Product::getCategory,
                LinkedHashMap::new,      
                Collectors.toList()
            ));
    }
}