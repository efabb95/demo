package com.poc.demo.cqrs.aggregates;

import com.poc.demo.cqrs.commands.CreateUserCommand;
import com.poc.demo.cqrs.commands.UpdateUserCommand;
import com.poc.demo.cqrs.repository.UserWriteRepository;
import com.poc.demo.crud.repository.UserRepositoryInterface;
import com.poc.demo.domain.User;
import com.poc.demo.es.service.UserService;

public class UserAggregate {

    private final UserWriteRepository writeRepository;
    private final UserService userService;

    public UserAggregate(UserWriteRepository repository, UserRepositoryInterface userRepositoryInterface, UserService userService) {
        this.writeRepository = repository;
        this.userService = userService;
    }

    public User handleCreateUserCommand(CreateUserCommand command) throws Exception {
        User user = new User(command.getUserId(), command.getFirstName(), command.getLastName());
        //writeRepository.addUser(user.getUserid(), user);
        userService.add(user);
        return user;
    }

    public User handleUpdateUserCommand(UpdateUserCommand command) {
        User user = writeRepository.getUser(command.getUserId());
        user.setAddresses(command.getAddresses());
        user.setContacts(command.getContacts());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }
}
