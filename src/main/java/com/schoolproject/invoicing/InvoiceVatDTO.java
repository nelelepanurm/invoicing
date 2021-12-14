package com.schoolproject.invoicing;

public class InvoiceVatDTO {
    private int id;
    private String vatDesc;
    private double vatPercent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVatDesc() {
        return vatDesc;
    }

    public void setVatDesc(String vatDesc) {
        this.vatDesc = vatDesc;
    }

    public double getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(double vatPercent) {
        this.vatPercent = vatPercent;
    }
}
