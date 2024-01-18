package org.example.adapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.client.Client;
import org.example.client.Dul;
import org.example.person.FindPersonInfo;
import org.example.person.IdentityCard;
import org.example.person.Person;
import org.example.person.PersonName;

public class ClientToPersonAdapter {
    @JsonProperty("PersonInfo")
    private Person person;

    public ClientToPersonAdapter() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void adapt(Client client) {
        person = new Person();
        FindPersonInfo findPersonInfo = new FindPersonInfo();

        findPersonInfo.setPersonName(convertDulToPersonName(client.getFindInfo().getDul()));
        findPersonInfo.setIdentityCard(convertDulToIdentityCard(client.getFindInfo().getDul()));
        findPersonInfo.setPartyID(client.getFindInfo().getPartyId());
        person.setFindPersonInfo(findPersonInfo);
    }

    private PersonName convertDulToPersonName(Dul dul) {
        PersonName personName = new PersonName();
        personName.setFirstName(dul.getFirstName());
        personName.setLastName(dul.getLastName());
        personName.setSecondName(dul.getSecondName());
        return personName;
    }

    private IdentityCard convertDulToIdentityCard(Dul dul) {
        IdentityCard identityCard = new IdentityCard();
        identityCard.setIdType(dul.getDocumentType());
        identityCard.setIdNum(dul.getNumber());
        identityCard.setIdSeries(dul.getSeries());
        return identityCard;
    }
}
