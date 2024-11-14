package com.fish.aquarium.dto;

import java.util.List;

public class AquariumDTO {
    private Long id;
    private String name;
    private String description;
    private Long userId;
    private List<FishDTO> fishes;
    private List<PlantDTO> plants;
    private List<DeviceDTO> devices;
    private List<EventDTO> events;
    private List<ReviewDTO> reviews;

    // Конструкторы
    public AquariumDTO() {}

    public AquariumDTO(Long id, String name, String description, Long userId, List<FishDTO> fishes,
                      List<PlantDTO> plants, List<DeviceDTO> devices, List<EventDTO> events, List<ReviewDTO> reviews) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.fishes = fishes;
        this.plants = plants;
        this.devices = devices;
        this.events = events;
        this.reviews = reviews;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<FishDTO> getFishes() {
		return fishes;
	}

	public void setFishes(List<FishDTO> fishes) {
		this.fishes = fishes;
	}

	public List<PlantDTO> getPlants() {
		return plants;
	}

	public void setPlants(List<PlantDTO> plants) {
		this.plants = plants;
	}

	public List<DeviceDTO> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceDTO> devices) {
		this.devices = devices;
	}

	public List<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventDTO> events) {
		this.events = events;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
}
