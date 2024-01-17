package org.example.client;

public class ClientFindInfo {
    private Dul dul;
    private int partyId;

    @Override
    public String toString() {
        return "FindInfo{" +
                "dul=" + dul +
                ", partyId=" + partyId +
                '}';
    }

    public Dul getDul() {
        return dul;
    }

    public void setDul(Dul dul) {
        this.dul = dul;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public ClientFindInfo() {
    }
}
