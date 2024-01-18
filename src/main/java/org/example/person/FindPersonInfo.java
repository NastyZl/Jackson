package org.example.person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindPersonInfo {

    private PersonName personName;

    private IdentityCard identityCard;

    private int partyID;

    public FindPersonInfo() {
    }

    @JsonProperty("PartyID")
    public int getPartyID() {
        return partyID;
    }

    public void setPartyID(int partyID) {
        this.partyID = partyID;
    }

    @JsonProperty("PersonName")
    public PersonName getPersonName() {
        return personName;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

    @JsonProperty("IdentityCard")
    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(IdentityCard identityCard) {
        this.identityCard = identityCard;
    }

    @Override
    public String toString() {
        return "FindPersonInfo{" +
                "personName=" + personName +
                ", identityCard=" + identityCard +
                '}';
    }
}
