package com.rahul.user.repository.jpa;

import com.rahul.user.entity.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTag, Long> {
    HashTag findByTag(String tag);
}