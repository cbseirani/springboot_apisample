package com.cbseirani.weatherapi.events;

import lombok.Value;

@Value
public class ItemCreatedEvent {
    private final String itemId;
    private final String itemName;
    private final String description;
}
