// src/main/java/com/fish/aquarium/service/EventService.java

package com.fish.aquarium.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish.aquarium.dto.CreateEventRequest;
import com.fish.aquarium.dto.EventDTO;
import com.fish.aquarium.entity.Aquarium;
import com.fish.aquarium.entity.Event;
import com.fish.aquarium.mapper.EventMapper;
import com.fish.aquarium.repository.AquariumRepository;
import com.fish.aquarium.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AquariumRepository aquariumRepository;

    @Autowired
    private EventMapper eventMapper;

    // Получение всех событий
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                     .map(eventMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Получение событий по ID аквариума
    public List<EventDTO> getEventsByAquariumId(Long aquariumId) {
        List<Event> events = eventRepository.findByAquariumId(aquariumId);
        return events.stream()
                     .map(eventMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Создание нового события
    public EventDTO createEvent(CreateEventRequest request) {
        Aquarium aquarium = aquariumRepository.findById(request.getAquariumId())
                                              .orElseThrow(() -> new RuntimeException("Аквариум не найден"));

        Event event = new Event();
        event.setName(request.getName());
        event.setDescription(request.getDescription());
        event.setAquarium(aquarium);

        Event savedEvent = eventRepository.save(event);
        return eventMapper.toDTO(savedEvent);
    }

    // Другие методы (обновление, удаление) по необходимости
}
