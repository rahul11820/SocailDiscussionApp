package com.rahul.user.service;

import com.rahul.user.entity.Discussion;
import com.rahul.user.entity.HashTag;
import com.rahul.user.exception.DiscussionNotFoundException;
import com.rahul.user.repository.jpa.DiscussionRepository;
import com.rahul.user.repository.elasticsearch.DiscussionSearchRepository;
import com.rahul.user.repository.jpa.HashTagRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private DiscussionSearchRepository discussionSearchRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

    @Transactional
    public Discussion createDiscussion(Discussion discussion) {
        long createdOnMillis = Instant.now().toEpochMilli();
        discussion.setHashTags(processHashTags(discussion.getHashTags()));
        discussion.setCreatedOn(createdOnMillis);
        Discussion discussion1 = discussionRepository.save(discussion);
        discussionSearchRepository.save(discussion);
        return discussion1;
    }

    @Transactional
    public Discussion updateDiscussion(Long id, Discussion discussionDetails) {
        Discussion discussion = discussionRepository.findById(id)
                .orElseThrow(() -> new DiscussionNotFoundException("Discussion not found for this id :: " + id));
        discussion.setText(discussionDetails.getText());
        discussion.setHashTags(processHashTags(discussionDetails.getHashTags()));
        discussionRepository.save(discussion);
        return discussionSearchRepository.save(discussion);
    }

    @Transactional
    public void deleteDiscussion(Long id) {
        discussionRepository.deleteById(id);
        discussionSearchRepository.deleteById(id);
    }

    public List<Discussion> listDiscussionsByTag(String tag) {
        return discussionSearchRepository.findByHashTags_Tag(tag);
    }

    public List<Discussion> listDiscussionsByText(String text) {
        return discussionSearchRepository.findByTextContaining(text);
    }

    private Set<HashTag> processHashTags(Set<HashTag> hashTags) {
        Set<HashTag> processedHashTags = new HashSet<>();
        for (HashTag hashTag : hashTags) {
            HashTag existingHashTag = hashTagRepository.findByTag(hashTag.getTag());
            if (existingHashTag != null) {
                processedHashTags.add(existingHashTag);
            } else {
                processedHashTags.add(hashTagRepository.save(hashTag));
            }
        }
        return processedHashTags;
    }
}