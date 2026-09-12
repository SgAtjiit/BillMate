<div align="center">

  # 💳 BillMate

  ### **Offline Billing & Inventory Management System**

  *A sleek, robust, and standalone desktop application for managing products, customers, invoices, and analytics—completely offline with instant PDF generation.*

  <br />

  <!-- Tech Stack Badges -->
  ![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
  ![UI Framework](https://img.shields.io/badge/UI-Java%20Swing-007396?style=for-the-badge&logo=java&logoColor=white)
  ![Database](https://img.shields.io/badge/Database-SQLite%203-003B57?style=for-the-badge&logo=sqlite&logoColor=white)
  ![PDF Generator](https://img.shields.io/badge/PDF-iText%205-EC1C24?style=for-the-badge&logo=adobeacrobatreader&logoColor=white)
  ![Architecture](https://img.shields.io/badge/Architecture-Clean%20%26%20Modular-6f42c1?style=for-the-badge)
  ![Offline Status](https://img.shields.io/badge/Offline-100%25%20Standalone-28a745?style=for-the-badge)

</div>

---

## 📌 Overview

**BillMate** is a high-performance offline desktop billing solution built for retail businesses, store managers, and small enterprises. Designed with a **high-contrast dark UI**, it provides seamless inventory tracking, customer record management, dynamic invoice creation, real-time strategy-based tax & discount calculation, and one-click PDF bill generation—without requiring an internet connection.

---

## ✨ Key Features

### 📦 Inventory & Product Management
- **Catalog Management:** Add, update, view, and delete products easily.
- **Stock Tracking:** Maintain real-time quantity monitoring and pricing details.
- **Fast Search & Filter:** Quickly locate items during customer checkout.

### 👤 Customer Relationship Management
- **Client Records:** Maintain a clean registry of customer details, phone numbers, and emails.
- **Order History:** Associate invoices directly with registered customers.

### 🧾 Smart Invoice Generation
- **Interactive POS Interface:** Select products, specify quantities, and build invoices dynamically.
- **Flexible Discounts:** Apply percentage-based, bulk item, or "Buy X Get Y" promotional discounts.
- **Tax Rules:** Support for flat rate taxes and multi-tier GST rules.
- **Live Calculation:** Instant total, subtotal, tax, and net payable estimations.

### 📄 Export & Digital Receipting
- **Instant PDF Export:** Automatically generates styled PDF invoices saved to `generated_invoices/`.
- **Text Invoice Support:** Plain-text receipt export for receipt printers.
- **History Archive:** Review, search, and re-export past invoices anytime.

### 📊 Analytics & Reporting
- **Business Insights:** Dedicated tab tracking overall sales metrics, revenue, and product performance.

### 🔌 100% Offline & Portable
- **Zero Internet Dependency:** Runs entirely locally using an embedded SQLite database (`data/billing.db`).
- **CSV Data Migration:** Automatic backward-compatibility migration from legacy CSV files on initial startup.

---

## 🛠️ Tech Stack & Dependencies

| Layer | Technology | Purpose |
| :--- | :--- | :--- |
| **Language** | Java 8+ | Core application logic and execution runtime |
| **UI Framework** | Java Swing / AWT | Desktop GUI with custom Dark Theme styling |
| **Database** | SQLite 3 (`sqlite-jdbc-3.46.0.0.jar`) | Embedded zero-configuration local database |
| **PDF Generation** | iText 5 (`itextpdf-5.5.13.3.jar`) | Direct PDF document rendering and export |
| **Logging** | SLF4J (`slf4j-api` & `slf4j-simple`) | Clean runtime diagnostics logging |

---

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK) 8** or higher installed and set in environment `PATH`.
- All required dependency JARs are pre-bundled inside the [`lib/`](file:///e:/resume%20Projects/java/BillMate/lib) directory.

### Quick Start (Windows)

Simply double-click or run [`run.bat`](file:///e:/resume%20Projects/java/BillMate/run.bat) from the project root:

```cmd
run.bat
```

### Manual Compilation & Execution

If compiling manually via command prompt or terminal:

1. **Compile all Java source files:**
   ```cmd
   javac -cp "lib/*;src" -d bin src\com\billing\system\**\*.java
   ```

2. **Launch BillMate:**
   ```cmd
   java -cp "bin;lib/*" com.billing.system.Main
   ```

---

## 📂 Project Structure

```
BillMate/
├── bin/                          # Compiled Java class files
├── data/                         # SQLite database storage (billing.db)
├── generated_invoices/           # Output directory for exported PDF invoices
├── lib/                          # External JAR dependencies
│   ├── itextpdf-5.5.13.3.jar     # PDF generation engine
│   ├── sqlite-jdbc-3.46.0.0.jar  # SQLite JDBC driver
│   ├── slf4j-api-1.7.36.jar      # Logging API
│   └── slf4j-simple-1.7.36.jar   # Simple logging provider
├── src/                          # Application source code
│   └── com/billing/system/
│       ├── model/                # Data Transfer Objects (Product, Customer, Invoice)
│       ├── repository/           # Persistence abstraction layer (SQLite & In-Memory)
│       ├── service/              # Core business rules & invoice calculators
│       ├── strategy/             # Discount, Tax & Export design pattern strategies
│       ├── ui/                   # Swing UI components & dark theme helpers
│       └── Main.java             # System entry point & bootstrap logic
├── readme.md                     # Project documentation
└── run.bat                       # One-click Windows compile & run script
```

---

## 🧩 Architecture & Design Patterns

BillMate is engineered using proven software design principles:

- **Repository Pattern:** Decouples data access from business logic. Supports seamless swapping between SQLite database repositories and in-memory test repositories.
- **Strategy Pattern:**
  - `DiscountStrategy`: Enables pluggable discount logic (Percentage, Flat, Bulk, Buy-X-Get-Y).
  - `TaxStrategy`: Enables pluggable tax logic (Flat Rate, GST, Exemption).
  - `InvoiceExporter`: Strategy interface for PDF (`PDFInvoiceExporter`) and Text (`TextInvoiceExporter`) generation.
- **Clean Architecture & Separation of Concerns:** Strict isolation between UI panels (`com.billing.system.ui`), logic services (`service`), and persistent models (`model`).

---

## 🎨 Theme & UI Customization

- **Dark Mode Styling:** Maintained in [`UIHelper.java`](file:///e:/resume%20Projects/java/BillMate/src/com/billing/system/ui/UIHelper.java). Palette colors, fonts, tabbed panes, and button borders can be updated globally from one place.
- **Extending Strategies:** To add a custom tax rule or discount offer, implement `TaxStrategy` or `DiscountStrategy` interface under `com.billing.system.strategy` and register it inside [`InvoicePanel.java`](file:///e:/resume%20Projects/java/BillMate/src/com/billing/system/ui/InvoicePanel.java).

---

<div align="center">
  <sub>Built with ❤️ for reliable, offline retail management. Powered by Java & SQLite.</sub>
</div>
