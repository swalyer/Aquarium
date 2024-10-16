package com.fish.aquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fish.aquarium.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByAquariumId(Long aquariumId);
}