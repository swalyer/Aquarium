package com.fish.aquarium.dto;

import java.time.LocalDateTime;

public class EventDTO {
    private Long id;
    private String eventType;
    private String description;
    private LocalDateTime eventTime;
    private Long aquariumId;

    // Конструкторы
    public EventDTO() {}

    public EventDTO(Long id, String eventType, String description, LocalDateTime eventTime, Long aquariumId) {
        this.id = id;
        this.eventType = eventType;
        this.description = description;
        this.eventTime = eventTime;
        this.aquariumId = aquariumId;
    }

   }
