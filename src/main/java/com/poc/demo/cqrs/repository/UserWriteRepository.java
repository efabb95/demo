package com.poc.demo.cqrs.repository;


import com.google.cloud.storage.BlobInfo;
import com.poc.demo.domain.StorageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

@Component
public class UserWriteRepository {

    private static final Logger log = LoggerFactory.getLogger(UserWriteRepository.class);
    private final ApplicationContext context;

    private final String bucket;

    public UserWriteRepository(
            ApplicationContext context, @Value("${config.storage.default-bucket}") String bucket) {
        this.context = context;
        this.bucket = bucket;
    }

    public StorageObject rawWrite(@NonNull String filename, @NonNull byte[] content) {

        final BlobInfo blobInfo = BlobInfo.newBuilder(bucket, filename).build();
        final String uri = blobInfo.getBlobId().toGsUtilUri();

        Resource resource = context.getResource(uri);
        try (OutputStream os = ((WritableResource) resource).getOutputStream()) {
            os.write(content);
        } catch (IOException e) {
            log.error("Error writing content filename={} ", filename, e);
            throw new RuntimeException(e);
        }

        return new StorageObject(bucket, filename, (long) content.length, content);
    }
}