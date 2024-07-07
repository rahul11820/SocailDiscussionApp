package com.rahul.user.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "`users`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @Column(unique = true)
    private String mobileNo;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "followingUser")
    private Set<Follower> followers = new HashSet<>();

    @OneToMany(mappedBy = "followedUser")
    private Set<Follower> following = new HashSet<>();

    @OneToMany
    private List<Discussion> discussionList;
}
