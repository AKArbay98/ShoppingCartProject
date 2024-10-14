package com.example.shoppingcarddemo.repository.commentrepo;

import com.example.shoppingcarddemo.model.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
