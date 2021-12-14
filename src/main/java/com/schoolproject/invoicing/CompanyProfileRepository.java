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
import java.util.Map;

@Repository
public class CompanyProfileRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Integer registerCompany(String userName, String password, String eMail, String phoneNr, String address, String postalCode, String country, String regNr, String vatCode, String bankName1, String iban1, String swift1, String bankName2, String iban2, String swift2, String bankName3, String iban3,String swift3, String emailText, String paymentDeadline, int delayPenalty, String unit, String logoFail, String companyName ) {
        String sql = "INSERT INTO company_profile (user_name,password,e_mail,phone_nr,address,postal_code,country,registration_code,vat_code, bank_name1,iban1,swift1,bank_name2,iban2,swift2,bank_name3,iban3,swift3,email_text,payment_deadline,delay_penalty,unit,logo_fail,company_name) VALUES (:userName, :password, :eMail, :phoneNr, :address, :postalCode, :country, :regNr, :vatCode, :bankName1, :iban1, :swift1, :bankName2, :iban2, :swift2, :bankName3, :iban3,:swift3, :emailText, :paymentDeadline, :delayPenalty, :unit, :logoFail, :companyName )";
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

    public int changeCompany(Integer id, @RequestBody CompanyProfileDTO companyProfile) {
        String sql = "UPDATE company_profile SET user_name = :userName,password = :password,e_mail = :eMail,phone_nr = :phoneNr,address = :address,postal_code = :postalCode,country = :country,registration_code = :regNr,vat_code = :vatCode, bank_name1 = :bankName1,iban1 = :iban1,swift1 = :swift1,bank_name2 = :bankName2,iban2 = :iban2,swift2 = :swift2,bank_name3 = :bankName3,iban3 = :iban3,swift3 = :swift3,email_text = :emailText,payment_deadline = :paymentDeadline,delay_penalty = :delayPenalty,unit = :unit,logo_fail= :logoFail,company_name = :companyName WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("userName", companyProfile.getUserName());
        paramMap.put("password", companyProfile.getPassword());
        paramMap.put("eMail", companyProfile.geteMail());
        paramMap.put("phoneNr", companyProfile.getPhoneNr());
        paramMap.put("address", companyProfile.getAddress());
        paramMap.put("postalCode", companyProfile.getPostalCode());
        paramMap.put("country", companyProfile.getCountry());
        paramMap.put("regNr", companyProfile.getRegNr());
        paramMap.put("vatCode", companyProfile.getVatCode());
        paramMap.put("bankName1", companyProfile.getBankName1());
        paramMap.put("iban1",companyProfile.getIban1());
        paramMap.put("swift1", companyProfile.getSwift1());
        paramMap.put("bankName2", companyProfile.getBankName2());
        paramMap.put("iban2",companyProfile.getIban2());
        paramMap.put("swift2", companyProfile.getSwift2());
        paramMap.put("bankName3", companyProfile.getBankName3());
        paramMap.put("iban3",companyProfile.getIban3());
        paramMap.put("swift3", companyProfile.getSwift3());
        paramMap.put("emailText",companyProfile.getEmailText());
        paramMap.put("paymentDeadline", companyProfile.getPaymentDeadline());
        paramMap.put("delayPenalty",companyProfile.getDelayPenalty());
        paramMap.put("unit", companyProfile.getUnit());
        paramMap.put("logoFail", companyProfile.getLogoFail());
        paramMap.put("companyName",companyProfile.getCompanyName());
        return jdbcTemplate.update(sql, paramMap);
    }
    public CompanyProfileDTO getCompany(String userName) {
        String sql = "SELECT * FROM company_profile WHERE user_name = :userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        CompanyProfileDTO result = jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(CompanyProfileDTO.class));
        return result;
    }

    public CompanyProfileDTO findCompany (Integer id) {
        String sql = "SELECT * FROM company_profile WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        CompanyProfileDTO result = jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(CompanyProfileDTO.class));
        return result;
    }

}
