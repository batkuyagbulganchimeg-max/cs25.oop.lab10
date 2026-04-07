package warehouse;
import java.time.LocalDate;
import java.util.List;
/** Агуулахын системийн үндсэн програм - туршилтын жишээ
 */
public class Main {
public static void main(String[] args) {
        /** 1. АГУУЛАХ БОЛОН НЯРАВ ҮҮСГЭХ**/
        Warehouse warehouse = new Warehouse("WH001", "Сумын тэжээлийн агуулах", "Ховд аймаг Үенч сум");
        Storekeeper storekeeper = new Storekeeper("EMP001", "Г.Ууганбаяр");
        warehouse.assignStorekeeper(storekeeper);
        System.out.println("✔ " + warehouse);
        System.out.println("✔ " + storekeeper + " томилогдлоо.\n"); 
        // 2. БАРААГ АГУУЛАХАД БҮРТГЭХ 
        Product p1 = new Product("P001", "Хивэг", "уут", 0, 35000);
        Product p2 = new Product("P002", "Овьёос", "уут",  0, 60000);
        Product p3 = new Product("P003", "Будаа (цагаан)", "уут",  0, 90000);
        warehouse.addProduct(p1);
        warehouse.addProduct(p2);
        warehouse.addProduct(p3); 
        // 3. ОРЛОГО ХҮЛЭЭН АВАХ
        System.out.println("--- ОРЛОГО ---");
        ReceiptVoucher receipt1 = new ReceiptVoucher(
                "RV-2026-001",
                LocalDate.of(2026, 1, 10),
                "Э.Хүслэн", 
                storekeeper
        );
        receipt1.addItem(new VoucherItem(p1, 200, 35000));
        receipt1.addItem(new VoucherItem(p2, 50, 60000));
        receipt1.addItem(new VoucherItem(p3, 100, 90000));
        storekeeper.receiveGoods(receipt1);
        // 4. ЗАРЛАГА ГАРГАХ
        System.out.println("--- ЗАРЛАГА ---");
        ExpenseVoucher expense1 = new ExpenseVoucher(
                "EV-2026-002",
                LocalDate.of(2026, 1, 15),
                "Б.Анударь",
                storekeeper
        );
        expense1.addItem(new VoucherItem(p1, 80, 35000));
        expense1.addItem(new VoucherItem(p3, 30, 90000));
        storekeeper.issueGoods(expense1);
        // 5. НӨӨЦИЙН ТАЙЛАН=
        System.out.println("--- НӨӨЦИЙН ТАЙЛАН ---");
        storekeeper.viewStockReport();
        // Зөвхөн хивэг болон будаа тайлан
        storekeeper.viewStockReport(List.of(p1, p3));
        // 6. НЯРАВЫН ТАЙЛАН
        System.out.println("--- НЯРАВЫН ТАЙЛАН ---");
        storekeeper.viewStorekeeperReport(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 1, 31)
        );
        // 7. ТООЛЛОГО ХИЙХ
        System.out.println("--- ТООЛЛОГО ---");
        // Цементийн бодит тоо 115 байна гэж үзье
        storekeeper.doInventory(p1, LocalDate.of(2026, 1, 20), 120);
        // Тооллогын дараах нөөцийн тайлан
        System.out.println("--- ТООЛЛОГЫН ДАРААХ НӨӨЦ ---");
        storekeeper.viewStockReport();
}
}
