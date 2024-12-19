package com.cbseirani.weatherapi.controllers;

import com.cbseirani.weatherapi.cqrs.commands.CreateItemCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemCommandController {

    private static final Logger logger = LoggerFactory.getLogger(ItemCommandController.class);

    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public String createItem(@RequestParam String itemName, @RequestParam String description) {
        String itemId = UUID.randomUUID().toString();
        logger.info("Creating item with ID: {} and name: {}", itemId, itemName);
        CreateItemCommand command = new CreateItemCommand(itemId, itemName, description);
        commandGateway.send(command);
        return itemId;
    }
}
