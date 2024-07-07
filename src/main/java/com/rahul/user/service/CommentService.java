package com.rahul.user.service;

import com.rahul.user.entity.Comment;
import com.rahul.user.repository.jpa.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        comment.setCreatedOn(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> listCommentsByDiscussion(Long discussionId) {
        return commentRepository.findByDiscussionId(discussionId);
    }
}