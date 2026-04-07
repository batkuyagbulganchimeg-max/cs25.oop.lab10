package warehouse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Нярав - агуулахыг хариуцаж байгаа ажилтан
 */
public class Storekeeper {
    private String employeeId;              // Ажилтны код
    private String name;                    // Нэр
    private Warehouse warehouse;            // Хариуцаж байгаа агуулах
    public Storekeeper(String employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }
    /**
     * Барааг орлогоор хүлээн авах
     * @param voucher Орлогын падаан (барааны жагсаалттай)
     */
    public void receiveGoods(ReceiptVoucher voucher) {
        for (VoucherItem item : voucher.getItems()) {
            item.getProduct().addQuantity(item.getQuantity());
        }
        warehouse.addReceiptVoucher(voucher);
        System.out.println("✔ Орлого амжилттай бүртгэгдлээ.");
        voucher.print();
    }
    /**
     * Барааг зарлагаар гаргах
     * @param voucher Зарлагын падаан (барааны жагсаалттай)
     */
    public void issueGoods(ExpenseVoucher voucher) {
        for (VoucherItem item : voucher.getItems()) {
            item.getProduct().subtractQuantity(item.getQuantity());
        }
        warehouse.addExpenseVoucher(voucher);
        System.out.println("✔ Зарлага амжилттай бүртгэгдлээ.");
        voucher.print();
    }
    /**
     * Барааны нөөцийн тайланг харах (бүх бараа)
     */
    public void viewStockReport() {
        warehouse.printStockReport();
    }
    /**
     * Барааны нөөцийн тайланг харах (сонгосон бараагаар)
     * @param products Тайлан харах барааны жагсаалт
     */
    public void viewStockReport(List<Product> products) {
        warehouse.printStockReport(products);
    }
    /**
     * Няравын тайланг харах (огноогоор)
     * @param startDate Эхлэх огноо
     * @param endDate   Дуусах огноо
     */
    public void viewStorekeeperReport(LocalDate startDate, LocalDate endDate) {
        warehouse.printStorekeeperReport(startDate, endDate);
    }
    /**
     * Няравын тайланг харах (огноо + сонгосон бараагаар)
     * @param startDate Эхлэх огноо
     * @param endDate   Дуусах огноо
     * @param products  Тайлан харах барааны жагсаалт
     */
    public void viewStorekeeperReport(LocalDate startDate, LocalDate endDate, List<Product> products) {
        warehouse.printStorekeeperReport(startDate, endDate, products);
    }
    /**
     * Тооллого хийх (нэг барааг бодит тоогоор шинэчлэх)
     * @param product        Тоологдох бараа
     * @param inventoryDate  Тооллого хийсэн огноо
     * @param actualQuantity Бодит тоо хэмжээ
     * @return Тооллогын бүртгэл
     */
    public InventoryRecord doInventory(Product product, LocalDate inventoryDate, double actualQuantity) {
        double expected = product.getQuantity();
        InventoryRecord record = new InventoryRecord(inventoryDate, product, expected, actualQuantity);
        product.updateQuantity(actualQuantity);
        warehouse.addInventoryRecord(record);
        System.out.println("✔ Тооллого амжилттай бүртгэгдлээ.");
        record.print();
        return record;
    }
    // Getters & Setters
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public Warehouse getWarehouse() { return warehouse; }
    public void setWarehouse(Warehouse warehouse) { this.warehouse = warehouse; }
    @Override
    public String toString() {
        return String.format("Нярав: %s (%s)", name, employeeId);
    }
}
