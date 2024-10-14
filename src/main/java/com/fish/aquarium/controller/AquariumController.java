package com.fish.aquarium.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish.aquarium.entity.Aquarium;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/aquariums")
public class AquariumController {
    
    @Autowired
    private AquariumService aquariumService;

    @PostMapping("/create")
    public Aquarium createAquarium(@RequestBody Aquarium aquarium){
        return aquariumService.createAquarium(aquarium);
        }
        
    @GetMapping("/{aquariumId}")
        public Aquarium getAquarium(@PathVariable Long aquarium){
        return aquariumService.getAquariumById(aquariumId);
        }
    @GetMapping("/user/{userId}")
    public List<Aquarium> getAquariumByUser(@PathVariable Long userId){
        return aquariumService.getAquariumById(userId);
    }

}




    
    

