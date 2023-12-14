package com.feedverse.posts.repository;

import com.feedverse.posts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p LEFT JOIN Connection con ON p.username = con.target.username AND con.source.username = :currentUser WHERE p.username = :currentUser OR con.target.username IS NOT NULL ORDER BY p.createdAt DESC")
    List<Post> findFeedForCurrentUser(@Param("currentUser") String currentUser);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Post p WHERE p.id = :postId AND p.username = :username")
    boolean existsByIdAndUsername(@Param("postId") Long postId, @Param("username") String username);

    @Query("SELECT p FROM Post p WHERE p.username = :username ORDER BY p.createdAt DESC")
    List<Post> getPostsByUsername(@Param("username") String username);

    @Query("SELECT COUNT(p) FROM Post p WHERE p.username = :username")
    Long getUserPostsCount(@Param("username") String username);
}
