package com.billing.system;

import com.billing.system.repository.CSVCustomerRepository;
import com.billing.system.repository.CSVInvoiceRepository;
import com.billing.system.repository.CSVProductRepository;
import com.billing.system.service.InvoiceCalculator;
import com.billing.system.service.InvoiceService;
import com.billing.system.strategy.TextInvoiceExporter;
import com.billing.system.ui.MainFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Initialize dependencies
        CSVProductRepository productRepo = new CSVProductRepository();
        CSVCustomerRepository customerRepo = new CSVCustomerRepository();
        CSVInvoiceRepository invoiceRepo = new CSVInvoiceRepository();

        InvoiceCalculator calculator = new InvoiceCalculator();
        TextInvoiceExporter exporter = new TextInvoiceExporter();
        com.billing.system.strategy.PDFInvoiceExporter pdfExporter = new com.billing.system.strategy.PDFInvoiceExporter();

        InvoiceService invoiceService = new InvoiceService(invoiceRepo, productRepo, calculator, exporter, pdfExporter);

        // Launch GUI
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame(productRepo, customerRepo, invoiceRepo, invoiceService);
            frame.setVisible(true);
        });
    }
}
