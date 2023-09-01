package com.poc.demo.crud.repository;

import com.poc.demo.domain.User;
import org.springframework.core.convert.TypeDescriptor;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> store = new HashMap<>();

    public void addUser(String id, User user) {
        store.put(id, user);
    }

    public User getUser(String id) {
        return store.get(id);
    }


}
