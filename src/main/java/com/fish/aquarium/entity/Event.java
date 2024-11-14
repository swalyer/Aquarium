package com.fish.aquarium.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_type")
    private String eventType; // Например, 'Кормление рыб', 'Чистка аквариума'

    private String description;

    @Column(name = "event_time")
    private LocalDateTime eventTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aquarium_id")
    private Aquarium aquarium;



    public Event() {}

    public Event(String eventType, String description, LocalDateTime eventTime, Aquarium aquarium) {
        this.eventType = eventType;
        this.description = description;
        this.eventTime = eventTime;
        this.aquarium = aquarium;
    }
public String eventType(){
    return
}


}
