package com.rahul.user.repository.jpa;

import com.rahul.user.entity.DiscussionLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionLikeRepository extends JpaRepository<DiscussionLike, Long> {
    Long countByDiscussionId(Long discussionId);

    DiscussionLike findByDiscussionIdAndUserId(Long discussionId, Long userId);

}