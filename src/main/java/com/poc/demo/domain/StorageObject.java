package com.poc.demo.domain;

/* Object in a generic cloud storage service. */


public class StorageObject {
    private String bucket;
    private String filename;
    private Long length;
    private byte[] content;

    public StorageObject(String bucket, String filename, Long length, byte[] content) {
        this.bucket = bucket;
        this.filename = filename;
        this.length = length;
        this.content = content;
    }
}