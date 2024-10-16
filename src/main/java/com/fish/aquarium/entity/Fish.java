package com.fish.aquarium.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Fish {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private long id;
@Column(nullable = false)
    private String species;

    @Column
    private String color;

    @Column
    private double size;

    @Column
    private String habitat;

    // constructors
public Fish(String species, String color, double size, String habitat) {
    this.species = species;
    this.color = color;
    this.size = size;
    this.habitat = habitat;}
    
    @ManyToOne
    @JoinColumn(name = "aquarium_id")
    private Aquarium aquarium;

    public Long getID(){
        return id;
    }
    public void setID(Long id){
        this.id = id;
    }
    public String getSpecies(){
        return  species;
    }
    public void setSpecies(String species){
        this.species = species;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public double getSize(){
        return size;
    }
    public void setSize(double size){
        this.size=size;
    }
    public String getHabitat(){
        return habitat;
    }
    public void setHabitat(String habitat){
        this.habitat = habitat;
    }
    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}
