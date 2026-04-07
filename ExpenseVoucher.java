package warehouse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Зарлагын падаан - агуулахаас бараа гаргасны баримт
 */
public class ExpenseVoucher {
    private String voucherId;           // Падааны дугаар
    private LocalDate expenseDate;      // Зарлагадсан огноо
    private String receivedBy;          // Хүлээн авсан хүн
    private Storekeeper issuedBy;       // Гаргасан нярав
    private List<VoucherItem> items;    // Барааны жагсаалт
    public ExpenseVoucher(String voucherId, LocalDate expenseDate,
String receivedBy, Storekeeper issuedBy) {
        this.voucherId = voucherId;
        this.expenseDate = expenseDate;
        this.receivedBy = receivedBy;
        this.issuedBy = issuedBy;
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
        System.out.println("======= ЗАРЛАГЫН ПАДААН =======");
        System.out.println("Дугаар         : " + voucherId);
        System.out.println("Огноо          : " + expenseDate);
        System.out.println("Хүлээн авсан   : " + receivedBy);
        System.out.println("Нярав          : " + issuedBy.getName());
        System.out.println("--------- Барааны жагсаалт ---------");
        for (VoucherItem item : items) {
            System.out.println(item);
        }
        System.out.printf("Нийт дүн       : %.2f₮%n", getTotalAmount());
        System.out.println("================================");
    }
    // Getters
    public String getVoucherId() { return voucherId; }
    public LocalDate getExpenseDate() { return expenseDate; }
    public String getReceivedBy() { return receivedBy; }
    public Storekeeper getIssuedBy() { return issuedBy; }
    public List<VoucherItem> getItems() { return items; }
}
