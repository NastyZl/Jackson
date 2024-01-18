package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.adapter.ClientToPersonAdapter;
import org.example.client.Client;
import org.example.person.Person;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("ClientInfo.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Client clientInfo = xmlMapper.readValue(file, Client.class);
        System.out.println(clientInfo);

        ObjectMapper objectMapper = new ObjectMapper();
        ClientToPersonAdapter person = new ClientToPersonAdapter();
        person.adapt(clientInfo);
        System.out.println(person);
        objectMapper.writeValue(new File("PersonInfo.json"), person);
    }
}
