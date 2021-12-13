package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public String newInvoice (String invoiceNr, String invoiceDate, Integer paymentDueIn,
                               String paymentDueDate, int companyProfileId, int clientId,
                               String invoiceComment, double delayPenalty, double totalNetSum,
                               double totalVatSum, double totalSum) {
        invoiceRepository.createInvoice(invoiceNr, invoiceDate, paymentDueIn, paymentDueDate, companyProfileId, clientId,
                invoiceComment, delayPenalty, totalNetSum, totalVatSum, totalSum);
        return "new invoice created";
    }

    public void newInvoiceRow (int id, String description, String unit, int vatId,
                                 double unitPrice, double quantity, double netSum, double vatAmount,
                                 double lineSum) {
        invoiceRepository.createInvoiceRow(id, description, unit, vatId, unitPrice, quantity,
                netSum, vatAmount, lineSum);
    }

    public List<InvoiceDTO> getAllInvoices(){
        return invoiceRepository.getAllInvoices();
    }

    public InvoiceDTO viewInvoice (String invoiceNr){
        return invoiceRepository.viewInvoice(invoiceNr);
    }




}
