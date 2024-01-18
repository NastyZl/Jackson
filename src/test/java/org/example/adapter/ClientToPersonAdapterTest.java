package org.example.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.client.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class ClientToPersonAdapterTest {

    private Client client;
    @InjectMocks
    private ClientToPersonAdapter converter;

    @Test
    void convertToPersonStructure() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClientToPersonAdapter person = new ClientToPersonAdapter();
        person.adapt(client);
        System.out.println(person);
        objectMapper.writeValue(new File("PersonInfo.json"), person);
    }

}