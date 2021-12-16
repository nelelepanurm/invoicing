package com.schoolproject.invoicing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Repository
public class ClientRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Integer createClient(String clientName, String address, String contactPerson, String country, String eMail, String phoneNr, String postCode, String regNr, String vatNr) {
        String sql = "INSERT INTO client (client_name,address,contact_person,country,e_mail,phone_nr,postal_code,reg_nr,vat_nr) VALUES (:clientName,:address,:contactPerson,:country,:eMail,:phoneNr,:postCode,:regNr,:vatNr)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clientName", clientName);
        paramMap.put("address", address);
        paramMap.put("contactPerson", contactPerson);
        paramMap.put("country", country);
        paramMap.put("eMail", eMail);
        paramMap.put("phoneNr", phoneNr);
        paramMap.put("postCode", postCode);
        paramMap.put("regNr", regNr);
        paramMap.put("vatNr", vatNr);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("id");

    }

    public int deleteClient(int id) {
        String sql = "DELETE FROM client WHERE id=:id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbcTemplate.update(sql, paramMap);
    }

    public int changeClient(Integer id, @RequestBody ClientDto client) {
        String sql = "UPDATE client SET client_name = :clientName, reg_nr = :regNr, vat_nr = :vatNr, address = :address, postal_code = :postCode,country = :country,e_mail = :eMail, phone_nr = :phoneNr, contact_person = :contactPerson WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("clientName", client.getClientName());
        paramMap.put("regNr", client.getRegNr());
        paramMap.put("vatNr", client.getVatNr());
        paramMap.put("address", client.getAddress());
        paramMap.put("postCode", client.getPostCode());
        paramMap.put("country", client.getCountry());
        paramMap.put("eMail", client.geteMail());
        paramMap.put("phoneNr", client.getPhoneNr());
        paramMap.put("contactPerson", client.getContactPerson());
        return jdbcTemplate.update(sql, paramMap);
    }

    public ClientDto getClient(String clientName) {
        String sql = "SELECT * FROM client WHERE client_name = :clientName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clientName", clientName);
        ClientDto result = jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(ClientDto.class));
        return result;
    }

    public List<ClientDto> getClientList(String search) {
        String sql = "SELECT * FROM client";
        Map<String, Object> paramMap = new HashMap<>();
        if (search != null && !search.isBlank()) {
            search = search.toLowerCase(Locale.ROOT);
            sql += " WHERE LOWER(client_name) LIKE :search OR LOWER(reg_nr) LIKE :search";
            paramMap.put("search", search + "%");
        }

        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(ClientDto.class));


    }



    public ClientDto getClientId(Integer id) {
        String sql = "SELECT * FROM client WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        ClientDto result = jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(ClientDto.class));
        return result;
    }
}

