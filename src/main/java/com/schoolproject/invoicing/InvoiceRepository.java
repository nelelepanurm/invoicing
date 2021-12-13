package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
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

    private class AccountRowMapper implements RowMapper<InvoiceDTO> {
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
            result.setDescription(resultSet.getString("description"));
            result.setUnit(resultSet.getString("unit"));
            result.setVatId(resultSet.getInt("vatId"));
            result.setUnitPrice(resultSet.getDouble("unitPrice"));
            result.setQuantity(resultSet.getDouble("quantity"));
            result.setNetSum(resultSet.getDouble("netSum"));
            result.setVatAmount(resultSet.getDouble("vatAmount"));
            result.setLineSum(resultSet.getDouble("lineSum"));
            result.setInvoiceRowId(resultSet.getInt("invoiceRowId"));
            result.setVatPercent(resultSet.getDouble("vatPercent"));
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

    public Integer createInvoiceRow(int id, String description, String unit, int vatId,
                                    double unitPrice, double quantity, double netSum, double vatAmount,
                                    double lineSum) {
        String sql = "INSERT INTO invoice_row (invoice_id, description, unit, vat_id, unit_price, quantity, net_sum, vat_amount, line_sum) " +
                "VALUES ( :id, :description, :unit, :vatId, :unitPrice, :quantity, :netSum, :vatAmount, :lineSum)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("description", description);
        paramMap.put("unit", unit);
        paramMap.put("vatId", vatId);
        paramMap.put("unitPrice", unitPrice);
        paramMap.put("quantity", quantity);
        paramMap.put("netSum", netSum);
        paramMap.put("vatAmount", vatAmount);
        paramMap.put("lineSum", lineSum);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("invoiceRowId");
    }

    public List<InvoiceDTO> getAllInvoices() {
        String sql = "SELECT * FROM invoice WHERE invoice_number = :invoiceNr)";
        Map<String, Object> paramMap = new HashMap<>();
        List<InvoiceDTO> invoicesList = jdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return invoicesList;
    }

    public InvoiceDTO viewInvoice (String invoiceNr) {
        String sql = "SELECT * FROM invoice WHERE invoice_number = :invoiceNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("invoiceNr", invoiceNr);
        List<InvoiceDTO> result = jdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        InvoiceDTO invoiceDTO = result.get(0);
        return invoiceDTO;
    }


}
