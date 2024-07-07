package com.rahul.user.controller;

import com.rahul.user.entity.Discussion;
import com.rahul.user.entity.User;
import com.rahul.user.service.DiscussionLikeService;
import com.rahul.user.service.DiscussionService;
import com.rahul.user.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @Autowired
    private DiscussionLikeService discussionLikeService;

    @PostMapping
    public Discussion createDiscussion(@RequestBody Discussion discussion) {
        return discussionService.createDiscussion(discussion);
    }

    @PutMapping("/{id}")
    public Discussion updateDiscussion(@PathVariable Long id, @RequestBody Discussion discussion) {
        return discussionService.updateDiscussion(id, discussion);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscussion(@PathVariable Long id) {
        discussionService.deleteDiscussion(id);
    }

    @GetMapping("/tags/{tag}")
    public List<Discussion> listDiscussionsByTag(@PathVariable String tag) {
        return discussionService.listDiscussionsByTag(tag);
    }

    @GetMapping("/search")
    public List<Discussion> listDiscussionsByText(@RequestParam String text) {
        return discussionService.listDiscussionsByText(text);
    }

    @PostMapping("/{id}/likes")
    public void likeDiscussion(@PathVariable String id) {
        Long userId = SecurityUtils.getCurrentUserId();
        discussionLikeService.likeOrUnlikeDiscussion(id, userId);
    }

    @GetMapping("/{id}/likes/count")
    public Long getLikesCount(@PathVariable Long id) {
        Long userId = SecurityUtils.getCurrentUserId();
        return discussionLikeService.countLikesByDiscussion(id);
    }
}