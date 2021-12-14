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
public class CompanyProfileRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Integer registerCompany(String userName, String password, String eMail, String phoneNr, String address, String postalCode, String country, String regNr, String vatCode, String bankName1, String iban1, String swift1, String bankName2, String iban2, String swift2, String bankName3, String iban3,String swift3, String emailText, String paymentDeadline, int delayPenalty, String unit, String logoFail, String companyName ) {
        String sql = "INSERT INTO client (user_name,password,e_mail,phone_nr,address,postal_code,country,registration_code,vat_code, bank_name1,iban1,swift1,bank_name2,iban2,swift2,bank_name3,iban3,swift3,email_text,payment_deadline,delay_penalty,unit,logo_fail,company_name) VALUES (:userName, :password, :eMail, :phoneNr, :address, :postalCode, :country, :regNr, :vatCode, :bankName1, :iban1, :swift1, :bankName2, :iban2, :swift2, :bankName3, :iban3,:swift3, :emailText, :paymentDeadline, :delayPenalty, :unit, :logoFail, :companyName )";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        paramMap.put("password", password);
        paramMap.put("eMail", eMail);
        paramMap.put("phoneNr", phoneNr);
        paramMap.put("address", address);
        paramMap.put("postalCode", postalCode);
        paramMap.put("country", country);
        paramMap.put("regNr", regNr);
        paramMap.put("vatCode", vatCode);
        paramMap.put("bankName1", bankName1);
        paramMap.put("iban1",iban1);
        paramMap.put("swift1", swift1);
        paramMap.put("bankName2", bankName2);
        paramMap.put("iban2",iban2);
        paramMap.put("swift2", swift2);
        paramMap.put("bankName3", bankName3);
        paramMap.put("iban3",iban3);
        paramMap.put("swift3", swift3);
        paramMap.put("emailText",emailText);
        paramMap.put("paymentDeadline", paymentDeadline);
        paramMap.put("delayPenalty",delayPenalty);
        paramMap.put("unit", unit);
        paramMap.put("logoFail", logoFail);
        paramMap.put("companyName",companyName);


        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("id");

    }
}
