package com.rahul.user.repository.jpa;

import com.rahul.user.entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
    List<Follower> findByFollowingUserIdAndFollowedUserId(Long userId, Long followedUserId);
    void deleteByFollowingUserIdAndFollowedUserId(Long userId, Long followedUserId);
}