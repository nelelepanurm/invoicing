package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
public class CompanyProfileController {

    @Autowired
    private CompanyProfileService companyProfileService;
    @Autowired
    private UserService userService;

    @PostMapping("api/public/registercompany/")
    public void registerCompany(@RequestBody CompanyProfileDTO companyProfile) {
        int newUserId = userService.createUser(companyProfile.getUserName(), companyProfile.getPassword());
        companyProfileService.registerCompany(newUserId,
                companyProfile.geteMail(),
                companyProfile.getPhoneNr(),
                companyProfile.getAddress(),
                companyProfile.getPostalCode(),
                companyProfile.getCountry(),
                companyProfile.getRegNr(),
                companyProfile.getVatCode(),
                companyProfile.getBankName1(),
                companyProfile.getIban1(),
                companyProfile.getSwift1(),
                companyProfile.getBankName2(),
                companyProfile.getIban2(),
                companyProfile.getSwift2(),
                companyProfile.getBankName3(),
                companyProfile.getIban3(),
                companyProfile.getSwift3(),
                companyProfile.getEmailText(),
                companyProfile.getPaymentDeadline(),
                companyProfile.getDelayPenalty(),
                companyProfile.getUnit(),
                companyProfile.getLogoFail(),
                companyProfile.getCompanyName());
    }

    @PutMapping("api/company/change")
    public String changeCompany(Principal principal, @RequestBody CompanyProfileDTO companyProfile) {
        String loggedInUser = principal.getName();
        return companyProfileService.changeCompany(loggedInUser, companyProfile);
    }

    @GetMapping("api/getcompany")
    public CompanyProfileDTO getCompany(Principal principal) {
        String loggedInUser = principal.getName();
        return companyProfileService.getCompany(loggedInUser);
    }

    @GetMapping("api/company/{id}")
    public CompanyProfileDTO findCompany(@PathVariable("id") Integer id) {
        return companyProfileService.findCompany(id);
    }
}
