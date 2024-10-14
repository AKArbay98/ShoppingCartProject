package com.example.shoppingcarddemo.controller.comment;

import com.example.shoppingcarddemo.model.dto.CommentDTO;
import com.example.shoppingcarddemo.service.abstractservice.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDTO>> getAllComment(){
        List<CommentDTO> comments = commentService.fetchAllComment();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable Long id){
        CommentDTO commentById = commentService.getCommentById(id);
        return ResponseEntity.ok(commentById);
    }

    @PostMapping("/comment")
    public void createComment(@RequestBody CommentDTO commentDTO){
        commentService.createComment(commentDTO);
    }

    @PutMapping("/comment/{id}")
    public void updateComment(@PathVariable("id") Long id, @RequestBody CommentDTO commentDTO){
        commentService.updateComment(id, commentDTO);
    }

    @DeleteMapping("comment/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteCommentById(id);
    }

}
