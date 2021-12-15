package com.schoolproject.invoicing;


import com.schoolproject.invoicing.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CompanyProfileService {

    @Autowired
    private CompanyProfileRepository companyProfileRepository;

    public String registerCompany(int newuserId, String eMail, String phoneNr, String address, String postalCode, String country, String regNr, String vatCode, String bankName1, String iban1, String swift1, String bankName2, String iban2, String swift2, String bankName3, String iban3, String swift3, String emailText, String paymentDeadline, int delayPenalty, String unit, String logoFail, String companyName) {
     /*   if (userName == null || userName.isBlank()) {
            throw new ApplicationException("Username is not filled.");
        }

        if (password == null || password.isBlank()) {
            throw new ApplicationException("Password is not filled.");
        } */
        if (eMail == null || eMail.isBlank()) {
            throw new ApplicationException("E-mail is not filled.");
        }
        if (companyName == null || companyName.isBlank()) {
            throw new ApplicationException("Company name is not filled.");
        }
        if (address == null || address.isBlank()) {
            throw new ApplicationException("Address is not filled.");
        }
        if (postalCode == null || postalCode.isBlank()) {
            throw new ApplicationException("Postcode is not filled.");
        }
        if (country == null || country.isBlank()) {
            throw new ApplicationException("Country is not filled.");
        }
        if (regNr == null || regNr.isBlank()) {
            throw new ApplicationException("Registration number is not filled.");
        }
        if (vatCode == null || vatCode.isBlank()) {
            throw new ApplicationException("VAT code is not filled.");
        }
        if (bankName1 == null || bankName1.isBlank()) {
            throw new ApplicationException("Bank name is not filled.");
        }
        if (iban1 == null || iban1.isBlank()) {
            throw new ApplicationException("Bank IBAN number is not filled.");
        }
        if (swift1 == null || swift1.isBlank()) {
            throw new ApplicationException("Bank SWIFT code is not filled.");
        }
        companyProfileRepository.registerCompany(newuserId, eMail, phoneNr, address, postalCode, country, regNr, vatCode, bankName1, iban1, swift1, bankName2, iban2, swift2, bankName3, iban3, swift3, emailText, paymentDeadline, delayPenalty, unit, logoFail, companyName);
        return "Company profile " + companyName + " is created.";

    }

    public String changeCompany(Integer id, CompanyProfileDTO companyProfile) {
        companyProfileRepository.changeCompany(id, companyProfile);
        return "Company information is updated";
    }


    public CompanyProfileDTO getCompany(String userName) {
        return companyProfileRepository.getCompany(userName);
    }

    public CompanyProfileDTO findCompany (Integer id) {
        return companyProfileRepository.findCompany(id);
    }
}

