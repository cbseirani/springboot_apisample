package com.cbseirani.weatherapi.queries;

import lombok.Value;

@Value
public class GetItemQuery {
    private final String itemId;
}
