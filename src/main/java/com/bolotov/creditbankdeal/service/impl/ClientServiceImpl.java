package com.bolotov.creditbankdeal.service.impl;

import com.bolotov.creditbankdeal.dto.ClientDto;
import com.bolotov.creditbankdeal.entity.Client;
import com.bolotov.creditbankdeal.entity.Employment;
import com.bolotov.creditbankdeal.entity.Passport;
import com.bolotov.creditbankdeal.exception.ClientNotFoundException;
import com.bolotov.creditbankdeal.mapper.ClientMapper;
import com.bolotov.creditbankdeal.mapper.EmploymentMapper;
import com.bolotov.creditbankdeal.mapper.PassportMapper;
import com.bolotov.creditbankdeal.repository.ClientRepository;
import com.bolotov.creditbankdeal.service.ClientService;
import com.bolotov.creditbankdeal.service.EmploymentService;
import com.bolotov.creditbankdeal.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final PassportService passportService;

    private final EmploymentService employmentService;

    private final ClientMapper clientMapper;

    private final PassportMapper passportMapper;

    private final EmploymentMapper employmentMapper;

    @Override
    public Client createClient(ClientDto clientDto) {
        if (clientDto.getPassport() != null) {
            Passport savedPassport = passportService.createPassport(clientDto.getPassport());
            clientDto.setPassport(passportMapper.toDto(savedPassport));
        }

        if (clientDto.getEmployment() != null) {
            Employment savedEmployment = employmentService.createEmployment(clientDto.getEmployment());
            clientDto.setEmployment(employmentMapper.toDto(savedEmployment));
        }

        return clientRepository.save(clientMapper.toEntity(clientDto));
    }

    @Override
    public Client findClient(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(
                        () -> new ClientNotFoundException("Client with id " + id + " not found")
                );
    }

    @Override
    public void updateClient(UUID id, ClientDto clientDto) {
        Client client = findClient(id);

        //upsert passport
        if (clientDto.getPassport() != null) {
            if (client.getPassport() == null) {
                Passport savedPassport = passportService.createPassport(clientDto.getPassport());
                clientDto.setPassport(passportMapper.toDto(savedPassport));
            } else {
                passportService.updatePassport(client.getPassport().getId(), clientDto.getPassport());
            }
        }

        //upsert employment
        if (clientDto.getEmployment() != null) {
            if (client.getEmployment() == null) {
                Employment savedEmployment = employmentService.createEmployment(clientDto.getEmployment());
                clientDto.setEmployment(employmentMapper.toDto(savedEmployment));
            } else {
                employmentService.updateEmployment(client.getEmployment().getId(), clientDto.getEmployment());
            }
        }

        clientMapper.updateEntityFromDto(client, clientDto);
        clientRepository.save(client);
    }
}
