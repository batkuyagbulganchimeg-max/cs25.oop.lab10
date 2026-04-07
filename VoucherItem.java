package warehouse;
/**
 * Падааны мөр - нэг барааны орлого/зарлагын дэлгэрэнгүй
 */
public class VoucherItem {
    private Product product;    // Бараа
    private double quantity;    // Тоо ширхэг
    private double unitPrice;   // Нэгжийн үнэ
    public VoucherItem(Product product, double quantity, double unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    public double getTotalAmount() {
        return quantity * unitPrice;
    }
    // Getters
    public Product getProduct() { return product; }
    public double getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    @Override
    public String toString() {
        return String.format("  Бараа: %s | Тоо: %.2f | Үнэ: %.2f₮ | Дүн: %.2f₮",
                product.getName(), quantity, unitPrice, getTotalAmount());
    }
}
