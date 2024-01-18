package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.example.client.Client;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientToPersonAdapterTest {

    private static Client client;

    @BeforeAll
    static void setClient() {
        client = new Client();
    }

    @Test
    @Order(1)
    void deserializedFromXml() throws IOException {
        File file = new File("src/main/resources/ClientInfo.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(Files.newInputStream(file.toPath()));
        client = xmlMapper.readValue(xml, Client.class);
        assertEquals(32, client.getFindInfo().getPartyId());
    }

    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    @Test
    @Order(2)
    void deserializedToJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClientToPersonAdapter person = new ClientToPersonAdapter();
        person.adapt(client);
        objectMapper.writeValue(new File("src/main/resources/PersonInfo.json"), person);
    }

    @Test
    @Order(3)
    public void validOfJsonSchema() throws ValidationException {
        try {
            String schemaFilePath = "src/main/resources/schema_json.json";
            String schemaString = new String(Files.readAllBytes(Paths.get(schemaFilePath)));
            JSONObject schemaJson = new JSONObject(new JSONTokener(schemaString));
            Schema schema = SchemaLoader.load(schemaJson);

            String dataFilePath = "src/main/resources/PersonInfo.json";
            String dataString = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            JSONObject dataJson = new JSONObject(new JSONTokener(dataString));
            schema.validate(dataJson);

        } catch (Exception e) {
            fail(e);
        }
    }

}