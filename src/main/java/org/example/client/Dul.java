package org.example.client;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Dul {
    private int documentType;
    private String firstName;
    private String lastName;
    private String secondName;
    private int number;
    private int series;

    public Dul() {
    }

    @JacksonXmlProperty(localName = "documentType")
    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    @JacksonXmlProperty(localName = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JacksonXmlProperty(localName = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JacksonXmlProperty(localName = "secondName")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @JacksonXmlProperty(localName = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @JacksonXmlProperty(localName = "series")
    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Dul{" +
                "documentType=" + documentType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", number=" + number +
                ", series=" + series +
                '}';
    }
}
