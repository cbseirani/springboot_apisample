package com.cbseirani.weatherapi.queries;

import com.cbseirani.weatherapi.entities.Item;
import com.cbseirani.weatherapi.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemQueryHandler {

    private static final Logger logger = LoggerFactory.getLogger(ItemQueryHandler.class);

    private final ItemRepository itemRepository;

    @QueryHandler
    public Item handle(GetItemQuery query) {
        logger.info("Handling query: {}", query);
        return itemRepository.findById(query.getItemId()).orElse(null);
    }
}
