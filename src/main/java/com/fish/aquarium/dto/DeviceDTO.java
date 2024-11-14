// src/main/java/com/fish/aquarium/dto/DeviceDTO.java

package com.fish.aquarium.dto;

public class DeviceDTO {
    private Long id;
    private String type;
    private String brand;
    private String model;
    private String imageUrl;
    private String status;
    private Long aquariumId;



    public DeviceDTO() {}

    public DeviceDTO(Long id, String type, String brand, String model, String imageUrl, String status, Long aquariumId) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.imageUrl = imageUrl;
        this.status = status;
        this.aquariumId = aquariumId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) { 
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) { 
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) { 
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) { 
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { 
        this.status = status;
    }

    public Long getAquariumId() {
        return aquariumId;
    }

    public void setAquariumId(Long aquariumId) { 
        this.aquariumId = aquariumId;
    }
}
