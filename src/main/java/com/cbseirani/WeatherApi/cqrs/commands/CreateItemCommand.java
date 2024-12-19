package com.cbseirani.weatherapi.cqrs.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class CreateItemCommand {
    @TargetAggregateIdentifier
    private final String itemId;
    private final String itemName;
    private final String description;
}
