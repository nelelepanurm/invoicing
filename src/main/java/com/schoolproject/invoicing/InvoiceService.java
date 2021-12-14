package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    public void newInvoiceRow(int invoiceId, String description, String unit, int vatId,
                              double unitPrice, double quantity, double netSum, double vatAmount,
                              double lineSum) {
        invoiceRepository.createInvoiceRow(invoiceId, description, unit, vatId, unitPrice, quantity,
                netSum, vatAmount, lineSum);
    }

    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.getAllInvoices();
    }

    public InvoiceDTO viewInvoice(String invoiceNr) {
        return invoiceRepository.viewInvoice(invoiceNr);
    }

    public InvoiceDTO deleteInvoice(String invoiceNr) {
        return invoiceRepository.deleteInvoice(invoiceNr);
    }

    public String changeInvoice(InvoiceDTO invoice) {
        invoiceRepository.changeInvoice(invoice);
        for (InvoiceRowDTO row : invoice.getInvoiceRows()) {
            invoiceRepository.changeInvoiceRow(row);
        }
        return "Invoice changed";
    }

    public void saveInvoice(InvoiceDTO invoiceDTO) {
        if (invoiceDTO.getId() == 0) {
            int id = invoiceRepository.createInvoice(invoiceDTO.getInvoiceNr(), invoiceDTO.getInvoiceDate(), invoiceDTO.getPaymentDueIn(),
                    invoiceDTO.getPaymentDueDate(), invoiceDTO.getCompanyProfileId(), invoiceDTO.getClientId(),
                    invoiceDTO.getInvoiceComment(), invoiceDTO.getDelayPenalty(), invoiceDTO.getTotalNetSum(),
                    invoiceDTO.getTotalVatSum(), invoiceDTO.getTotalSum());
            for (InvoiceRowDTO invoiceRow : invoiceDTO.getInvoiceRows()) {
                invoiceRepository.createInvoiceRow(id, invoiceRow.getDescription(), invoiceRow.getUnit(),
                        invoiceRow.getVatId(), invoiceRow.getUnitPrice(), invoiceRow.getQuantity(), invoiceRow.getNetSum(),
                        invoiceRow.getVatAmount(), invoiceRow.getLineSum());
            }
        } else {
            changeInvoice(invoiceDTO);
        }
    }

    public void createVatType (String vatDesc, double vatPercent) {
        invoiceRepository.createVatType(vatDesc, vatPercent);
    }
    public void changeVatType (InvoiceVatDTO vatDTO) {
        invoiceRepository.changeVatType(vatDTO);
    }
}
