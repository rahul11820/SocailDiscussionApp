package com.rahul.user.service;

import com.rahul.user.entity.CommentLike;
import com.rahul.user.repository.jpa.CommentLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLikeService {

    @Autowired
    private CommentLikeRepository commentLikeRepository;

    public CommentLike likeComment(CommentLike commentLike) {
        return commentLikeRepository.save(commentLike);
    }

    public Long countLikesByComment(Long commentId) {
        return commentLikeRepository.countByCommentId(commentId);
    }
}