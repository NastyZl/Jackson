package org.example.person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonName {
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("MiddleName")
    private String secondName;

    public PersonName() {
    }

    @Override
    public String toString() {
        return "PersonName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
