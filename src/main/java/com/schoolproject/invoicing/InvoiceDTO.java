package com.schoolproject.invoicing;

import java.util.List;

public class InvoiceDTO {
 private int id;
 private String invoiceNr;
 private String invoiceDate;
 private Integer paymentDueIn;
 private String paymentDueDate;
 private Integer companyProfileId;
 private Integer clientId;
 private String invoiceComment;
 private Double delayPenalty;
 private Double totalNetSum;
 private Double totalVatSum;
 private Double totalSum;

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

 public Integer getPaymentDueIn() {
  return paymentDueIn;
 }

 public void setPaymentDueIn(Integer paymentDueIn) {
  this.paymentDueIn = paymentDueIn;
 }

 public String getPaymentDueDate() {
  return paymentDueDate;
 }

 public void setPaymentDueDate(String paymentDueDate) {
  this.paymentDueDate = paymentDueDate;
 }

 public Integer getCompanyProfileId() {
  return companyProfileId;
 }

 public void setCompanyProfileId(Integer companyProfileId) {
  this.companyProfileId = companyProfileId;
 }

 public Integer getClientId() {
  return clientId;
 }

 public void setClientId(Integer clientId) {
  this.clientId = clientId;
 }

 public String getInvoiceComment() {
  return invoiceComment;
 }

 public void setInvoiceComment(String invoiceComment) {
  this.invoiceComment = invoiceComment;
 }

 public Double getDelayPenalty() {
  return delayPenalty;
 }

 public void setDelayPenalty(Double delayPenalty) {
  this.delayPenalty = delayPenalty;
 }

 public Double getTotalNetSum() {
  return totalNetSum;
 }

 public void setTotalNetSum(Double totalNetSum) {
  this.totalNetSum = totalNetSum;
 }

 public Double getTotalVatSum() {
  return totalVatSum;
 }

 public void setTotalVatSum(Double totalVatSum) {
  this.totalVatSum = totalVatSum;
 }

 public Double getTotalSum() {
  return totalSum;
 }

 public void setTotalSum(Double totalSum) {
  this.totalSum = totalSum;
 }

 public List<InvoiceRowDTO> getItemRows() {
  return itemRows;
 }

 public void setItemRows(List<InvoiceRowDTO> itemRows) {
  this.itemRows = itemRows;
 }
}
