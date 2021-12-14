package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    @GetMapping("api/invoicing/getAll")
    public List<InvoiceDTO> getAllInvoices(){
        List<InvoiceDTO> list = invoiceService.getAllInvoices();
        return list;
    }

    @GetMapping("api/invoicing/view/{invoiceNr}")
    public InvoiceDTO viewInvoice(@PathVariable("invoiceNr") String invoiceNr){
        return invoiceService.viewInvoice(invoiceNr);
    }

    @DeleteMapping ("api/invoicing/deleteinvoice/{invoiceNr}")
    public InvoiceDTO deleteInvoice (@PathVariable("invoiceNr") String invoiceNr) {
        return invoiceService.deleteInvoice(invoiceNr);
    }

    @PostMapping ("api/invoicing/saveinvoice")
    public void saveInvoice (@RequestBody InvoiceDTO invoice) {
        invoiceService.saveInvoice(invoice);
    }

    @PostMapping ("api/invoicing/vat")
    public void createVat (@RequestBody InvoiceVatDTO vatDTO) {
        invoiceService.createVatType(vatDTO.getVatDesc(), vatDTO.getVatPercent());
    }

    @PostMapping("api/invoicing/changevat")
    public void changeVat(@RequestBody InvoiceVatDTO vatDTO) {
        invoiceService.changeVatType(vatDTO);
    }
}
