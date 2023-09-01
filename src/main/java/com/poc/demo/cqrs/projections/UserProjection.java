package com.poc.demo.cqrs.projections;

import com.poc.demo.cqrs.queries.AddressByRegionQuery;
import com.poc.demo.cqrs.queries.ContactByTypeQuery;
import com.poc.demo.cqrs.repository.*;
import com.poc.demo.domain.*;

import java.util.Set;

public class UserProjection {
    private UserReadRepository repository;

    public UserProjection(UserReadRepository repository) {
        this.repository = repository;
    }

    public Set<Contact> handle(ContactByTypeQuery query) throws Exception {
        UserContact userContact = repository.getUserContact(query.getUserId());
        if (userContact == null)
            throw new Exception("User does not exist.");
        return userContact.getContactByType()
                .get(query.getContactType());
    }

    public Set<Address> handle(AddressByRegionQuery query) throws Exception {
        UserAddress userAddress = repository.getUserAddress(query.getUserId());
        if (userAddress == null)
            throw new Exception("User does not exist.");
        return userAddress.getAddressByRegion()
                .get(query.getState());
    }
}
