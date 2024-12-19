package com.cbseirani.weatherapi.aggregates;

import com.cbseirani.weatherapi.commands.CreateItemCommand;
import com.cbseirani.weatherapi.events.ItemCreatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Data
@NoArgsConstructor
public class ItemAggregate {

    private static final Logger logger = LoggerFactory.getLogger(ItemAggregate.class);

    @AggregateIdentifier
    private String itemId;
    private String itemName;
    private String description;

    @CommandHandler
    public ItemAggregate(CreateItemCommand command) {
        logger.info("Handling command: {}", command);
        apply(new ItemCreatedEvent(command.getItemId(), command.getItemName(), command.getDescription()));
    }

    @EventSourcingHandler
    public void on(ItemCreatedEvent event) {
        logger.info("Applying event: {}", event);
        this.itemId = event.getItemId();
        this.itemName = event.getItemName();
        this.description = event.getDescription();
    }
}
