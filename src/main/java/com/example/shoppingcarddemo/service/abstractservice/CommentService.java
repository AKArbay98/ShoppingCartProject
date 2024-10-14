package com.example.shoppingcarddemo.service.abstractservice;

import com.example.shoppingcarddemo.model.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    void deleteCommentById(Long id);

    List<CommentDTO> fetchAllComment();

    CommentDTO getCommentById(Long id);

    void createComment(CommentDTO commentDTO);

    void updateComment(Long id, CommentDTO commentDTO);

}
