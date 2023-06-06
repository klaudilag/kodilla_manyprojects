package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Test
    void testInvoiceDaoSave(){
        Product product1 = new Product("Frezarka");
        Product product2 = new Product("Biurko");
        Product product3 = new Product("Wiertarka");

        Item item = new Item(product1, new BigDecimal(10.0),1,new BigDecimal(10.0));
        Item item2 = new Item(product2, new BigDecimal(10.0),1,new BigDecimal(10.0));
        Item item3 = new Item(product3, new BigDecimal(10.0),1,new BigDecimal(10.0));

        List<Item> lista = new ArrayList<>();
        Invoice invoice = new Invoice("numerfaktury",lista);
        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        Assertions.assertNotEquals(0, invoiceId);

        invoiceDao.deleteById(invoiceId);


    }
}
