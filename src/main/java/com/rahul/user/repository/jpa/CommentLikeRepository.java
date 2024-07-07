package com.rahul.user.repository.jpa;

import com.rahul.user.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    Long countByCommentId(Long commentId);

}