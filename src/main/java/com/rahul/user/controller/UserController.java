package com.rahul.user.controller;

import com.rahul.user.entity.Follower;
import com.rahul.user.entity.User;
import com.rahul.user.service.FollowerService;
import com.rahul.user.service.UserService;
import com.rahul.user.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FollowerService followerService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/search")
    public List<User> searchUserByName(@RequestParam String name) {
        return userService.searchUserByName(name);
    }

    @PostMapping("/{followedUserId}/follow")
    public String followUser(@PathVariable Long followedUserId) {
        Long userId = SecurityUtils.getCurrentUserId();
        boolean success = followerService.followUser(userId, followedUserId);
        return success ? "Followed successfully" : "Already following";
    }

    @PostMapping("/{followedUserId}/unfollow")
    public String unfollowUser(@PathVariable Long followedUserId) {
        Long userId = SecurityUtils.getCurrentUserId();
        boolean success = followerService.unfollowUser(userId, followedUserId);
        return success ? "Unfollowed successfully" : "Not following";
    }
}
