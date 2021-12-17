package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    @GetMapping("api/invoicing")
    public List<InvoiceDTO> getAllInvoices(){
       return invoiceService.getAllInvoices();
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

    @GetMapping("api/vatlist")
    public List<InvoiceVatDTO> getVatList (){
        return invoiceService.getVatList();
    }
    @GetMapping("api/getvat/{id}")
    public InvoiceVatDTO getVatById(@PathVariable("id") Integer id) {
        return invoiceService.getVatById(id);
    }
}
