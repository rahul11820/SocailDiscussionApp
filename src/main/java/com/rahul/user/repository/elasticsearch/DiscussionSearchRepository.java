package com.rahul.user.repository.elasticsearch;

import com.rahul.user.entity.Discussion;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionSearchRepository extends ElasticsearchRepository<Discussion, Long> {
    List<Discussion> findByHashTags_Tag(String tag);
    List<Discussion> findByTextContaining(String text);
    Discussion save(Discussion discussion);
    void deleteById(Long id);
}
