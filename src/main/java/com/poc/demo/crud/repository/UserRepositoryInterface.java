package com.poc.demo.crud.repository;


import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryInterface extends FirestoreReactiveRepository<UserDocument> {}

