import java.util.*;
import java.util.stream.Collectors;

class Product {
	private String name;
	private double price;
	private String category;

	public Product(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	 public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
	}
}

public class ProductAnalyzer {
	public static Map<String, List<Product>> analyze(List<Product> products) {
	return products.stream()
                .filter(p -> p.getPrice() > 1000)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.groupingBy(Product::getCategory));
	}

	public static void main(String[] args) {
		List<Product> items = Arrays.asList(
				new Product("Гутал", 1500, "Хувцас"),
				new Product("Тоглоом", 800, "Тоглоом"),
				new Product("Цамц", 1200, "Хувцас"));
		// Хэрэгжүүл: analyze дуудаж, хэвлэ
	}
}