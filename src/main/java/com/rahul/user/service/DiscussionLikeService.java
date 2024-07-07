package com.rahul.user.service;

import com.rahul.user.entity.Discussion;
import com.rahul.user.entity.DiscussionLike;
import com.rahul.user.entity.User;
import com.rahul.user.repository.jpa.DiscussionLikeRepository;
import com.rahul.user.repository.jpa.DiscussionRepository;
import com.rahul.user.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DiscussionLikeService {

    @Autowired
    private DiscussionLikeRepository discussionLikeRepository;

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private UserRepository userRepository;

    public String likeOrUnlikeDiscussion(String discussionId, Long userId) {
        DiscussionLike existingLike = discussionLikeRepository.findByDiscussionIdAndUserId(discussionId, userId);
        if (existingLike != null) {
            discussionLikeRepository.delete(existingLike);
            return "Discussion unliked successfully.";
        } else {
            Discussion discussion = discussionRepository.findById(discussionId)
                    .orElseThrow(() -> new RuntimeException("Discussion not found with id: " + discussionId));
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

            DiscussionLike discussionLike = new DiscussionLike();
            discussionLike.setDiscussion(discussion);
            discussionLike.setUser(user);
            discussionLikeRepository.save(discussionLike);
            return "Discussion liked successfully.";
        }
    }

    public Long countLikesByDiscussion(Long discussionId) {
        return discussionLikeRepository.countByDiscussionId(discussionId);
    }
}