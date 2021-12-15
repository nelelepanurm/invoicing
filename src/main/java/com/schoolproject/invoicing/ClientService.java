package com.schoolproject.invoicing;

import ch.qos.logback.core.net.server.Client;
import com.schoolproject.invoicing.exception.ApplicationException;

import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    public String createClient(String clientName, String address, String contactPerson,String country, String eMail,String phoneNr,String postCode,String regNr, String vatNr) {
        if (clientName == null || clientName.isBlank()) {
            throw new ApplicationException("Name is not filled.");
        }

        if (eMail == null || eMail.isBlank()) {
            throw new ApplicationException("E-mail is not filled.");
        }
        if (regNr == null || regNr.isBlank()){
            throw new ApplicationException("Registration number is not filled.");
        }
        if (country == null || country.isBlank()){
            throw new ApplicationException("Country is not filled.");
        }
        if (address == null || address.isBlank()) {
            throw new ApplicationException("Address is not filled.");
        }
        clientRepository.createClient(clientName, address, contactPerson,country, eMail,phoneNr,postCode,regNr, vatNr);
        return "Client " + clientName + " is created.";

    }

    public String deleteClient(int id) {
        clientRepository.deleteClient(id);
        return "Client is deleted";

    }

    public String changeClient(Integer id, ClientDto client){
        clientRepository.changeClient(id, client);
        return "Client information is changed";
    }

    public ClientDto getClient(String clientName) {
        return clientRepository.getClient(clientName);
    }


    public List<ClientDto> getClientList() {
        return clientRepository.getClientList();
    }

    public ClientDto getClientId(Integer id) {
        return clientRepository.getClientId(id);
    }
}






