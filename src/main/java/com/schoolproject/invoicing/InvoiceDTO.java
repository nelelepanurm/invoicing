package com.schoolproject.invoicing;

public class InvoiceDTO {
 private int id;
 private String invoiceNr;
 private String invoiceDate;
 private int paymentDueIn;
 private String paymentDueDate;
 private int companyProfileId;
 private int clientId;
 private String invoiceComment;
 private double delayPenalty;
 private double totalNetSum;
 private double totalVatSum;
 private double totalSum;
 private String description;
 private String unit;
 private int vatId;
 private double unitPrice;
 private double quantity;
 private double netSum;
 private double vatAmount;
 private double lineSum;
 private int invoiceRowId;
 private double vatPercent;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getInvoiceNr() {
  return invoiceNr;
 }

 public void setInvoiceNr(String invoiceNr) {
  this.invoiceNr = invoiceNr;
 }

 public String getInvoiceDate() {
  return invoiceDate;
 }

 public void setInvoiceDate(String invoiceDate) {
  this.invoiceDate = invoiceDate;
 }

 public int getPaymentDueIn() {
  return paymentDueIn;
 }

 public void setPaymentDueIn(int paymentDueIn) {
  this.paymentDueIn = paymentDueIn;
 }

 public String getPaymentDueDate() {
  return paymentDueDate;
 }

 public void setPaymentDueDate(String paymentDueDate) {
  this.paymentDueDate = paymentDueDate;
 }

 public int getCompanyProfileId() {
  return companyProfileId;
 }

 public void setCompanyProfileId(int companyProfileId) {
  this.companyProfileId = companyProfileId;
 }

 public int getClientId() {
  return clientId;
 }

 public void setClientId(int clientId) {
  this.clientId = clientId;
 }

 public String getInvoiceComment() {
  return invoiceComment;
 }

 public void setInvoiceComment(String invoiceComment) {
  this.invoiceComment = invoiceComment;
 }

 public double getDelayPenalty() {
  return delayPenalty;
 }

 public void setDelayPenalty(double delayPenalty) {
  this.delayPenalty = delayPenalty;
 }

 public double getTotalNetSum() {
  return totalNetSum;
 }

 public void setTotalNetSum(double totalNetSum) {
  this.totalNetSum = totalNetSum;
 }

 public double getTotalVatSum() {
  return totalVatSum;
 }

 public void setTotalVatSum(double totalVatSum) {
  this.totalVatSum = totalVatSum;
 }

 public double getTotalSum() {
  return totalSum;
 }

 public void setTotalSum(double totalSum) {
  this.totalSum = totalSum;
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

 public int getInvoiceRowId() {
  return invoiceRowId;
 }

 public void setInvoiceRowId(int invoiceRowId) {
  this.invoiceRowId = invoiceRowId;
 }

 public double getVatPercent() {
  return vatPercent;
 }

 public void setVatPercent(double vatPercent) {
  this.vatPercent = vatPercent;
 }

}
