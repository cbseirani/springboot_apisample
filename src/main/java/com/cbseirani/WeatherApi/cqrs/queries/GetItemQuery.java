package com.cbseirani.weatherapi.cqrs.queries;

import lombok.Value;

@Value
public class GetItemQuery {
    private final String itemId;
}
