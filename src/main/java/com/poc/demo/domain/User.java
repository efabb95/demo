package com.poc.demo.domain;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class User {
    @NonNull
    private String userid;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    private Set<Contact> contacts = new HashSet<>();
    private Set<Address> addresses = new HashSet<>();


    public String getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
