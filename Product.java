package warehouse;
import java.time.LocalDate;
/**
 * Бараа - агуулахад хадгалагдаж байгаа бараа бүтээгдэхүүн
 */
public class Product {
    private String productId;       // Барааны код
    private String name;            // Барааны нэр
    private String unit;            // Хэмжих нэгж (ш, кг, л гэх мэт)
    private double quantity;        // Одоогийн үлдэгдэл тоо ширхэг
    private double price;           // Нэгжийн үнэ
    public Product(String productId, String name, String unit, double quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
    }
    // Барааны тоо ширхэгийг нэмэх (орлого)
    public void addQuantity(double amount) {
        this.quantity += amount;
    }
    // Барааны тоо ширхэгийг хасах (зарлага)
    public void subtractQuantity(double amount) {
        if (amount > this.quantity) {
            throw new IllegalArgumentException("Үлдэгдэл хүрэлцэхгүй байна!");
        }
        this.quantity -= amount;
    }
    // Тооллогоор тоо ширхэгийг шинэчлэх
    public void updateQuantity(double actualQuantity) {
        this.quantity = actualQuantity;
    }
    // Getters & Setters
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getUnit() { return unit; }
    public double getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    @Override
    public String toString() {
        return String.format("[%s] %s | Үлдэгдэл: %.2f %s | Үнэ: %.2f₮",
                productId, name, quantity, unit, price);
    }
}
