package com.schoolproject.invoicing;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//http://localhost:8090/api/client/createclient/
@RestController
public class ClientController {
    private List<Client> clientList = new ArrayList<>();
    private Map<String, Client> clientMap = new HashMap<>();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ClientService clientService;

    @PostMapping("api/client/createclient/")
    public String createClient(@RequestBody ClientDto client) {
        return clientService.createClient(client.getClientName(), client.getAddress(), client.getContactPerson(), client.getCountry(), client.geteMail(), client.getPhoneNr(), client.getPostCode(), client.getRegNr(), client.getVatNr());
    }

    @DeleteMapping("api/client/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        return clientService.deleteClient(id);
    }


    @PutMapping("api/client/change/{id}")
    public String changeClient(@PathVariable("id") int id, @RequestBody ClientDto client) {
        return clientService.changeClient(id, client);
    }

    @GetMapping("api/client/{clientName}")
    public ClientDto getClient(@PathVariable("clientName") String clientName) {
        return clientService.getClient(clientName);
    }


    @GetMapping("api/client/getclient")
    public List<ClientDto> getClientList(@RequestParam("search") String search) {
        return clientService.getClientList(search);
    }

    @GetMapping("api/client/getallclients")
    public List<ClientDto> getAllClients() {
        return clientService.getClientList(null);
    }

    @GetMapping("api/getclient/{id}")
    public ClientDto getClientId(@PathVariable("id") Integer id) {
        return clientService.getClientId(id);
    }
}