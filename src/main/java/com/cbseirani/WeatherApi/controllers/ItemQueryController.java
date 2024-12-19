package com.cbseirani.weatherapi.controllers;

import com.cbseirani.weatherapi.models.Item;
import com.cbseirani.weatherapi.cqrs.queries.FindAllItemsQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemQueryController {

    private final QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Item>> getAllItems() {
        return queryGateway.query(new FindAllItemsQuery(), ResponseTypes.multipleInstancesOf(Item.class));
    }
}