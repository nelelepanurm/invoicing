package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("api/invoicing/newinvoice")
    public String newInvoice (@RequestBody InvoiceDTO invoice) {
        return invoiceService.newInvoice(invoice.getInvoiceNr(), invoice.getInvoiceDate(), invoice.getPaymentDueIn(),
                invoice.getPaymentDueDate(), invoice.getCompanyProfileId(), invoice.getClientId(),
                invoice.getInvoiceComment(), invoice.getDelayPenalty(), invoice.getTotalNetSum(),
                invoice.getTotalVatSum(), invoice.getTotalSum());
    }

    @PostMapping("api/invoicing/addrow")
    public void newInvoiceRow (@RequestBody InvoiceDTO row) {
        invoiceService.newInvoiceRow(row.getId(), row.getDescription(), row.getUnit(), row.getVatId(), row.getUnitPrice(),
                row.getQuantity(), row.getNetSum(), row.getVatAmount(), row.getLineSum());
    }

    @GetMapping("api/invoicing/getAll")
    public List<InvoiceDTO> getAllInvoices(){
        List<InvoiceDTO> list = invoiceService.getAllInvoices();
        return list;
    }

    @GetMapping("api/invoicing/view/{invoiceNr}")
    public InvoiceDTO viewInvoice(@PathVariable("invoiceNr") String invoiceNr){
        return invoiceService.viewInvoice(invoiceNr);

    }
}
