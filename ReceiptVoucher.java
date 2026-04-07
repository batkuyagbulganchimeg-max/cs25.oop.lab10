package warehouse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Орлогын падаан - агуулахад бараа хүлээн авсны баримт
 */
public class ReceiptVoucher {
    private String voucherId;           // Падааны дугаар
    private LocalDate receiptDate;      // Хүлээн авсан огноо
    private String deliveredBy;         // Хүлээлгэн өгсөн хүн
    private Storekeeper receivedBy;     // Хүлээн авсан нярав
    private List<VoucherItem> items;    // Барааны жагсаалт
    public ReceiptVoucher(String voucherId, LocalDate receiptDate,
String deliveredBy, Storekeeper receivedBy) {
        this.voucherId = voucherId;
        this.receiptDate = receiptDate;
        this.deliveredBy = deliveredBy;
        this.receivedBy = receivedBy;
        this.items = new ArrayList<>();
    }
    // Падаанд бараа нэмэх
    public void addItem(VoucherItem item) {
        items.add(item);
    }
    // Нийт дүн тооцоолох
    public double getTotalAmount() {
        return items.stream().mapToDouble(VoucherItem::getTotalAmount).sum();
    }
    // Падааныг хэвлэх
    public void print() {
        System.out.println("======= ОРЛОГЫН ПАДААН =======");
        System.out.println("Дугаар     : " + voucherId);
        System.out.println("Огноо      : " + receiptDate);
        System.out.println("Өгсөн хүн  : " + deliveredBy);
        System.out.println("Хүлээн авсан нярав: " + receivedBy.getName());
        System.out.println("--------- Барааны жагсаалт ---------");
        for (VoucherItem item : items) {
            System.out.println(item);
        }
        System.out.printf("Нийт дүн   : %.2f₮%n", getTotalAmount());
        System.out.println("================================");
    }
    // Getters
    public String getVoucherId() { return voucherId; }
    public LocalDate getReceiptDate() { return receiptDate; }
    public String getDeliveredBy() { return deliveredBy; }
    public Storekeeper getReceivedBy() { return receivedBy; }
    public List<VoucherItem> getItems() { return items; }
}
