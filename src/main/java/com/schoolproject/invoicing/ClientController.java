package com.schoolproject.invoicing;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//http://localhost:8090/api/client/createclient/
@RestController
public class ClientController {
    private List<Client> clientList = new ArrayList<>();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ClientService clientService;

    @PostMapping("api/client/createclient/")
    public String createClient(@RequestBody ClientDto client){

        return clientService.createClient(client.getClientName(),client.getAddress(),client.getContactPerson(),client.getCountry(),client.geteMail(),client.getPhoneNr(),client.getPostCode(),client.getRegNr(),client.getVatNr());
    }

}
