package warehouse;
import java.time.LocalDate;
/**
 * Тооллогын бүртгэл - нэг барааны тооллогын үр дүн
 */
public class InventoryRecord {
    private LocalDate inventoryDate;    // Тооллого хийсэн огноо
    private Product product;            // Тоологдсон бараа
    private double expectedQuantity;    // Байвал зохих үлдэгдэл
    private double actualQuantity;      // Бодит тоо хэмжээ
    private double difference;          // Зөрүү (илүүдэл/дутагдал)

    public InventoryRecord(LocalDate inventoryDate, Product product,
double expectedQuantity, double actualQuantity) {
        this.inventoryDate = inventoryDate;
        this.product = product;
        this.expectedQuantity = expectedQuantity;
        this.actualQuantity = actualQuantity;
        this.difference = actualQuantity - expectedQuantity; // + илүүдэл, - дутагдал
    }
    // Тооллогын үр дүнг хэвлэх
    public void print() {
        System.out.println("======= ТООЛЛОГЫН БҮРТГЭЛ =======");
        System.out.println("Огноо              : " + inventoryDate);
        System.out.println("Бараа              : " + product.getName());
        System.out.printf("Байвал зохих       : %.2f %s%n", expectedQuantity, product.getUnit());
        System.out.printf("Бодит тоо          : %.2f %s%n", actualQuantity, product.getUnit());
        String diffLabel = difference >= 0 ? "Илүүдэл" : "Дутагдал";
        System.out.printf("%-19s: %.2f %s%n", diffLabel, Math.abs(difference), product.getUnit());
        System.out.println("================================");
    }
    // Getters
    public LocalDate getInventoryDate() { return inventoryDate; }
    public Product getProduct() { return product; }
    public double getExpectedQuantity() { return expectedQuantity; }
    public double getActualQuantity() { return actualQuantity; }
    public double getDifference() { return difference; }
}
