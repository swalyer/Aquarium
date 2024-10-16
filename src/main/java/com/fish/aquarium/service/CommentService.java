package com.fish.aquarium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish.aquarium.entity.Comment;
import com.fish.aquarium.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByAquarium(Long aquariumId) {
        return commentRepository.findByAquariumId(aquariumId);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}