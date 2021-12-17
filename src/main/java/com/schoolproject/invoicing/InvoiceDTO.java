package com.schoolproject.invoicing;

import java.util.List;

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

 private List<InvoiceRowDTO> itemRows;

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

 public List<InvoiceRowDTO> getItemRows() {
  return itemRows;
 }

 public void setItemRows(List<InvoiceRowDTO> itemRows) {
  this.itemRows = itemRows;
 }
}
