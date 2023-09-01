package com.poc.demo.cqrs.controller;

import com.poc.demo.cqrs.aggregates.UserAggregate;
import com.poc.demo.cqrs.commands.CreateUserCommand;
import com.poc.demo.domain.User;
import com.poc.demo.es.repository.EventStore;
import com.poc.demo.es.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class DemoController {

    private final UserAggregate userAggregate;
    //private final UserService userService;

    public DemoController(UserAggregate userAggregate) {
        this.userAggregate = userAggregate;
      //  this.userService = userService;
    }


    //@PostMapping("/{userId}")
    //@ResponseStatus(HttpStatus.CREATED)
    //public User create(@RequestBody User user) throws Exception {
    //    return userService.add(user);
    //}

    //@GetMapping("/{id}")
    //public User read(@PathVariable String id) throws Exception {
    //    return Optional.ofNullable(userService.get(id)).orElseThrow(Exception::new);
    //}
   @PostMapping("/{userId}")
   public User createUser(@PathVariable("userId") String userId, @RequestParam("name") String name, @RequestParam("lastName") String lastName) throws Exception {
        return userAggregate.handleCreateUserCommand(new CreateUserCommand(userId,name,lastName));
   }
}
