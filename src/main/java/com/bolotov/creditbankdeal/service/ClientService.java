package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.dto.ClientDto;
import com.bolotov.creditbankdeal.entity.Client;

import java.util.UUID;

public interface ClientService {

    Client createClient(ClientDto clientDto);

    void updateClient(UUID id, ClientDto clientDto);

    Client findClient(UUID id);
}
