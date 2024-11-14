package com.fish.aquarium.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish.aquarium.dto.AquariumDTO;
import com.fish.aquarium.dto.CreateAquariumRequest;
import com.fish.aquarium.entity.Aquarium;
import com.fish.aquarium.entity.User;
import com.fish.aquarium.mapper.AquariumMapper;
import com.fish.aquarium.repository.AquariumRepository;
import com.fish.aquarium.repository.UserRepository;

@Service
public class AquariumService {

    @Autowired
    private AquariumRepository aquariumRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AquariumMapper aquariumMapper;

    // Получение всех аквариумов
    public List<AquariumDTO> getAllAquariums() {
        List<Aquarium> aquariums = aquariumRepository.findAll();
        return aquariums.stream()
                        .map(aquariumMapper::toDTO)
                        .collect(Collectors.toList());
    }

    // Получение аквариумов по ID пользователя
    public List<AquariumDTO> getAquariumsByUserId(Long userId) {
        List<Aquarium> aquariums = aquariumRepository.findByUserId(userId);
        return aquariums.stream()
                        .map(aquariumMapper::toDTO)
                        .collect(Collectors.toList());
    }

    // Создание нового аквариума
    public AquariumDTO createAquarium(CreateAquariumRequest request) {
        User user = userRepository.findById(request.getUserId())
                                  .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        Aquarium aquarium = new Aquarium();
        aquarium.setName(request.getName());
        aquarium.setDescription(request.getDescription());
        aquarium.setUser(user);

        Aquarium savedAquarium = aquariumRepository.save(aquarium);
        return aquariumMapper.toDTO(savedAquarium);
    }


}
