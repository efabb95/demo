package com.poc.demo.cqrs.commands;

import com.poc.demo.domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
public class UpdateUserCommand {

    private String userId;
    private Set<Address> addresses = new HashSet<>();
    private Set<Contact> contacts = new HashSet<>();
}
