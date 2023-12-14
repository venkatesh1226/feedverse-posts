package com.feedverse.posts.repository;

import com.feedverse.posts.model.UserFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserFollower, Long> {
    @Query("SELECT COUNT(p) FROM Post p WHERE p.username = :username")
    Long getUserPostsCount(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserFollower uf WHERE uf.username = :username AND uf.follower = :follower")
    void deleteByFollowerAndUsername(@Param("username") String username, @Param("follower") String follower);

}
