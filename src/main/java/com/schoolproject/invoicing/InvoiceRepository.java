package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InvoiceRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    private class InvoiceRowMapper implements RowMapper<InvoiceDTO> {
        @Override
        public InvoiceDTO mapRow(ResultSet resultSet, int i) throws SQLException {
            InvoiceDTO result = new InvoiceDTO();
            result.setId(resultSet.getInt("id"));
            result.setInvoiceNr(resultSet.getString("invoiceNr"));
            result.setInvoiceDate(resultSet.getString("invoiceDate"));
            result.setPaymentDueIn(resultSet.getInt("paymentDueIn"));
            result.setPaymentDueDate(resultSet.getString("paymentDueDate"));
            result.setCompanyProfileId(resultSet.getInt("companyProfileId"));
            result.setClientId(resultSet.getInt("clientId"));
            result.setInvoiceComment(resultSet.getString("invoiceComment"));
            result.setDelayPenalty(resultSet.getDouble("delayPenalty"));
            result.setTotalNetSum(resultSet.getDouble("totalNetSum"));
            result.setTotalVatSum(resultSet.getDouble("totalVatSum"));
            result.setTotalSum(resultSet.getDouble("totalSum"));
            return result;
        }
    }

    private class InvoiceLineRowMapper implements RowMapper<InvoiceRowDTO> {
        @Override
        public InvoiceRowDTO mapRow(ResultSet resultSet, int i) throws SQLException {
            InvoiceRowDTO result = new InvoiceRowDTO();
            result.setId(resultSet.getInt("id"));
            result.setInvoiceId(resultSet.getInt("invoiceId"));
            result.setDescription(resultSet.getString("description"));
            result.setUnit(resultSet.getString("unit"));
            result.setVatId(resultSet.getInt("vatId"));
            result.setUnitPrice(resultSet.getDouble("unitPrice"));
            result.setQuantity(resultSet.getDouble("quantity"));
            result.setNetSum(resultSet.getDouble("netSum"));
            result.setVatAmount(resultSet.getDouble("vatAmount"));
            result.setLineSum(resultSet.getDouble("lineSum"));
            return result;
        }
    }


    public Integer createInvoice(String invoiceNr, String invoiceDate, Integer paymentDueIn,
                                 String paymentDueDate, int companyProfileId, int clientId,
                                 String invoiceComment, double delayPenalty, double totalNetSum,
                                 double totalVatSum, double totalSum) {
        String sql = "INSERT INTO invoice (invoice_number, invoice_date, payment_due_in, payment_due_date, " +
                "company_profile_id, client_id, invoice_comment, delay_penalty, total_net_sum, total_vat_sum, total_sum) " +
                "VALUES ( :invoiceNr, :invoiceDate, :paymentDueIn, :paymentDueDate," +
                " :companyProfileId, :clientId, :invoiceComment, :delayPenalty, :totalNetSum, :totalVatSum, :totalSum)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("invoiceNr", invoiceNr);
        paramMap.put("invoiceDate", invoiceDate);
        paramMap.put("paymentDueIn", paymentDueIn);
        paramMap.put("paymentDueDate", paymentDueDate);
        paramMap.put("companyProfileId", companyProfileId);
        paramMap.put("clientId", clientId);
        paramMap.put("invoiceComment", invoiceComment);
        paramMap.put("delayPenalty", delayPenalty);
        paramMap.put("totalNetSum", totalNetSum);
        paramMap.put("totalVatSum", totalVatSum);
        paramMap.put("totalSum", totalSum);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void createInvoiceRow(int invoiceId, String description, String unit, int vatId,
                                 double unitPrice, double quantity, double netSum, double vatAmount,
                                 double lineSum) {
        String sql = "INSERT INTO invoice_row (invoice_id, description, unit, vat_id, unit_price, quantity, net_sum, vat_amount, line_sum) " +
                "VALUES ( :invoiceId, :description, :unit, :vatId, :unitPrice, :quantity, :netSum, :vatAmount, :lineSum)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("invoiceId", invoiceId);
        paramMap.put("description", description);
        paramMap.put("unit", unit);
        paramMap.put("vatId", vatId);
        paramMap.put("unitPrice", unitPrice);
        paramMap.put("quantity", quantity);
        paramMap.put("netSum", netSum);
        paramMap.put("vatAmount", vatAmount);
        paramMap.put("lineSum", lineSum);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<InvoiceDTO> getAllInvoices() {
        String sql = "SELECT * FROM invoice WHERE invoice_number = :invoiceNr)";
        Map<String, Object> paramMap = new HashMap<>();
        List<InvoiceDTO> invoicesList = jdbcTemplate.query(sql, paramMap, new InvoiceRowMapper());
        return invoicesList;
    }

    public InvoiceDTO viewInvoice(String invoiceNr) {
        String sql = "SELECT * FROM invoice WHERE invoice_number = :invoiceNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("invoiceNr", invoiceNr);
        List<InvoiceDTO> result = jdbcTemplate.query(sql, paramMap, new InvoiceRowMapper());
        InvoiceDTO invoiceDTO = result.get(0);
        invoiceDTO.setInvoiceRows(collectRows(invoiceDTO.getId()));
        return invoiceDTO;
    }

    public List<InvoiceRowDTO> collectRows(Integer id) {
        String sql2 = "SELECT * FROM invoice_row WHERE invoice_id = :invoiceId";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("invoiceId", id);
        List<InvoiceRowDTO> rowResult = jdbcTemplate.query(sql2, paramMap2, new InvoiceLineRowMapper());
        return rowResult;
    }

    public InvoiceDTO deleteInvoice(String invoiceNr) {
        String sql = "DELETE FROM invoice WHERE invoice_number = :invoiceNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("invoiceNr", invoiceNr);
        jdbcTemplate.update(sql, paramMap);
        return null;
    }

    public void changeInvoice(InvoiceDTO invoice) {
        String sql = "UPDATE invoice SET invoice_number = :invoiceNr, invoice_date = :invoiceDate, " +
                " payment_due_in = :paymentDueIn, payment_due_date = :paymentDueDate, " +
                " company_profile_id = :companyProfileId, client_id = :clientId, invoice_comment = :invoiceComment, " +
                " delay_penalty = :delayPenalty, total_net_sum = :totalNetSum, total_vat_sum = :totalVatSum, " +
                " total_sum = :totalSum";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("invoiceNr", invoice.getInvoiceNr());
        paramMap.put("invoiceDate", invoice.getInvoiceDate());
        paramMap.put("paymentDueIn", invoice.getPaymentDueIn());
        paramMap.put("paymentDueDate", invoice.getPaymentDueDate());
        paramMap.put("companyProfileId", invoice.getCompanyProfileId());
        paramMap.put("clientId", invoice.getClientId());
        paramMap.put("invoiceComment", invoice.getInvoiceComment());
        paramMap.put("delayPenalty", invoice.getDelayPenalty());
        paramMap.put("totalNetSum", invoice.getTotalNetSum());
        paramMap.put("totalVatSum", invoice.getTotalVatSum());
        paramMap.put("totalSum", invoice.getTotalSum());
        jdbcTemplate.update(sql, paramMap);
    }

    public void changeInvoiceRow(InvoiceRowDTO row) {
        String sql = "UPDATE invoice_row SET invoice_id = :invoiceId, descritpion = :description, " +
                " unit = :unit, vat_id = :vatId, " +
                " unit_price = :unitPrice, quantity = :quantity, net_sum = :netSum, " +
                " vat_amount = :vatAmount, line_sum = :lineSum";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("invoiceId", row.getInvoiceId());
        paramMap.put("description", row.getDescription());
        paramMap.put("unit", row.getUnit());
        paramMap.put("vatId", row.getVatId());
        paramMap.put("unitPrice", row.getUnitPrice());
        paramMap.put("quantity", row.getQuantity());
        paramMap.put("netSum", row.getNetSum());
        paramMap.put("vatAmount", row.getVatAmount());
        paramMap.put("lineSum", row.getLineSum());
        jdbcTemplate.update(sql, paramMap);
    }

    public void createVatType(String vatDesc, double vatPercent) {

        String sql = "INSERT INTO vat_type (vat_desc, vat_percent) VALUES ( :vatDesc, :vatPercent)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vatDesc", vatDesc);
        paramMap.put("vatPercent", vatPercent);
        jdbcTemplate.update(sql, paramMap);
    }

    public void changeVatType (InvoiceVatDTO vatDTO) {
        String sql = "UPDATE vat_type SET vat_desc = :vatDesc, vat_percent = :vatPercent";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vatDesc", vatDTO.getVatDesc());
        paramMap.put("vatPercent", vatDTO.getVatPercent());
        jdbcTemplate.update(sql, paramMap);
    }
    public List<InvoiceVatDTO> getVatList() {
        String sql = "SELECT * FROM vat_type";
        Map<String, Object> paramMap = new HashMap<>();
        List<InvoiceVatDTO> vatList = jdbcTemplate.query(sql,paramMap, new BeanPropertyRowMapper<>(InvoiceVatDTO.class));
        return vatList;
    }
}

