package com.poc.demo.cqrs.repository;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.poc.demo.domain.StorageObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserReadRepository {
    private final Storage storage;

    private final String bucket;

    public UserReadRepository(Storage storage, @Value("${config.storage.default-bucket}") String bucket) {
        this.storage = storage;
        this.bucket = bucket;
    }

    public StorageObject rawRead(@NonNull String filename) {

        final Blob blob = storage.get(bucket, filename);

        return Optional.ofNullable(blob)
                .map(b -> new StorageObject(bucket, filename, b.getSize(), b.getContent()))
                .orElse(null);
    }
}
