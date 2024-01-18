package org.example.client;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "clientInfo")
public class Client {
    private ClientFindInfo findInfo;

    public Client() {
    }

    @JacksonXmlProperty(localName = "clientFindInfo")
    public ClientFindInfo getFindInfo() {
        return findInfo;
    }

    public void setFindInfo(ClientFindInfo findInfo) {
        this.findInfo = findInfo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "findInfo=" + findInfo +
                '}';
    }
}
