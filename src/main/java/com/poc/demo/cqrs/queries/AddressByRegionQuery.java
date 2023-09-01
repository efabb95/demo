package com.poc.demo.cqrs.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressByRegionQuery {

    private String userId;
    private String state;
}