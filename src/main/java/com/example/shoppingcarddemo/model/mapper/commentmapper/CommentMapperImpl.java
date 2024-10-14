package com.example.shoppingcarddemo.model.mapper.commentmapper;

import com.example.shoppingcarddemo.model.dto.CommentDTO;
import com.example.shoppingcarddemo.model.entity.comment.Comment;

public class CommentMapperImpl {

    private final CommentMapper commentMapper;

    public CommentMapperImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public CommentDTO convertCommentToCommentDto(Comment comment){
        return commentMapper.commentToCommentDTO(comment);
    }

    public Comment convertCommentDtoToComment(CommentDTO commentDTO){
        return commentMapper.commentDtoToComment(commentDTO);
    }
}
