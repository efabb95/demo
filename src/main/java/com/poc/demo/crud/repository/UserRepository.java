package com.poc.demo.crud.repository;


import com.poc.demo.crud.repository.UserDocument;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends FirestoreReactiveRepository<UserDocument> {}
