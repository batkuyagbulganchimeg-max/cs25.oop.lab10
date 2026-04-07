package warehouse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Агуулах - барааг хадгалах, орлого/зарлагыг бүртгэх газар
 */
public class Warehouse {
    private String warehouseId;                     // Агуулахын код
    private String name;                            // Агуулахын нэр
    private String location;                        // Байршил
    private Storekeeper storekeeper;                // Хариуцаж байгаа нярав
    private List<Product> products;                 // Агуулахад байгаа бараанууд
    private List<ReceiptVoucher> receiptVouchers;   // Орлогын падаанууд
    private List<ExpenseVoucher> expenseVouchers;   // Зарлагын падаанууд
    private List<InventoryRecord> inventoryRecords; // Тооллогын бүртгэлүүд
    public Warehouse(String warehouseId, String name, String location) {
        this.warehouseId = warehouseId;
        this.name = name;
        this.location = location;
        this.products = new ArrayList<>();
        this.receiptVouchers = new ArrayList<>();
        this.expenseVouchers = new ArrayList<>();
        this.inventoryRecords = new ArrayList<>();
    }
    // Агуулахад бараа бүртгэх
    public void addProduct(Product product) {
        products.add(product);
    }
    // Орлогын падааныг бүртгэх
    public void addReceiptVoucher(ReceiptVoucher voucher) {
        receiptVouchers.add(voucher);
    }
    // Зарлагын падааныг бүртгэх
    public void addExpenseVoucher(ExpenseVoucher voucher) {
        expenseVouchers.add(voucher);
    }
    // Тооллогын бүртгэл нэмэх
    public void addInventoryRecord(InventoryRecord record) {
        inventoryRecords.add(record);
    }
    // Нярав томилох
    public void assignStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
        storekeeper.setWarehouse(this);
    }
    // =================== ТАЙЛАНГУУД ===================
    /**
     * Нөөцийн тайлан - бүх бараагаар
     */
    public void printStockReport() {
        printStockReport(products);
    }
    /**
     * Нөөцийн тайлан - сонгосон бараагаар
     */
    public void printStockReport(List<Product> selectedProducts) {
        System.out.println("\n========= БАРААНЫ НӨӨЦИЙН ТАЙЛАН =========");
        System.out.println("Агуулах: " + name + " | Тайлангийн огноо: " + LocalDate.now());
        System.out.println("-------------------------------------------");
        System.out.printf("%-8s %-20s %-10s %-12s %-12s%n",
                "Код", "Нэр", "Нэгж", "Үлдэгдэл", "Үнэ");
        System.out.println("-------------------------------------------");
        for (Product p : selectedProducts) {
            System.out.printf("%-8s %-20s %-10s %-12.2f %-12.2f%n",
                    p.getProductId(), p.getName(), p.getUnit(), p.getQuantity(), p.getPrice());
        }
        System.out.println("===========================================\n");
    }
    /**
     * Няравын тайлан - бүх бараагаар, огноогоор шүүж
     */
    public void printStorekeeperReport(LocalDate startDate, LocalDate endDate) {
        printStorekeeperReport(startDate, endDate, products);
    }
    /**
     * Няравын тайлан - сонгосон бараа болон огноогоор шүүж
     */
    public void printStorekeeperReport(LocalDate startDate, LocalDate endDate, List<Product> selectedProducts) {
        System.out.println("\n========= НЯРАВЫН ТАЙЛАН =========");
        System.out.println("Агуулах : " + name);
        System.out.println("Нярав   : " + (storekeeper != null ? storekeeper.getName() : "-"));
        System.out.println("Хугацаа : " + startDate + " - " + endDate);
        System.out.println("-----------------------------------");
        for (Product product : selectedProducts) {
            // Тухайн хугацааны орлогыг тооцоолох
            double totalReceipt = receiptVouchers.stream()
                    .filter(v -> !v.getReceiptDate().isBefore(startDate) && !v.getReceiptDate().isAfter(endDate))
                    .flatMap(v -> v.getItems().stream())
                    .filter(item -> item.getProduct().getProductId().equals(product.getProductId()))
                    .mapToDouble(VoucherItem::getQuantity)
                    .sum();

            // Тухайн хугацааны зарлагыг тооцоолох
            double totalExpense = expenseVouchers.stream()
                    .filter(v -> !v.getExpenseDate().isBefore(startDate) && !v.getExpenseDate().isAfter(endDate))
                    .flatMap(v -> v.getItems().stream())
                    .filter(item -> item.getProduct().getProductId().equals(product.getProductId()))
                    .mapToDouble(VoucherItem::getQuantity)
                    .sum();
            // Эхний үлдэгдэл = одоогийн үлдэгдэл - орлого + зарлага
            double openingBalance = product.getQuantity() - totalReceipt + totalExpense;
            double closingBalance = product.getQuantity();
            System.out.printf("Бараа          : %s%n", product.getName());
            System.out.printf("Эхний үлдэгдэл : %.2f %s%n", openingBalance, product.getUnit());
            System.out.printf("Нийт орлого    : %.2f %s%n", totalReceipt, product.getUnit());
            System.out.printf("Нийт зарлага   : %.2f %s%n", totalExpense, product.getUnit());
            System.out.printf("Эцсийн үлдэгдэл: %.2f %s%n", closingBalance, product.getUnit());
            System.out.println("-----------------------------------");
        }
        System.out.println("===================================\n");
    }
    // Getters
    public String getWarehouseId() { return warehouseId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public Storekeeper getStorekeeper() { return storekeeper; }
    public List<Product> getProducts() { return products; }
    public List<ReceiptVoucher> getReceiptVouchers() { return receiptVouchers; }
    public List<ExpenseVoucher> getExpenseVouchers() { return expenseVouchers; }
    public List<InventoryRecord> getInventoryRecords() { return inventoryRecords; }

    @Override
    public String toString() {
        return String.format("Агуулах: %s (%s) - %s", name, warehouseId, location);
    }
}
