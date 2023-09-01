package com.poc.demo.cqrs.repository;



import com.poc.demo.domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserWriteRepository {

    private final Map<String, User> store = new HashMap<>();

    public void addUser(String id, User user) {
        store.put(id, user);
    }

    public User getUser(String id) {
        return store.get(id);
    }
}