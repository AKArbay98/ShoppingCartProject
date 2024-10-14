package com.example.shoppingcarddemo.service.concreteservice;

import com.example.shoppingcarddemo.exceptions.CommentNotFoundException;
import com.example.shoppingcarddemo.model.dto.CommentDTO;
import com.example.shoppingcarddemo.model.entity.comment.Comment;
import com.example.shoppingcarddemo.model.entity.product.Product;
import com.example.shoppingcarddemo.model.mapper.commentmapper.CommentMapperImpl;
import com.example.shoppingcarddemo.model.mapper.productmapper.ProductMapperImpl;
import com.example.shoppingcarddemo.repository.commentrepo.CommentRepository;
import com.example.shoppingcarddemo.service.abstractservice.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapperImpl commentMapperImpl;
    private final ProductMapperImpl productMapperImpl;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapperImpl commentMapperImpl, ProductMapperImpl productMapperImpl) {
        this.commentRepository = commentRepository;
        this.commentMapperImpl = commentMapperImpl;
        this.productMapperImpl = productMapperImpl;
    }

    @Override
    public List<CommentDTO> fetchAllComment() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(commentMapperImpl::convertCommentToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(commentMapperImpl::convertCommentToCommentDto)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + id));
    }

    @Override
    public void createComment(CommentDTO commentDTO) {
        Comment comment = commentMapperImpl.convertCommentDtoToComment(commentDTO);
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(Long id, CommentDTO commentDTO) {

        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with id: " + id));
        existingComment.setContent(commentDTO.getContent());

        if (commentDTO.getProduct() != null) {
            Product product = productMapperImpl.convertProductDtoToProduct(commentDTO.getProduct());
            existingComment.setProduct(product);
        }

        commentRepository.save(existingComment);
    }


    @Override
    public void deleteCommentById(Long commentId) {
        if(!commentRepository.existsById(commentId)){
            throw new IllegalArgumentException("Comment with ID " + commentId + " does not exist.");
        }
        commentRepository.deleteById(commentId);
    }

}
