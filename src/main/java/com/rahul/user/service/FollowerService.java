package com.rahul.user.service;

import com.rahul.user.entity.Follower;
import com.rahul.user.entity.User;
import com.rahul.user.repository.jpa.FollowerRepository;
import com.rahul.user.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean followUser(Long userId, Long followedUserId) {
        if (!followerRepository.findByFollowingUserIdAndFollowedUserId(userId, followedUserId).isEmpty()) {

            User followingUser = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
            User followedUser = userRepository.findById(followedUserId).orElseThrow(() -> new IllegalArgumentException("User not found: " + followedUserId));

            Follower userFollow = new Follower();
            userFollow.setFollowingUser(followingUser);
            userFollow.setFollowedUser(followedUser);
            followerRepository.save(userFollow);
            return true;
        }
        return false;
    }

    public boolean unfollowUser(Long userId, Long followedUserId) {
        if (!followerRepository.findByFollowingUserIdAndFollowedUserId(userId, followedUserId).isEmpty()) {
            followerRepository.deleteByFollowingUserIdAndFollowedUserId(userId, followedUserId);
            return true;
        }
        return false;
    }

    public boolean isFollowing(Long userId, Long followedUserId) {
        return !followerRepository.findByFollowingUserIdAndFollowedUserId(userId, followedUserId).isEmpty();
    }
}