<<<<<<< HEAD
# CSM202-lab-8
=======
<p align="center">
  <img src="https://www.must.edu.mn/media/uploads/2022/08/10/image-20220810124218-2.png" alt="SICT Logo" width="150"/>
</p>

<h1 align="center">ШИНЖЛЭХ УХААН, ТЕХНОЛОГИЙН ИХ СУРГУУЛЬ</h1>
<h2 align="center">МЭДЭЭЛЭЛ, ХОЛБООНЫ ТЕХНОЛОГИЙН СУРГУУЛЬ</h2>

---

## ЛАБОРАТОРИЙН АЖЛЫН ТАЙЛАН 8

---

**Хичээл:** F.CSM202 Объект хандалтат программчлал  
**Хичээлийн жил:** 2025-2026 оны хавар  

**Хичээл заасан багш:** А.Отгонбаяр /F.SW02/  
**Лабораторийн ажил гүйцэтгэсэн:** Оюутан -Г.Ууганбаяр /B242290002/ Б.Анударь /B242290020/ Б.Булганчимэг /B242290006/ Э.Хүслэн /B242290022/

<p align="center">
 Улаанбаатар хот  
</p>
---

### Лабораторийн ажлын үр дүн:
# Lab08 - Агуулахын систем (Warehouse System)
## OOP Java Implementation

---

##  Файлын бүтэц

```
WarehouseSystem/
└── src/
    └── warehouse/
        ├── Product.java          → Бараа
        ├── VoucherItem.java      → Падааны мөр
        ├── ReceiptVoucher.java   → Орлогын падаан
        ├── ExpenseVoucher.java   → Зарлагын падаан
        ├── InventoryRecord.java  → Тооллогын бүртгэл
        ├── Storekeeper.java      → Нярав
        ├── Warehouse.java        → Агуулах
        └── Main.java             → Туршилтын програм
```

---

## 🧩 CRC Карт (Class-Responsibility-Collaborator)

| Класс             | Хариуцлага                                              | Хамтрагч                           |
|-------------------|--------------------------------------------------------|-------------------------------------|
| `Warehouse`       | Агуулахын мэдээлэл, бараа, падаан, тайлан хадгалах    | Product, Storekeeper, Vouchers      |
| `Storekeeper`     | Орлого, зарлага, тайлан, тооллого хийх                 | Warehouse, ReceiptVoucher, ExpenseVoucher |
| `Product`         | Барааны мэдээлэл, үлдэгдэл хянах                       | -                                   |
| `ReceiptVoucher`  | Орлогын падааны баримт хадгалах                         | VoucherItem, Storekeeper            |
| `ExpenseVoucher`  | Зарлагын падааны баримт хадгалах                        | VoucherItem, Storekeeper            |
| `VoucherItem`     | Нэг барааны орлого/зарлагын мөр                        | Product                             |
| `InventoryRecord` | Тооллогын үр дүн хадгалах                              | Product                             |

---

### Нэр үг (Классууд):
- Агуулах → `Warehouse`
- Нярав → `Storekeeper`
- Бараа → `Product`
- Орлогын падаан → `ReceiptVoucher`
- Зарлагын падаан → `ExpenseVoucher`
- Падааны мөр → `VoucherItem`
- Тооллогын бүртгэл → `InventoryRecord`

### Үйл үг (Методууд):
- Орлого хүлээн авах → `receiveGoods()`
- Зарлагаар гаргах → `issueGoods()`
- Нөөцийн тайлан харах → `viewStockReport()`
- Няравын тайлан харах → `viewStorekeeperReport()`
- Тооллого хийх → `doInventory()`
- Барааны тоо нэмэх → `addQuantity()`
- Барааны тоо хасах → `subtractQuantity()`
- Тайлан хэвлэх → `print()`
>>>>>>> f283e6d (lab 8-g hiiv)
