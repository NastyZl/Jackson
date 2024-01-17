package org.example.adapter;

import org.example.client.Client;
import org.example.client.Dul;
import org.example.person.FindPersonInfo;
import org.example.person.IdentityCard;
import org.example.person.Person;
import org.example.person.PersonName;

public class ClientToPersonAdapter {

    public static Person adapt(Client client) {
        Person person = new Person();
        FindPersonInfo findPersonInfo = new FindPersonInfo();

        findPersonInfo.setPersonName(convertDulToPersonName(client.getFindInfo().getDul()));
        findPersonInfo.setIdentityCard(convertDulToIdentityCard(client.getFindInfo().getDul()));
        findPersonInfo.setPartyID(client.getFindInfo().getPartyId());
        person.setFindPersonInfo(findPersonInfo);
        return person;
    }

    private static PersonName convertDulToPersonName(Dul dul) {
        PersonName personName = new PersonName();
        personName.setFirstName(dul.getFirstName());
        personName.setLastName(dul.getLastName());
        personName.setSecondName(dul.getSecondName());
        return personName;
    }

    private static IdentityCard convertDulToIdentityCard(Dul dul) {
        IdentityCard identityCard = new IdentityCard();
        identityCard.setIdType(dul.getDocumentType());
        identityCard.setIdNum(dul.getNumber());
        identityCard.setIdSeries(dul.getSeries());
        return identityCard;
    }
}
