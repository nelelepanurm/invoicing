package com.schoolproject.invoicing;

import java.util.List;

public class InvoiceRowDTO {
    private int id;
    private int invoiceId;
    private String description;
    private String unit;
    private int vatId;
    private double unitPrice;
    private double quantity;
    private double netSum;
    private double vatAmount;
    private double lineSum;
    private List<InvoiceVatDTO> vatPercent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getVatId() {
        return vatId;
    }

    public void setVatId(int vatId) {
        this.vatId = vatId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getNetSum() {
        return netSum;
    }

    public void setNetSum(double netSum) {
        this.netSum = netSum;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public double getLineSum() {
        return lineSum;
    }

    public void setLineSum(double lineSum) {
        this.lineSum = lineSum;
    }

    public List<InvoiceVatDTO> getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(List<InvoiceVatDTO> vatPercent) {
        this.vatPercent = vatPercent;
    }
}
