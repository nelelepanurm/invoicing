package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ClientRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Integer createClient(String clientName,String address,String contactPerson, String country,String eMail,String phoneNr,String postCode,String regNr,String vatNr) {
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

    }

