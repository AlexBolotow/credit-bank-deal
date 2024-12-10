package com.bolotov.creditbankdeal.service;

import com.bolotov.creditbankdeal.entity.Client;

import java.util.UUID;

public interface ClientService {

    Client createClient(com.bolotov.creditbankdeal.dto.ClientDto clientDto);

    void updateClient(UUID id, com.bolotov.creditbankdeal.dto.ClientDto clientDto);

    Client findClient(UUID id);
}
