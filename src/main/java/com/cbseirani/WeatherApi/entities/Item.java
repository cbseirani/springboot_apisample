package com.cbseirani.weatherapi.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data
@NoArgsConstructor
public class Item {
    @Id
    private String id;
    private String name;
    private String description;
}
