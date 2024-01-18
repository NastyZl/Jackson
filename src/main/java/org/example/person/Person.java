package org.example.person;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Person {
    @JsonProperty("FindPersonInfo")
    private FindPersonInfo findPersonInfo;

    public Person() {
    }

    public FindPersonInfo getFindPersonInfo() {
        return findPersonInfo;
    }

    public void setFindPersonInfo(FindPersonInfo findPersonInfo) {
        this.findPersonInfo = findPersonInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "findPersonInfo=" + findPersonInfo +
                '}';
    }
}
