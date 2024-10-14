package com.example.shoppingcarddemo.model.mapper.commentmapper;

import com.example.shoppingcarddemo.model.dto.CommentDTO;
import com.example.shoppingcarddemo.model.entity.comment.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "content", target = "content")
    @Mapping(source = "product", target = "product")
    CommentDTO commentToCommentDTO(Comment comment);

    @Mapping(source = "content", target = "content")
    @Mapping(source = "product", target = "product")
    Comment commentDtoToComment(CommentDTO commentDto);

}
